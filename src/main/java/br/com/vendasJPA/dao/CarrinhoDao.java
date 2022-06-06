package br.com.vendasJPA.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Carrinho;
import br.com.loja.modelo.ItemDoCarrinho;
import br.com.loja.modelo.Produto;

public class CarrinhoDao<carrinho> {

	private static EntityManager em;

	public CarrinhoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Carrinho carrinho) {
		this.em.persist(carrinho);
	}

	public List<carrinho> buscarTodos() {
		String jpql = "SELECT p FROM Carrinho p";
		return em.createQuery(jpql).getResultList();
	}
	


}
