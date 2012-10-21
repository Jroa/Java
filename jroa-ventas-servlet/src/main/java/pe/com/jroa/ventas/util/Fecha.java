package pe.com.jroa.ventas.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Fecha {
	public static java.sql.Date dateFromUtilToSql(Date fecha){
		java.sql.Date date = new java.sql.Date(fecha.getTime());
		return date;
	}
	
	public static Date getDateFromString(String fecha){
		Date date = null;
		try{
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			date = (Date) formato.parse(fecha);
			return date;
		}catch(Exception ex){
			return date;
		}
	}
}
