package br.com.guilherme.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;

@Named
@RequestScoped
public class DownloadBean implements Serializable{
	
	private StreamedContent file;
	
	public DownloadBean() {
		InputStream in = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/doc.pdf");
		file = new DefaultStreamedContent(in, "application/pdf", "download.pdf");
	}
	
	public StreamedContent getFile() {
		return file;
	}
}
