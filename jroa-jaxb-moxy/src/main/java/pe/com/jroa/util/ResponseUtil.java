package pe.com.jroa.util;

import java.util.HashMap;
import java.util.Map;

import pe.com.jroa.xml.AuthorResponseXml;
import pe.com.jroa.xml.ResponseXml;

public class ResponseUtil {

	private static Map<String, ResponseXml> listResponses = new HashMap<String, ResponseXml>();
	
	static{
		listResponses.put("AuthorResponse", new AuthorResponseXml());
	}
	
	
	public static Map<String, String> getTagsEnvelope(String xmlStringResponse){
		String nameResponse = getNameResponse(xmlStringResponse);
		
		ResponseXml response = listResponses.get(nameResponse);
		
		return response.getTagsEnvelope();
	}
	
	private static String getNameResponse(String xmlStringResponse){
		
		for(Map.Entry<String, ResponseXml> item : listResponses.entrySet()){
			if (xmlStringResponse.contains( item.getKey())){
				return item.getKey();
			}
		}
		return null;
	}
}
