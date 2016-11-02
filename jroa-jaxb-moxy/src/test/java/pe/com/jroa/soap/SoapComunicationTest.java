package pe.com.jroa.soap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pe.com.jroa.util.XmlUtil;
import pe.com.jroa.xml.AuthorRequestXml;

public class SoapComunicationTest {

	
	private AuthorRequestXml createRequestAuthorDummy(){
		AuthorRequestXml authorRequestXml = new AuthorRequestXml();
		authorRequestXml.setRequestDatetime("2016-10-20T10:30:48.000");
		authorRequestXml.setId("1");
		authorRequestXml.setName("Howard Phillips");
		authorRequestXml.setLastname("Lovecraft");
		
		return authorRequestXml;
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
}
