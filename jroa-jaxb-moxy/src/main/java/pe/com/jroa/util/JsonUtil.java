package pe.com.jroa.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	public static String convertObjectToJson(Object object){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(object);
	}	
}
