package pe.com.jroa.xml;

import java.util.Map;

public abstract class RequestXml {

	public abstract String getTagsEnvelope();
	public abstract Map<String, String> getTagsNameSpaces();
}
