package br.com.cbf.auxiliar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataAuxiliar {
	
	public static Calendar dataAtual() {
		return Calendar.getInstance();
	}
	
	public static Calendar adicionaMes() {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);		
		return cal;
	}
	
	public static Calendar coverteString(String data) {
		
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		 
		Calendar c = Calendar.getInstance();
		 
		
		try {
			c.setTime(formatoData.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return c;
	}
}
