package com.org.generatepayload;

import java.io.IOException;

public class UtilityRunner {
	public static void main(String arg[]) throws IOException {
		JsonGenerator jsonGen = new JsonGenerator();
		FileEntity fl = new FileEntity();
		jsonGen.run(fl);

	}
}
