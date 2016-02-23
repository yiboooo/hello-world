package com.bw.topology;

import com.bw.bolt.LoginBolt;
import com.bw.bolt.RegisterBolt;
import com.bw.spout.FileSpout;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class GCTopo {

	public static void main(String[] args) throws AlreadyAliveException, InvalidTopologyException {
		TopologyBuilder builder = new TopologyBuilder();   
		builder.setSpout("spout",new FileSpout(),1);  
		
		builder.setBolt("reg", new RegisterBolt(),7).shuffleGrouping("spout"); 
		builder.setBolt("login", new LoginBolt(),7).shuffleGrouping("spout"); 
		
		
		Config conf = new Config();  
		conf.setDebug(false); 
		if (args != null && args.length > 0) {  
			conf.setNumWorkers(3);  
			StormSubmitter.submitTopology(args[0], conf, builder.createTopology()); 
		} 
		else {  
//			conf.setMessageTimeoutSecs(2);
			LocalCluster cluster = new LocalCluster();  
			cluster.submitTopology("GCTopo", conf, builder.createTopology());  
			Utils.sleep(100000);  
			cluster.killTopology("GCTopo");  
			cluster.shutdown();  
		}  
	}

}
