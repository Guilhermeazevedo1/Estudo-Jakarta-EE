package br.com.guilherme.bean;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import javax.xml.rpc.encoding.Serializer;
import br.com.guilherme.model.Despesa;


@Named("table")
@SessionScoped
public class TableBean implements Serializable{
	
	private List<Despesa> despesasList = new ArrayList<>();
	private ListDataModel<Despesa> despesas = new ListDataModel<>(despesasList);
	
//	public TableBean() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		
//		Despesa d = new Despesa();
//		
//		d.setData(sdf.parse("15/12/2023"));
//		d.setDescricao("Uma descrição qualquer");
//		d.setValor(13.50);
//		d.setEdit(false);
//		despesasList.add(d);
//		
//		d = new Despesa();
//		
//		d.setData(sdf.parse("15/12/2024"));
//		d.setDescricao("Uma descrição qualquer 2");
//		d.setValor(200.50);
//		d.setEdit(false);
//		despesasList.add(d);
//	}
	
	public String inserir() {
		Despesa d = new Despesa();
		d.setEdit(true);
		despesasList.add(d);
		return null;
	}
	
	public String editar(Despesa despesa){
		despesa.setEdit(true);
		return null;
	}
	
	public String gravar(Despesa despesa) {
		despesa.setEdit(false);
		return null;
	}
	
	public String excluir(Despesa despesa) {
		despesasList.remove(despesa);
		return null;
	}
	
	public ListDataModel<Despesa> getDespesas(){
		return despesas;
	}
	
	
}
