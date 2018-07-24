package com.egiants.rlm.entity;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

@DynamoDBTable(tableName="Calls")
public class UserMarketing {
	
	 @NotNull(message = "date Can't be Null")
	    private String date;
		 @NotNull(message = "vendorOrganizationName Can't be Null")
		private String vendorOrganizationName;
		 @NotNull(message = "vendorContactPerson Can't be Null")
	    private String vendorContactPerson;
		 @NotNull(message = "contactNumber Can't be Null")
	    private int contactNumber;
		 @NotNull(message = "contactEmailid Can't be Null")
	    private String contactEmailid;
		 @NotNull(message = "jobLocation Can't be Null")
			private String jobLocation;
		 @NotNull(message = "jobPosition Can't be Null")
			private String jobPosition;
		 @NotNull(message = "implementationPartner Can't be Null")		 
	    private String implementationPartner;
		 @NotNull(message = "client Can't be Null")
	    private String client;
		 @NotNull(message = "comments Can't be Null")
	    private String comments;
	
	
	private String createdBy;
	private String lastModifiedBy;
	
	@DynamoDBHashKey(attributeName = "date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
//
//	@DynamoDBAttribute(attributeName = "CreatedBy")
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	@DynamoDBAttribute(attributeName = "LastModifiedBy")
//	public String getLastModifiedBy() {
//		return lastModifiedBy;
//	}
//	public void setLastModifiedBy(String lastModifiedBy) {
//		this.lastModifiedBy = lastModifiedBy;
//	}
	@DynamoDBAttribute(attributeName = "vendorOrganizationName")
	public String getVendorOrganizationName() {
		return vendorOrganizationName;
	}
	public void setVendorOrganizationName(String vendorOrganizationName) {
		this.vendorOrganizationName = vendorOrganizationName;
	}
	@DynamoDBAttribute(attributeName = "vendorContactPerson")
	public String getVendorContactPerson() {
		return vendorContactPerson;
	}
	public void setVendorContactPerson(String vendorContactPerson) {
		this.vendorContactPerson = vendorContactPerson;
	}
	@DynamoDBAttribute(attributeName = "contactNumber")
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	@DynamoDBAttribute(attributeName = "contactEmailid")
	public String getContactEmailid() {
		return contactEmailid;
	}
	public void setContactEmailid(String contactEmailid) {
		this.contactEmailid = contactEmailid;
	}
	
	
	@DynamoDBAttribute(attributeName = "jobLocation")
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	
	@DynamoDBAttribute(attributeName = "jobPosition")
	public String getJobPosition() {
		return jobPosition;
	}
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	@DynamoDBAttribute(attributeName = "implementationPartne")
	public String getImplementationPartner() {
		return implementationPartner;
	}
	public void setImplementationPartner(String implementationPartner) {
		this.implementationPartner = implementationPartner;
	}
	@DynamoDBAttribute(attributeName = "client")
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	@DynamoDBAttribute(attributeName = "comments")
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
