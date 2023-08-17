package com.org.generatepayload;

import java.io.FileWriter;
import java.util.Date;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.generatepayload.impl.JsonFileWriterImpl;

public class JsonFileWriter implements JsonFileWriterImpl{
	private static final Logger log = LoggerFactory.getLogger(JsonFileWriter.class);
   public void fileWriter (JSONObject jsonObject,String outputDir,FileEntity entity) {
	   String fileName = null;
      try {
    	
    	  Date date = new Date();
          long msec = date.getTime();
    	   fileName=msec+"."+entity.getExportType();
         FileWriter file = new FileWriter(outputDir+fileName);
         file.write(jsonObject.toString());
         file.close();
         System.out.println(entity.getExportType()+" file created: "+fileName);
      } catch (Exception e) {
         // TODO Auto-generated catch block
        log.info("Error while Json file generation"+e.getMessage());
      }
    
   }
}