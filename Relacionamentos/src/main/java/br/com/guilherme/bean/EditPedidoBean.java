package br.com.guilherme.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.guilherme.ebj.ClienteBean;
import br.com.guilherme.ebj.PedidoBean;
import br.com.guilherme.ebj.ProdutoBean;
import br.com.guilherme.model.Cliente;
import br.com.guilherme.model.Produto;

@Named
@RequestScoped
public class EditPedidoBean implements Serializable{
	
	@EJB
	private PedidoBean pedidoBean;
	
	@EJB
	private ProdutoBean produtoBean;
	
	@EJB
	private ClienteBean clienteBean;
	
	private List<Cliente> clientes;
	private List<Produto> produtos;
	
	private Integer selectedClienteId;
	private Integer[] selectedProdutosIds;
	
	@PostConstruct
	public void init() {
		clientes = clienteBean.listar();
		produtos = produtoBean.listar();
	}
	
	public String cadastrarPedido() throws Exception{
		pedidoBean.cadastrar(selectedClienteId, selectedProdutosIds);
		return "pedidos?faces-redirect=true";
	}

	public PedidoBean getPedidoBean() {
		return pedidoBean;
	}

	public void setPedidoBean(PedidoBean pedidoBean) {
		this.pedidoBean = pedidoBean;
	}

	public ProdutoBean getProdutoBean() {
		return produtoBean;
	}

	public void setProdutoBean(ProdutoBean produtoBean) {
		this.produtoBean = produtoBean;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Integer getSelectedClienteId() {
		return selectedClienteId;
	}

	public void setSelectedClienteId(Integer selectedClienteId) {
		this.selectedClienteId = selectedClienteId;
	}

	public Integer[] getSelectedProdutosIds() {
		return selectedProdutosIds;
	}

	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) {
		this.selectedProdutosIds = selectedProdutosIds;
	}
	
	
}
