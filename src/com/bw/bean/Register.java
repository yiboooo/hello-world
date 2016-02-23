package com.bw.bean;

public class Register {
	private String channelid;
	private String  cpid;
	private String createtime;
	private String gameid;
	private String id;
	private String imei;
	
	private String imsi;
	private String name;
	private String password;
	private String totalbalance;
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public String getCpid() {
		return cpid;
	}
	public void setCpid(String cpid) {
		this.cpid = cpid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getGameid() {
		return gameid;
	}
	public void setGameid(String gameid) {
		this.gameid = gameid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTotalbalance() {
		return totalbalance;
	}
	public void setTotalbalance(String totalbalance) {
		this.totalbalance = totalbalance;
	}
	@Override
	public String toString() {
		return "Register [channelid=" + channelid + ", cpid=" + cpid + ", createtime=" + createtime + ", gameid="
				+ gameid + ", id=" + id + ", imei=" + imei + ", imsi=" + imsi + ", name=" + name + ", password="
				+ password + ", totalbalance=" + totalbalance + "]";
	}
	
	
}
