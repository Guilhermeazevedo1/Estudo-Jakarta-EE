package br.com.guilherme.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;

//@Local
//@Remote
public interface TemperatureConverter {
	
	public double convertCelsiusToFahrenheit(double tc);
}
