package com.org.generatepayload.impl;

import java.util.HashMap;

import com.org.generatepayload.CustomException;

public interface ValidatorsImpl{
	void validateCompanyId(String CompanyId) throws CustomException ;
	void validateYear(String year) throws CustomException;
	void validateMonth(int month) throws CustomException;
	void validateDay(int day) throws CustomException;
	void validateZipcode(String zipCode) throws CustomException;
	void validateDate(HashMap<?, ?> map) throws CustomException;

}
