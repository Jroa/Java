package pe.com.jroa.xml;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="AuthorResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorResponseXml extends ResponseXml implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//header
	@XmlPath("transaction_header/response_datetime/text()")
	public String responseDatetime;
	
	//body
	@XmlPath("transaction_body/title/text()")
	public String title;
	
	@XmlPath("transaction_body/date_published/text()")
	public String datePublished;
	
	@XmlPath("transaction_body/form/text()")
	public String form;

	@Override
	public Map<String, String> getTagsEnvelope() {
		Map<String, String> tagsEnvelope = new HashMap<String, String>();

		tagsEnvelope.put("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">","");
		tagsEnvelope.put("</S:Envelope>","");
		
		tagsEnvelope.put("<S:Body>","");
		tagsEnvelope.put("</S:Body>","");
		
		tagsEnvelope.put("xmlns:aut=\"http://exomple/author\"","");
		tagsEnvelope.put("xmlns:lib=\"http://example/library\"","");
		
		tagsEnvelope.put("aut:","");
		tagsEnvelope.put("lib:","");

		return tagsEnvelope;
	}	
	
	
	public String getResponseDatetime() {
		return responseDatetime;
	}

	public void setResponseDatetime(String responseDatetime) {
		this.responseDatetime = responseDatetime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(String datePublished) {
		this.datePublished = datePublished;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
}
