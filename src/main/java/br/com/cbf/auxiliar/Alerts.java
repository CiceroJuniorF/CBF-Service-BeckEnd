package br.com.cbf.auxiliar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alerts {
	
	private String alert;
	

	public Alerts(String alert) {
		this.alert = alert;
	}

	public String getAlert() {
		return alert;
	}
	
	
	
	
	
}
