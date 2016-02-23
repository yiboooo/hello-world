package com.bw.spout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class FileSpout extends BaseRichSpout {
	
	private static final long serialVersionUID = 1L;
	
	private SpoutOutputCollector collector;
	private BufferedReader fileReader;
	
	@Override
	public void nextTuple() {
		String line = null;  
//		System.out.println("xxxxxxx");
		try {
			if ((line = fileReader.readLine()) != null)
			{ 
				if (line !=null)
				{
					JSONObject jobject=JSON.parseObject(line);
					String p=(String)jobject.get("P").toString();
					String o=(String)jobject.get("O").toString();
					
					String t=(String)jobject.get("T").toString();

					System.out.println(this.toString()+"FileSpout line:P{"+p+"},O{"+o+"}");
					collector.emit(new Values(p,o),t);
				}          
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
		System.out.println("FileSpout open!");
		collector=arg2;

//		String file="e:\\data\\gc_bc_linux230_2016010813.json";.
		String file=this.getClass().getResource("/").getPath()+"resources/gc_bc_linux230_2016010813.json";
		System.out.println("aaaaa:"+file);
		try {
			this.fileReader = new BufferedReader(new FileReader(new File(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		arg0.declare(new Fields("type","msg"));
	}

	@Override
	public void ack(Object msgId) {
		System.out.println("OK:"+msgId);
	}

	@Override
	public void fail(Object msgId) {
		System.out.println("FAIL:"+msgId);
	}

}
