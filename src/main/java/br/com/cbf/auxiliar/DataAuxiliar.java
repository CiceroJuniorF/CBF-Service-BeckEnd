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
	
	public Calendar coverteString(String data) {
		String dataString = data;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(dataString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal;
	}
}
