package com.bw.bolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class SenqueceBolt extends BaseBasicBolt {

	@Override
	public void execute(Tuple arg0, BasicOutputCollector arg1) {
		 String word = (String) arg0.getValue(0);  
         String out = "I'm " + word +  "!";  
         System.out.println("out=" + out);
         
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {

	}

}
