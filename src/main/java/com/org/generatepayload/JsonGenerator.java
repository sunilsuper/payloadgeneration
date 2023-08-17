package com.org.generatepayload;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.generatepayload.impl.JsonGeneratorImpl;
import com.org.generatepayload.impl.ValidatorsImpl;

public class JsonGenerator implements JsonGeneratorImpl{
	private static final Logger log = LoggerFactory.getLogger(JsonGenerator.class);
	ValidatorsImpl validated=new Validators(); 
	public void run(FileEntity entity) {
		LoadProperties prop=new LoadProperties();
		entity = prop.loadProperty(entity);
		String filePath = entity.getDatafilePath();
		String schemaPath = entity.getSchemaPath();
		Path path = Paths.get(schemaPath);
		String lineSpilter = entity.getLineSpilter();
		String coloumnSpilter = entity.getColoumnSpilter();
		String dataColumnDetails = entity.getDataColumnDetails();
		String outputDir = entity.getOutputDir();
		
		try {

			String s = Files.readString(path);
			fileDataReader(s, filePath, lineSpilter, coloumnSpilter, dataColumnDetails, outputDir, entity);
			// System.out.println("Json data details:" + jsonObject2.toString(4));

		} catch (Exception e) {
			log.info("Issue while processing files:" + e.getMessage());
		}
	}

	public void generateJsonFromSchema(String jsonSchema, HashMap<String, String> datamap, String outputDir, FileEntity entity) throws Exception {
		
		JSONObject schemaObject = new JSONObject(jsonSchema);
		JSONObject properties = schemaObject.getJSONObject("properties");
		JSONObject jsonObject = new JSONObject();
		String type = null;
		String datatype = null;
		JsonFileWriter jsonWriter=new JsonFileWriter();
		HashMap dateDetails=new HashMap();
				

		for (String key : properties.keySet()) {
			JSONObject property = properties.getJSONObject(key);
			try {
				type = property.getString("type");
			} catch (JSONException e) {
				JSONArray types = property.getJSONArray("type");
				datatype = types.getString(0);
				type = datatype;
			}

			switch (type) {
			case "string":
				String sdata=null;
				if(datamap.get(key)!=null)
				{
					sdata=datamap.get(key).trim();
				}
				
				jsonObject.put(key, sdata);
				break;
			case "integer":
				int data=Integer.parseInt((datamap.get(key).trim()));
				if(key.equalsIgnoreCase("zipCode"))
				{
					String valid=datamap.get(key).trim();
					validated.validateZipcode(valid);
				}
				if(key.equalsIgnoreCase("yearFounded"))
				{
					String valid=datamap.get(key).trim();
					validated.validateYear(valid);
					
					dateDetails.put(key, valid);
				}
				if(key.equalsIgnoreCase("monthFounded"))
				{
					dateDetails.put(key, data);
					validated.validateMonth(data);
				}
				if(key.equalsIgnoreCase("dayFounded"))
				{
					dateDetails.put(key, data);
					validated.validateDay(data);
				}
				
				jsonObject.put(key, data);
				break;
			case "array":

				// JSONObject jo = new JSONObject();
				JSONArray ja = new JSONArray();
				ja.put(datamap.get(key));

				jsonObject.put(key, ja);
				break;
			case "number":
				if(key.equalsIgnoreCase("companyId"))
				{
					String valid=datamap.get(key).trim();
					validated.validateCompanyId(valid);
				}
				Number dataNumber=Long.parseLong(datamap.get(key).trim());
				jsonObject.put(key, dataNumber);
				break;
			// Add more cases for different types as needed
			}
		}
		log.info("dateDetails Map"+dateDetails);
		validated.validateDate(dateDetails);
		
		log.info("Json String to write in file:" + jsonObject);
		jsonWriter.fileWriter(jsonObject, outputDir, entity);
	}

	private static void fileDataReader(String JsonSchema, String filePath, String lineSpilter, String coloumnSpilter,
			String datacolumndetails, String outputDir, FileEntity entity) throws Exception {
	
		JsonGenerator jsonGen=new JsonGenerator();
		try {
			String[] columnDetailsArr = datacolumndetails.split(",");
			log.info("Column Details:" + columnDetailsArr);
			if(entity.getMessageCount()<=0)
			{
				final File file = new File(filePath);

				HashMap<String, String> fileDataMap = new HashMap<String, String>();
				
				try (final Scanner scan = new Scanner(file)) {
					scan.useDelimiter(lineSpilter);
					while (scan.hasNext()) {
						String currentLine = scan.next();

					//	System.out.println("lines:" + currentLine);
						String[] strArrcolumn = currentLine.split(coloumnSpilter);
						int i = 0;
						for (String str : strArrcolumn) {
							//System.out.println(str);
							fileDataMap.put(columnDetailsArr[i], str);
							i++;
						}
						log.info("Data Map Details:" + fileDataMap);
						jsonGen.generateJsonFromSchema(JsonSchema, fileDataMap, outputDir, entity);
					}
				}
			}else
			{
				MapGeneration mapGen=new MapGeneration();
				HashMap<String, String>	map=mapGen.getDefaultMap();
				
				for (int i = 0; i < entity.getMessageCount(); i++) {
					String companyId=generateRandom(12);
					map.put("companyId", companyId);
					jsonGen.generateJsonFromSchema(JsonSchema, map, outputDir,entity);
				}
			}
			
		} finally {
			System.out.println("finish");
		}

	}
	public static String generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return new String(digits);
	}
}
