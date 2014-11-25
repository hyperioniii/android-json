package com.json.getdata;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

	public static List<Phone> listJson(String json) {
		try {
			List<Phone> list;
			Type type = new TypeToken<List<Phone>>(){}.getType();
			Gson gson  = new Gson();
			list = gson.fromJson(json, type);
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
}
