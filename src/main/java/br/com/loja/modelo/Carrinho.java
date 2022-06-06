package br.com.loja.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrinho_compras")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrinho;
	
	@OneToMany(mappedBy = "idItem" )
	private List<ItemDoCarrinho> itens;

	public List<ItemDoCarrinho> getItens() {
		return itens;
	}

	public void setItens(List<ItemDoCarrinho> itens) {
		this.itens = itens;
	}

	public Long getId() {
		return idCarrinho;
	}
	

	public Carrinho() {
	}
	
	
	
}
