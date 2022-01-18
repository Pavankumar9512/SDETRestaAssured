package com.genericUtils;

import io.restassured.response.Response;

public class JsonUtility {

	public String getJsonValueData(Response response, String jsonpath)
	{
		String jsonData = response.jsonPath().get(jsonpath);
		return jsonData;
	}
}
