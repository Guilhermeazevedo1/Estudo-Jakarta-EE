package br.com.guilherme.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import br.com.guilherme.model.Cadastro;

@Named("form")
@RequestScoped
public class FormBean {
	private Cadastro cadastro = new Cadastro();
	
	private String jsonStr;
	
	public String parseJson() {
		Jsonb jsonb = JsonbBuilder.create();
		jsonb.fromJson(jsonStr, Cadastro.class);
		
		return null;
	}
	
	public String convertToJson() {
		
		JsonbConfig config = new JsonbConfig().withFormatting(true);
		Jsonb jsonb = JsonbBuilder.create();
		jsonb.toJson(cadastro);
		
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
