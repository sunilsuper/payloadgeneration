package com.org.generatepayload.impl;

import org.json.JSONObject;

import com.org.generatepayload.FileEntity;

public interface  JsonFileWriterImpl {
	 public  void fileWriter (JSONObject jsonObject,String outputDir,FileEntity entity);
}
