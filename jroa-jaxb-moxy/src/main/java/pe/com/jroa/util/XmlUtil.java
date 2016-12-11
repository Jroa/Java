package pe.com.jroa.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XmlUtil {

	public static String cleanString(String cadena){
		return cadena.replaceAll("\\s", "");
	}	
	
	public static String LoadStringXmlFromFile(String rutaArchivoXml){
		
		String xmlStringArchivo = "";
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(XmlUtil.class.getResourceAsStream(rutaArchivoXml),"UTF-8"));
			
			String linea=br.readLine();
			while(linea!=null){
				xmlStringArchivo += linea + "\n";
	            linea=br.readLine();
	        }
			br.close();
			
			return xmlStringArchivo;
		} catch (IOException e) {
			
			e.printStackTrace();
			return "";
		}				
	}
	
	public static Document convertStringToXmlDocument(String xmlString) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;  
        try  
        {  
        	factory.setNamespaceAware(true);
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlString ) ) ); 
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }	
}
