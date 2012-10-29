package pe.com.jroa.ventas.util;

public class Sexo {
	public static Boolean convertStringToBoolean(String value){
		if (value.equals("1")){
			return true;
		}else{
			return false;
		}
	}
}
