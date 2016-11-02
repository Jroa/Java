package pe.com.jroa.xml;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="{aut}AuthorRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorRequestXml extends RequestXml implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//header
	@XmlPath("{aut}transaction_header/{lib}request_datetime/text()")
	private String requestDatetime;
	
	//body
	@XmlPath("{aut}transaction_body/{aut}author_id/text()")
	private String id;
	
	@XmlPath("{aut}transaction_body/{aut}author_name/text()")
	private String name;
	
	@XmlPath("{aut}transaction_body/{aut}author_lastname/text()")
	private String lastname;
	
	
	@Override
	public String getTagsEnvelope() {
		String lineBreak = "\n";
		
		StringBuffer xml = new StringBuffer();
		xml.append("<soapenv:Envelope" + lineBreak);
		xml.append("" + lineBreak);
		xml.append("	xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"" + lineBreak);
		xml.append("	xmlns:aut=\"http://exomple/author\"" + lineBreak);
		xml.append("	xmlns:lib=\"http://example/library\">" + lineBreak);
		xml.append("" + lineBreak);
		xml.append("	<soapenv:Header/>" + lineBreak);
		xml.append("	<soapenv:Body>" + lineBreak);
		xml.append("" + lineBreak);
		xml.append("	{OBJECT_XML}" + lineBreak);
		xml.append("" + lineBreak);
		xml.append("	</soapenv:Body>" + lineBreak);
		xml.append("</soapenv:Envelope>" + lineBreak);	
		
		return xml.toString();
	}
	
	@Override
	public Map<String, String> getTagsNameSpaces() {
		Map<String, String> nameSpaces = new LinkedHashMap<String,String>();
		nameSpaces.put("{aut}", "aut:");
		nameSpaces.put("{lib}", "lib:");
		nameSpaces.put("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","");		
		return nameSpaces;
	}	
	
	
	public String getRequestDatetime() {
		return requestDatetime;
	}
	public void setRequestDatetime(String requestDatetime) {
		this.requestDatetime = requestDatetime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
