package pe.com.jroa.soap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pe.com.jroa.util.JsonUtil;
import pe.com.jroa.util.XmlUtil;
import pe.com.jroa.xml.AuthorRequestXml;
import pe.com.jroa.xml.AuthorResponseXml;

public class SoapComunicationTest {

	
	private AuthorRequestXml createRequestAuthorDummy(){
		AuthorRequestXml request = new AuthorRequestXml();
		request.setRequestDatetime("2016-10-20T10:30:48.000");
		request.setId("1");
		request.setName("Howard Phillips");
		request.setLastname("Lovecraft");
		
		return request;
	}
	
	
	private AuthorResponseXml createResponseAuthorDummy(){
		AuthorResponseXml response = new AuthorResponseXml();
		response.setResponseDatetime("2016-04-13 12:36:15.222");
		response.setTitle("The Call of Cthulhu");
		response.setDatePublished("Feb 1928");
		response.setForm("Short story");
		
		return response;
	}
	
	
	@Test
	public void testGenerateXmlStringRequestOfAuthor(){
		SoapComunication soap = new SoapComunication();
		AuthorRequestXml authorRequestXml = createRequestAuthorDummy();
		
		String generatedXml = soap.generateRequestXmlString(authorRequestXml);
		String expectedXml = XmlUtil.LoadStringXmlFromFile("/pe/com/jroa/xml/authorrequest.xml");
		
		generatedXml = XmlUtil.cleanString(generatedXml);
		expectedXml = XmlUtil.cleanString(expectedXml);
		
		//System.out.println(generatedXml);
		//System.out.println(expectedXml);
		
		assertEquals(expectedXml, generatedXml);
	}
	
	
	@Test
	public void testGenerateObjectFromResponseXmlString(){
		SoapComunication soap = new SoapComunication();
		String xmlStringResponse= XmlUtil.LoadStringXmlFromFile("/pe/com/jroa/xml/authorresponse.xml");
		
		AuthorResponseXml expectedResponse = createResponseAuthorDummy();
		AuthorResponseXml generatedResponse = (AuthorResponseXml) soap.generateObjectFromResponseXmlString(xmlStringResponse);
		
		String expectedJson = JsonUtil.convertObjectToJson(expectedResponse);
		String generateJson= JsonUtil.convertObjectToJson(generatedResponse);
		
		expectedJson = XmlUtil.cleanString(expectedJson);
		generateJson= XmlUtil.cleanString(generateJson);
		
		//System.out.println(expectedJson);
		//System.out.println(generateJson);
		
		assertEquals(expectedJson, generateJson);
	}
}
