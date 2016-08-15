package dev.zero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AdCampaign {
	
	private String partner_id;
	private String duration;
	private String ad_content;
	@JsonIgnore
	private long currestTimestamp;
	
	private String adStatus;
	
	
	public String getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getAd_content() {
		return ad_content;
	}
	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	public long getCurrestTimestamp() {
		return currestTimestamp;
	}
	public void setCurrestTimestamp(long currestTimestamp) {
		this.currestTimestamp = currestTimestamp;
	}
	public String getAdStatus() {
		long time = this.getCurrestTimestamp() + Integer.parseInt(this.getDuration());
		if(time < System.currentTimeMillis()){
			this.setAdStatus("EXPIRED");
		}
		return adStatus;
	}
	public void setAdStatus(String adStatus) {
		this.adStatus = adStatus;
	}
	
	
	

}
