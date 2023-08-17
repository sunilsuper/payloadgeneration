package com.org.generatepayload.impl;

import java.util.HashMap;

import com.org.generatepayload.FileEntity;

public interface JsonGeneratorImpl {
	public abstract void run(FileEntity entity);
	public  abstract void generateJsonFromSchema(String jsonSchema, HashMap<String, String> datamap, String outputDir, FileEntity entity) throws Exception;
	
}
