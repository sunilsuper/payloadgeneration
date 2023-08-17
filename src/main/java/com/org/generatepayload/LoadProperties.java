package com.org.generatepayload;

import java.util.Properties;

import com.org.generatepayload.impl.LoadPropertiesImpl;

public class LoadProperties implements LoadPropertiesImpl{
	public FileEntity loadProperty(FileEntity entity) {
		Properties prop;
		ReadProducerProperties ReaProp=new ReadProducerProperties();
		try {
			prop = ReaProp.readPropertiesFile("payloadgeneration.properties");
			if(entity==null)
			{
				entity=new FileEntity();
			}
			if(entity==null||entity.getSchemaPath()==null)
			{
			entity.setSchemaPath(prop.getProperty("schemaPath"));
			}
			if(entity==null||entity.getDatafilePath()==null)
			{
			entity.setDatafilePath(prop.getProperty("dataFilePath"));
			}
			if(entity==null||entity.getLineSpilter()==null)
			{
			entity.setLineSpilter(prop.getProperty("lineSpilter"));
			}
			if(entity==null||entity.getColoumnSpilter()==null)
			{
			entity.setColoumnSpilter(prop.getProperty("coloumnSpilter"));
			}
			if(entity==null||entity.getDataColumnDetails()==null)
			{
			entity.setDataColumnDetails(prop.getProperty("dataColumnDetails"));
			}
			if(entity==null||entity.getOutputDir()==null)
			{
			entity.setOutputDir(prop.getProperty("outputDir"));
			}
			if(entity==null||entity.getMessageCount()==0)
			{
			entity.setMessageCount(Integer.parseInt(prop.getProperty("messageCount")));
			}
			if(entity==null||entity.getExportType()==null)
			{
			entity.setExportType(prop.getProperty("exportType"));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return entity;
	}
}
