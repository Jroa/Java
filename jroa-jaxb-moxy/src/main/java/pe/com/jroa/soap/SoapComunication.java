package pe.com.jroa.soap;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import pe.com.jroa.xml.RequestXml;

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
}
