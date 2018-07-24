package com.egiants.rlm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiants.rlm.dao.UserMarketingDao;
import com.egiants.rlm.entity.UserMarketing;
import com.egiants.rlm.service.UserMarketingService;

@Service
public class DefaultUserMarketingService implements UserMarketingService {

    @Autowired
    private UserMarketingDao userMarketingDao;

    @Override
    public List<UserMarketing> getMarketings() {
        return this.userMarketingDao.getMarketings();
    }

    @Override
    public UserMarketing getMarketing(String date) {
        //TODO: throw custom error if there is no record
        return this.userMarketingDao.getMarketing(date);
    }

    @Override
    public UserMarketing createMarketing(UserMarketing userMarketing) {
        return this.userMarketingDao.createMarketing(userMarketing);
    }

    @Override
    public UserMarketing updateMarketing(UserMarketing userMarketing) {
        return this.userMarketingDao.updateMarketing(userMarketing);
    }

    @Override
    public void deleteMarketing(String date) {
        //TODO: may need to throw error based on
        this.userMarketingDao.deleteMarketing(date);
    }

	@Override
	public List<UserMarketing> getMarketings(String vendorOrganizationName, String implementationPartner) {
		// TODO Auto-generated method stub
		return this.userMarketingDao.getMarketings(vendorOrganizationName,implementationPartner);
	}

	

//	@Override
//	public List<UserMarketing> getMarketingsWithCurrentDate() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
