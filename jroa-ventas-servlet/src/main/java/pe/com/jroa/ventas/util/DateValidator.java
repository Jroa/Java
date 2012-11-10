package pe.com.jroa.ventas.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {
	public boolean isThisDateValid(String dateToValidate, String dateFormat){
		if(dateToValidate == null){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);	
		
		try{
			Date date = sdf.parse(dateToValidate);
			//System.out.println(date);
		}catch(ParseException ex){
			//ex.printStackTrace();
			return false;
		}
		
		return true;
	}
}
