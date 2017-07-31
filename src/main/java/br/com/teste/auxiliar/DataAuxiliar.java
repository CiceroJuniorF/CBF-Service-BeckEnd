package br.com.teste.auxiliar;

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
}
