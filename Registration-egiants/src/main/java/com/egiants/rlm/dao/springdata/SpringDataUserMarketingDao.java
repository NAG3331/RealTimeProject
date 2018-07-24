package com.egiants.rlm.dao.springdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egiants.rlm.dao.UserMarketingDao;
import com.egiants.rlm.dao.config.DynamoDbConfig;
import com.egiants.rlm.entity.UserMarketing;
import com.egiants.rlm.entity.User;
@Repository
public class SpringDataUserMarketingDao implements UserMarketingDao {
	@Autowired
	DynamoDbConfig dynamoDbConfig;
	@Autowired
	private UserMarketingRepo userMarketingRepo;

	@Override
	public List<UserMarketing> getMarketings() {
		Iterable<UserMarketing> userMarketings = this.userMarketingRepo.findAll();

        return (List<UserMarketing>) userMarketings;
	}

	@Override
	public UserMarketing getMarketing(String date) {
		// TODO Auto-generated method stub
		return this.userMarketingRepo.findOne(date);
	}

	@Override
	public UserMarketing createMarketing(UserMarketing userMarketing) {
		 return this.userMarketingRepo.save(userMarketing);
	}

	@Override
	public UserMarketing updateMarketing(UserMarketing userMarketing) {
		// TODO Auto-generated method stub
		return this.userMarketingRepo.save(userMarketing);//customUpdate(user);
	}

	@Override
	public void deleteMarketing(String date) {
		this.userMarketingRepo.delete(date);
		
	}

	@Override
	public List<UserMarketing> getMarketings(String vendorOrganizationName, String implementationPartner) {
		// TODO Auto-generated method stub
		Iterable<UserMarketing> userMarketings = 
				this.userMarketingRepo.findByVendorOrganizationNameAndImplementationPartner(vendorOrganizationName, implementationPartner);

        return (List<UserMarketing>) userMarketings;
	}



}
