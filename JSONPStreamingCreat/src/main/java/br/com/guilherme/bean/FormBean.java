package br.com.guilherme.bean;

import java.io.Serializable;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;

import br.com.guilherme.model.Cadastro;

@Named("form")
@RequestScoped
public class FormBean implements Serializable{
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	private Cadastro cadastro = new Cadastro();
	
	private String jsonStr;
	
	public String convertToJson() {
		StringWriter out = new StringWriter();
		
		// forma que não fica identado
		//try (JsonGenerator g = Json.createGenerator(out)){
		
		// forma para deixar o json identado
		JsonGeneratorFactory genFactory = Json.createGeneratorFactory(Map.of(JsonGenerator.PRETTY_PRINTING, true));	
		try (JsonGenerator g = genFactory.createGenerator(out)){	
			g.writeStartObject()
				.write("nome", cadastro.getNome())
				.write("idade", cadastro.getIdade())
				.write("dataNascimento", cadastro.getDataNascimento().format(FORMATTER))
				.write("casado", cadastro.getCasado())
				.writeStartObject()
					.write("rua", cadastro.getEndereco().getRua())
					.write("numero", cadastro.getEndereco().getNumero())
					.writeEnd()
					.writeStartArray("interesses");
					
			cadastro.getInteresses().forEach(i -> g.write(i));
			
			g.writeEnd().writeEnd();
		}
		
		jsonStr = out.toString();
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
