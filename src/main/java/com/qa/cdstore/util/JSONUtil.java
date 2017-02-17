package com.qa.cdstore.util;

import com.google.gson.Gson;

public class JSONUtil {
	//Converts a java object to JSON and vice-versa
	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> jClass) {
		return gson.fromJson(jsonString, jClass);
	}

}