package com.egiants.rlm.entity;



import javax.validation.constraints.NotNull;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshalling;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


public class UserCallDetails {
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
	 @NotNull(message = "implementationPartner Can't be Null")
    private String implementationPartner;
	 @NotNull(message = "client Can't be Null")
    private String client;
	 @NotNull(message = "comments Can't be Null")
    private String comments;
    
//    @DynamoDBHashKey(attributeName = "date")
    public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
//	@DynamoDBAttribute(attributeName = "vendorOrganizationName")
	public String getVendorOrganizationName() {
		return vendorOrganizationName;
	}
	public void setVendorOrganizationName(String vendorOrganizationName) {
		this.vendorOrganizationName = vendorOrganizationName;
	}
//	@DynamoDBAttribute(attributeName = "vendorContactPerson")
	public String getVendorContactPerson() {
		return vendorContactPerson;
	}
	public void setVendorContactPerson(String vendorContactPerson) {
		this.vendorContactPerson = vendorContactPerson;
	}
//	@DynamoDBAttribute(attributeName = "contactNumber")
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
//	@DynamoDBAttribute(attributeName = "contactEmailid")
	public String getContactEmailid() {
		return contactEmailid;
	}
	public void setContactEmailid(String contactEmailid) {
		this.contactEmailid = contactEmailid;
	}
//	@DynamoDBAttribute(attributeName = "implementationPartne")
	public String getImplementationPartner() {
		return implementationPartner;
	}
	public void setImplementationPartner(String implementationPartner) {
		this.implementationPartner = implementationPartner;
	}
//	@DynamoDBAttribute(attributeName = "client")
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
//	@DynamoDBAttribute(attributeName = "comments")
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
		

		
}
