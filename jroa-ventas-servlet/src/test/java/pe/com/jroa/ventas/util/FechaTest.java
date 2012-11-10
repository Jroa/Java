package pe.com.jroa.ventas.util;


import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

public class FechaTest {

	@Test
	public void testIsNullGetDateFromString(){
		Assert.assertNull(Fecha.getDateFromString(""));
	}
	
	@Test
	public void testIsNullDateFromUtilToSqlUtil(){
		java.util.Date date =null;
		Assert.assertNull(Fecha.dateFromUtilToSql(date));
	}
	
	@Test
	public void testGetDateFromString() {
		Date FechaNacimiento = Fecha.getDateFromString("01/01/1990");
		Assert.assertEquals(Fecha.convertDateToString(FechaNacimiento), "01/01/1990");
	}
	
	@Test
	public void testDateFromUtilToSql(){
		Date fechaOrigen = Fecha.getDateFromString("01/01/1990"); 
		java.sql.Date fechaConversion = Fecha.dateFromUtilToSql(fechaOrigen);
		Assert.assertEquals(Fecha.convertDateToString(fechaConversion), "01/01/1990");
	}	
}
