package com.dp.utils;

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static String objectToJson(Object obj) {
		JsonGenerator jsonGenerator = null;
		String jsonStr = null;
		try {
			StringWriter stringWriter = new StringWriter();
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					stringWriter);
			jsonGenerator.writeObject(obj);
			jsonStr = stringWriter.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jsonGenerator != null) {
				try {
					jsonGenerator.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonStr;
	}
}
