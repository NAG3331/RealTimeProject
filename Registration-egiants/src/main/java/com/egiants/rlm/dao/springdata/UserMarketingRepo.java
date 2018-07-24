package com.egiants.rlm.dao.springdata;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import com.egiants.rlm.entity.UserMarketing;
import com.egiants.rlm.entity.UserCallDetails;

@EnableScan
public interface UserMarketingRepo extends DynamoDBCrudRepository<UserMarketing, String> {

	Iterable<UserMarketing> findByVendorOrganizationNameAndImplementationPartner(String vendorOrganizationName, String implementationPartner);

}

	          