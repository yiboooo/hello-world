package com.bw.bolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class LoginBolt extends BaseBasicBolt {
	
	@Override
	public void execute(Tuple arg0, BasicOutputCollector arg1) {
		String type=arg0.getStringByField("type");

		if(type.equalsIgnoreCase("gc.bc#Login")){
			System.out.println(this.toString()+" LoginBolt execute!"+type+arg0.getStringByField("msg"));
		}else{
			System.out.println(this.toString()+"LoginBolt execute!"+type+" is stop!!!");
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {

	}

}
