package br.com.guilherme.ejb;

import javax.ejb.Stateless;

@Stateless
public class TemperatureConverterBean{ //implements TemperatureConverter se for usar a interface 

	public double convertCelsiusToFahrenheit(double tc) {
		// TODO Auto-generated method stub
		return 9 * (tc / 5) + 32;
	}

}
