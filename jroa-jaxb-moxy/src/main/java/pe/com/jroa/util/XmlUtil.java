package pe.com.jroa.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
}
