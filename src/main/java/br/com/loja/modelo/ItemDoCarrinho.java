package br.com.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemDoCarrinho")
public class ItemDoCarrinho {
	public ItemDoCarrinho() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)                                    
	private Long idItem;
	private Integer qtd_item;
	@ManyToOne
	private Produto produto; 
	
	@ManyToOne
	private Carrinho carrinho;
	
	public ItemDoCarrinho(Produto produto, int quantidade, Carrinho carrinho) {
		this.qtd_item = quantidade;
		this.produto = produto;
		this.carrinho = carrinho;
		
	}

	public Integer getQtd_item() {
		return qtd_item;
	}

	public void setQtd_item(Integer qtd_item) {
		this.qtd_item = qtd_item;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Long getIdItem() {
		return idItem;
	}
   
	
}