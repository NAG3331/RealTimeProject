package com.egiants.rlm.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.egiants.rlm.entity.UserMarketing;

@Service
    public interface UserMarketingService {
	
    
	    List<UserMarketing> getMarketings(String vendorOrganizationName, String implementationPartner);
	    List<UserMarketing> getMarketings();  

	    UserMarketing getMarketing(String date);
	    
	

	    UserMarketing createMarketing(UserMarketing userMarketing);

	    UserMarketing updateMarketing(UserMarketing  userMarketing);

	    void deleteMarketing(String date);

	}



