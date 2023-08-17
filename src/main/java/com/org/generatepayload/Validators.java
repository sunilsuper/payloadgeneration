package com.org.generatepayload;

import java.util.HashMap;
import com.org.generatepayload.impl.ValidatorsImpl;

public class Validators implements ValidatorsImpl {

	

	@Override
	public void validateYear(String year) throws CustomException {
		// TODO Auto-generated method stub
		int years=Integer.parseInt(year);
	
		if(years<0)
		{
		  throw new CustomException("Invalid Year:"+year);
		}
	}
	@Override
	public void validateDate(HashMap map) throws CustomException {
		
	String day= map.get("dayFounded").toString();
	String month=map.get("monthFounded").toString();
	String year=map.get("yearFounded").toString();
	String dateStr=year+"-"+month+"-"+day;
	
		DateValidatorUsingLocalDate validator = new DateValidatorUsingLocalDate();
		if(!validator.isValid(dateStr))
		{
		  throw new CustomException("Invalid Year:"+year);
		}
	}
	@Override
	public void validateMonth(int month) throws CustomException {
		// TODO Auto-generated method stub
		if(month<0||month>12)
		{
			throw new CustomException("Invalid Month:"+month);
		}
	}

	@Override
	public void validateDay(int day) throws CustomException {
		// TODO Auto-generated method stub
		if(day<0||day>31)
		{
			throw new CustomException("Invalid day:"+day);
		}
	}

	@Override
	public void validateZipcode(String zipCode) throws CustomException {
		// TODO Auto-generated method stub
		if(!zipCode.matches("[1-9][0-9]{5,6}"))
		{
		  throw new CustomException("Invalid Zip Code:"+zipCode);
		}
	}

	@Override
	public void validateCompanyId(String CompanyId) throws CustomException {
		if(!CompanyId.matches("[1-9][0-9]{9,12}"))
		{
		  throw new CustomException("Invalid Company Id:"+CompanyId);
		}
		
	}

}
