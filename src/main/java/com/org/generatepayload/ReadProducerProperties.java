package com.org.generatepayload;

import java.io.FileInputStream;
import java.util.Properties;

import com.org.generatepayload.impl.ReadProducerPropertiesImpl;

public class ReadProducerProperties implements ReadProducerPropertiesImpl {
	
	   public  Properties readPropertiesFile(String fileName) {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(Exception fnfe) {
	         fnfe.printStackTrace();
	      }
	    
	      return prop;
	   }


	

}
