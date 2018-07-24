package com.egiants.rlm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AbstractAmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.egiants.rlm.Exceptions.MismatchIdentifierException;
import com.egiants.rlm.entity.UserMarketing;
import com.egiants.rlm.entity.User;
import com.egiants.rlm.service.UserMarketingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/marketings")
@Api(value = "Registration", description = "Operations pertaining to users")
public class MarketingController {
	

    @Autowired
    private UserMarketingService userMarketingService;


    @ApiOperation(value = "List of Marketings")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserMarketing>> getMarketings() {
        return new ResponseEntity<>(this.userMarketingService
                .getMarketings(), HttpStatus.OK);
    }


    @ApiOperation(value = "Get Marketing with date")
    @RequestMapping(value = "/Marketing/{date:.+}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserMarketing> getMarketing(
            @PathVariable("date") String date) {

        return new ResponseEntity<>(this.userMarketingService
                .getMarketing(date), HttpStatus.OK);
    }
//    @ApiOperation(value = "Get Marketing with Current date")
//    @RequestMapping(value = "/Marketing/FollowUpsToday}",
//            method = RequestMethod.GET, produces = {
//            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<UserMarketing> getMarketingWithCurrentdate(
//            @PathVariable("date") String date) {
//
//        return new ResponseEntity<>(this.userMarketingService
//                .getMarketing(date), HttpStatus.OK);
//    }
    
    

    @ApiOperation(value = "Get Marketing Details with different attributes")
    @RequestMapping(value = "/getMarketingWithAttributes/{vendorOrganizationName}/{implementationPartner}",
            method = RequestMethod.GET,consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    
    public ResponseEntity<List<UserMarketing>> getMarketings(@PathVariable("vendorOrganizationName") String vendorOrganizationName, @PathVariable("implementationPartner") String implementationPartner) {
        return new ResponseEntity<>(this.userMarketingService
                .getMarketings(vendorOrganizationName,implementationPartner), HttpStatus.OK);
    }
    
//    public Map<String ,AttributeValue> getSupervisor(@PathVariable String vendorOrganizationName, @PathVariable String client) {
//    	
//    	AmazonDynamoDB clientvar = AmazonDynamoDBClientBuilder.standard()
//    			.withRegion(Regions.US_EAST_1).build();
//    	DynamoDB dynamoDB = new DynamoDB(clientvar);    	
//    	
//    	List<Map<String,AttributeValue>> items = new ArrayList<>();         
//        Map<String,String> expressionAttributesNames = new HashMap<>();
//        expressionAttributesNames.put("#vendorOrganizationName","vendorOrganizationName");
//        expressionAttributesNames.put("#client","client");
//        Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
//        expressionAttributeValues.put(":vendorOrganizationName",new AttributeValue().withS(vendorOrganizationName));
//        expressionAttributeValues.put(":client",new AttributeValue().withS(client));
//        QueryRequest queryRequest = new QueryRequest()
//                .withTableName("Calls")
//                .withKeyConditionExpression("#vendorOrganizationName = :vendorOrganizationName and #client = :client ")
//                .withIndexName("date")
//                .withExpressionAttributeNames(expressionAttributesNames)
//                .withExpressionAttributeValues(expressionAttributeValues);
//        QueryResult queryResult =  ((AmazonDynamoDB) dynamoDB).query(queryRequest);
//        List<Map<String,AttributeValue>> attributeValues = queryResult.getItems();
//        if(attributeValues.size()>0) {
//           for (Map<String, AttributeValue> map : attributeValues) {
//        	   
//        	   System.out.println(map);
//			
//		}
//            } else {
//                return null;
//                }
//            }
    
    @ApiOperation(value = "Update Marketing")
    @RequestMapping(value = "/Marketing/{emailId:.+}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserMarketing> createMarketing(
            @PathVariable("emailId") String emailId, @RequestBody UserMarketing UserMarketing) {

//        if (!date.equals(Marketing.getdate())) {
//            throw new MismatchIdentifierException(emailId);
//        }

        return new ResponseEntity<>(this.userMarketingService.createMarketing(UserMarketing), HttpStatus.OK);
    }
    @ApiOperation(value = "Update Marketing")
    @RequestMapping(value = "/Marketing/{emailId:.+}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserMarketing> updateMarketing(
            @PathVariable("emailId") String emailId, @RequestBody UserMarketing UserMarketing) {

//        if (!date.equals(Marketing.getdate())) {
//            throw new MismatchIdentifierException(emailId);
//        }

        return new ResponseEntity<>(this.userMarketingService.updateMarketing(UserMarketing), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User")
    @RequestMapping(value = "/{date:.+}", method = RequestMethod.DELETE, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<Void> deleteMarketing(@PathVariable("date") String date) {

        this.userMarketingService.deleteMarketing(date);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
