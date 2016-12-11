package pe.com.jroa.soap;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Document;

import pe.com.jroa.util.ResponseUtil;
import pe.com.jroa.util.XmlUtil;
import pe.com.jroa.xml.RequestXml;
import pe.com.jroa.xml.ResponseXml;

public class SoapComunication {
	
	public String generateRequestXmlString(RequestXml request) {
		
		String xmlStringRequest;
		
		xmlStringRequest = this.generateXmlStringFromObject(request);
		xmlStringRequest = this.replaceNameSpaces(request, xmlStringRequest);
		xmlStringRequest = this.addTagsEnvelope(request,xmlStringRequest); 
		
		return xmlStringRequest;	
	}	
	

	protected String generateXmlStringFromObject(Object requestVO){
		try {
			JAXBContext ctx = JAXBContext.newInstance("pe.com.jroa.xml");

	        Marshaller m = ctx.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        StringWriter sw = new StringWriter();
	        m.marshal(requestVO, sw);
	        String xmlString = sw.toString();
	        
	        return xmlString;
	        
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	protected String replaceNameSpaces(RequestXml request,String xmlString){
		Map<String,String> nameSpaces = request.getTagsNameSpaces();
		for (Map.Entry<String, String> itemNS : nameSpaces.entrySet()){
			xmlString = xmlString.replace(itemNS.getKey(), itemNS.getValue());
		}
		return xmlString;
	}
	
	protected String addTagsEnvelope(RequestXml request, String xmlString){
		String xmlEnvelope = request.getTagsEnvelope();
		String xmlRequest = xmlEnvelope.replace("{OBJECT_XML}", xmlString);
		return xmlRequest;
	}
	
	
	public ResponseXml generateObjectFromResponseXmlString(String xmlStringResponse){
		String xmlString = this.deleteEnvelope(xmlStringResponse);
		
		Object objectResponse = this.generateObject(xmlString);
		
		return (ResponseXml) objectResponse;
	}
	
	
	protected Object generateObject(String xmlString){
		try {
			JAXBContext jc = JAXBContext.newInstance("pe.com.jroa.xml");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			
			Document documentXml = XmlUtil.convertStringToXmlDocument(xmlString);
			
			return unmarshaller.unmarshal(documentXml);

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	
	protected String deleteEnvelope(String xmlStringResponse){
		Map<String,String> tagsEnvelope = ResponseUtil.getTagsEnvelope(xmlStringResponse);
		for (Map.Entry<String, String> itemNS : tagsEnvelope.entrySet()){
			xmlStringResponse = xmlStringResponse.replace(itemNS.getKey(), itemNS.getValue());
		}
		return xmlStringResponse;		
	}
}
