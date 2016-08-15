package dev.zero.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import dev.zero.model.AdCampaign;
import dev.zero.model.Status;

@Component
public class AdService2Impl implements AdService{

	private Map<String,List<AdCampaign>> adData;
	
	public AdService2Impl() {
		adData = new HashMap<String,List<AdCampaign>>();
	}
	
	@Override
	public Status saveAd(AdCampaign adCampaign) {
		adCampaign.setCurrestTimestamp(System.currentTimeMillis());
		adCampaign.setAdStatus("ACTIVE");
		List<AdCampaign> listOfCampaign = adData.get(adCampaign.getPartner_id());
		boolean active = false;
		Status status= new Status("200", "Ad created at "+new Date(adCampaign.getCurrestTimestamp() ));
		
		if(listOfCampaign!=null){
			for(AdCampaign camp : listOfCampaign){
				if("ACTIVE".equalsIgnoreCase(camp.getAdStatus())){
					active= true;
				}
			}
		}else{
			listOfCampaign = new ArrayList<AdCampaign>();	
		}	
		if(!active){
			listOfCampaign.add(adCampaign);
			adData.put(adCampaign.getPartner_id(), listOfCampaign);
			
		}else{
			status.setStatusCode("400");
			status.setMessage("ACTIVE Ad Campaign exists for the partner!");
		}
		return status;
	}

	@Override
	public AdCampaign getAd(String partnerId) {
		List<AdCampaign> adList = adData.get(partnerId);
		AdCampaign ad1= null;
		if(adList!=null){
			for(AdCampaign camp : adList){
				if("ACTIVE".equalsIgnoreCase(camp.getAdStatus())){
					ad1 = camp;
				}
			}
		}
		
		return ad1;
	}

	@Override
	public Map<String, List<AdCampaign>> getAllAds() {
		// TODO Auto-generated method stub
		return adData;
	}



}
