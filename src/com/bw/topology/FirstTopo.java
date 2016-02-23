package com.bw.topology;

import com.bw.bolt.SenqueceBolt;
import com.bw.spout.RandomSpout;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class FirstTopo {

	public static void main(String[] args) throws AlreadyAliveException, InvalidTopologyException {
		TopologyBuilder builder = new TopologyBuilder();   
		builder.setSpout("spout", new RandomSpout());  
		builder.setBolt("bolt", new SenqueceBolt(),5).shuffleGrouping("spout"); 
		Config conf = new Config();  
		conf.setDebug(true); 
		if (args != null && args.length > 0) { 
			conf.setNumWorkers(3);  
			StormSubmitter.submitTopology(args[0], conf, builder.createTopology());  
		} 
		else {  
			LocalCluster cluster = new LocalCluster();  
			cluster.submitTopology("firstTopo", conf, builder.createTopology());  
			Utils.sleep(100000);  
			cluster.killTopology("firstTopo");  
			cluster.shutdown();  
		}  
	}

}
