package com.egiants.rlm.dao;

import java.util.List;

import com.egiants.rlm.entity.UserMarketing;
import com.egiants.rlm.entity.UserMarketing;

public interface UserMarketingDao {

	 

	List<UserMarketing> getMarketings();

    UserMarketing getMarketing(String date);
    

    UserMarketing createMarketing(UserMarketing userMarketing);

    UserMarketing updateMarketing(UserMarketing userMarketing);

    void deleteMarketing(String date);

	List<UserMarketing> getMarketings(String vendorOrganizationName, String implementationPartner);
}
