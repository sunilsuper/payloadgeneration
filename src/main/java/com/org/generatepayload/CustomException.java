package com.org.generatepayload;

public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4893497884833491170L;

	public CustomException(String str) {
		// calling the constructor of parent Exception
		super(str);
	}
}
