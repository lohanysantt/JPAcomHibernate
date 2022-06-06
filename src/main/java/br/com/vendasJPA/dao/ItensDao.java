package br.com.vendasJPA.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Carrinho;
import br.com.loja.modelo.ItemDoCarrinho;

public class ItensDao {
	private EntityManager em;

	public ItensDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(ItemDoCarrinho item) {
		this.em.persist(item);
	}
	
	public List <ItemDoCarrinho>findbyCarrinho(Carrinho carrinho){
		 String jpql = "SELECT j FROM ItemDoCarrinho j WHERE j.carrinho = :carrinho";
		return em.createQuery(jpql, ItemDoCarrinho.class).getResultList();		
	}
	
	public void atualizar(ItemDoCarrinho item) {
		this.em.merge(item);
	}

	public void remover(ItemDoCarrinho item) {
		this.em.remove(item);
	}
	
	
	
	public ItemDoCarrinho atualizaQuantidade(ItemDoCarrinho item, int quantidade) {
		
		if(item.getIdItem() == null) {
			item.setQtd_item(quantidade);
			cadastrar(item);
			return item;
			
		} else {
			item.setQtd_item(quantidade);
			atualizar(item);
			return item;
		}
	}
}