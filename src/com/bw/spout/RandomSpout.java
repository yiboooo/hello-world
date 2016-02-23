package com.bw.spout;

import java.util.List;
import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class RandomSpout extends BaseRichSpout {

	private  SpoutOutputCollector collector;
	private static String[] words={"happy","good","yiboooo"};
	private static int count=1;
	
	@Override
	public void nextTuple() {
		
		System.out.println("~~~~~~~~~~~~~~~~~~:"+System.nanoTime());
		
		String word=words[new Random().nextInt(words.length)];
		List<Integer>  list=collector.emit(new Values(word),System.currentTimeMillis()+Math.random());
		
		System.out.println("###################:"+word);
		for(Integer i:list){
			System.out.println("################### i:"+i);
		}
		count++;
		
		if(count>10){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
		}
		
	}

	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
		this.collector=arg2	;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		arg0.declare(new Fields("randomstring"));
	}

	@Override
	public void ack(Object msgId) {
		// TODO Auto-generated method stub
		System.out.println("################### ack:"+msgId);
	}

	@Override
	public void fail(Object msgId) {
		System.out.println("################### fail:"+msgId);
	}
	
	

}
