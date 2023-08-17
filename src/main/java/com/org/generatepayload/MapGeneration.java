package com.org.generatepayload;

import java.util.HashMap;

public class MapGeneration {
	HashMap<String, String> mapd=new HashMap<String, String>();
	 String action ="A";
	 String companyId = "0918885465";
	 String companyName = "MasterCard";
	 String city="Pune";
	 String companyStatus ="22";
	 String companyType="71";
	 String officefax="testfax";
	 String officePhone="officephonetest7";
	 String otherPhone="otherphonetest7";
	String simpleIndustry="71";
	String streetAddress="777 Test EON";
	String streetAddress2="777 Test EON";
	String streetAddress3="777 Test EON";
	String streetAddress4="777 Test EON";
	String yearFounded="2022";
	String monthFounded="07";
	String dayFounded="01";
	String zipCode="411014";
	String webpage="www.xyz.com";
	String reportingTemplateTypeId="3982323";
	String	 stateId="88909";
	String countryId="213";
	String incorporationCountryId="8789";
	String incoroporationStateID="7698";
	
public  HashMap<String, String> getDefaultMap()
{
	
	mapd.put("action", action);
	mapd.put("companyId", companyId);
	mapd.put("companyName", companyName);
	mapd.put("city", city);
	mapd.put("companyStatus", companyStatus);
	mapd.put("companyType", companyType);
	mapd.put("officefax", officefax);
	mapd.put("officePhone", officePhone);
	mapd.put("otherPhone", otherPhone);
	mapd.put("simpleIndustry", simpleIndustry);
	mapd.put("streetAddress", streetAddress);
	mapd.put("streetAddress2", streetAddress2);
	mapd.put("streetAddress3", streetAddress3);
	mapd.put("streetAddress4", streetAddress4);
	mapd.put("yearFounded", yearFounded);
	mapd.put("monthFounded", monthFounded);
	mapd.put("dayFounded", dayFounded);
	mapd.put("zipCode", zipCode);
	mapd.put("webpage", webpage);
	mapd.put("reportingTemplateTypeId", reportingTemplateTypeId);
	mapd.put("stateId", stateId);
	mapd.put("incorporationCountryId", incorporationCountryId);
	mapd.put("incoroporationStateID", incoroporationStateID);
	mapd.put("countryId", countryId);
	return mapd;


}
}
