package br.com.guilherme.bean;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import br.com.guilherme.model.Cadastro;

@Named("form")
@RequestScoped
public class FormBean implements Serializable{
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	private Cadastro cadastro = new Cadastro();
	
	private String jsonStr;
	
	public String parseJson() {
		
		try (JsonParser parser = Json.createParser(new StringReader(jsonStr))){
			String key = null;
			boolean isArray = false;
			while(parser.hasNext()) {
				
				Event event = parser.next();
				
				switch(event) {
				case KEY_NAME:
					key = parser.getString();
					break;
				case VALUE_STRING:
					String valueStr = parser.getString();
					if(!isArray) {
						switch(key) {
						case "nome" : cadastro.setNome(valueStr); break;
						case "dataNascimento" : cadastro.setDataNascimento(LocalDate.parse(valueStr, FORMATTER)); break;
						case "rua" : cadastro.getEndereco().setRua(valueStr); break;
						}
					} else {
						cadastro.getInteresses().add(valueStr);
					}
					break;
				case VALUE_NUMBER:
					int valueInt = parser.getInt();
					switch (key) {
					case "idade" : cadastro.setIdade(valueInt); break;
					case "numero" : cadastro.getEndereco().setNumero(valueInt);
					}
					break;
				case VALUE_TRUE:
					cadastro.setCasado(true); break;
				case VALUE_FALSE:
					cadastro.setCasado(false); break;
				case START_ARRAY:
					isArray = true; break;
				case END_ARRAY:
					isArray = false; break;
				default:
					break;
				}
			}
		}
		
		return null;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
	
	
}
