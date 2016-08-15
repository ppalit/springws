package dev.zero.service;

import java.util.List;
import java.util.Map;

import dev.zero.model.AdCampaign;
import dev.zero.model.Status;

public interface AdService {
	
	public Status saveAd(AdCampaign adCampaign);
	public AdCampaign getAd(String partnerId);
	public Map<String, List<AdCampaign>> getAllAds();

}
