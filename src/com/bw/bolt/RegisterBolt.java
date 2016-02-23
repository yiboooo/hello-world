package com.bw.bolt;

import com.alibaba.fastjson.JSON;
import com.bw.bean.Register;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class RegisterBolt extends BaseBasicBolt {
	
	@Override
	public void execute(Tuple arg0, BasicOutputCollector arg1) {
		String type=arg0.getStringByField("type");

		if(type.equalsIgnoreCase("gc.bc#Reg")){
			Register bean=JSON.parseObject(arg0.getStringByField("msg"), com.bw.bean.Register.class);
			
			System.out.println(bean.toString());
			System.out.println(this.toString()+"LoginBolt execute!"+type+arg0.getStringByField("msg"));
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//				}
//			System.out.println("Thread.sleep(3000)");
		}else{
			System.out.println(this.toString()+"LoginBolt execute!"+type+" is stop!!!");
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {

	}

}
