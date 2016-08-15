package dev.zero.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.zero.model.AdCampaign;
import dev.zero.model.Status;
import dev.zero.service.AdService;

@RestController
public class AdCampaignController {

	@Autowired
	private AdService adService;
	public AdService getAdService() {
		return adService;
	}

	public void setAdService(AdService adService) {
		this.adService = adService;
	}
	
  
    @RequestMapping(value="/ad", method=RequestMethod.POST)
    public Status postAdForPartnerId(@RequestBody  AdCampaign adCampaign,HttpServletResponse response) {
    	System.out.println("----"+adCampaign.getPartner_id());
    	Status st = adService.saveAd(adCampaign);
    	if("200".equals(st.getStatusCode())){
    		response.setStatus(HttpStatus.CREATED.value());
    	}else{
    		response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
    	}
        return st;
        
    }
  
    
    @RequestMapping(value="/ad/{partnerId}", method=RequestMethod.GET,produces = "application/json")
    public AdCampaign getAdForPartnerId(@PathVariable String partnerId,HttpServletResponse response) {
    	AdCampaign campain = adService.getAd(partnerId);
    	if(campain != null){
    		response.setStatus(HttpStatus.OK.value());
    	}else{
    		response.setStatus(HttpStatus.BAD_REQUEST.value());
    	}
        return campain;
    }

    
    @RequestMapping(value="/ad", method=RequestMethod.GET)
    public Map<String,List<AdCampaign>> getAllAds(HttpServletResponse response) {
    	
        return (Map<String, List<AdCampaign>>) adService.getAllAds();
        
    }
	
}
