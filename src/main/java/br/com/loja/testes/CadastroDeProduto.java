package br.com.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.vendasJPA.dao.CarrinhoDao;
import br.com.vendasJPA.dao.ItensDao;
import br.com.vendasJPA.dao.ProdutoDao;
import br.com.loja.modelo.Carrinho;
import br.com.loja.modelo.ItemDoCarrinho;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAutil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAutil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p2 -> System.out.println(p2.getNome()));
		
		List<Produto> todos1 = produtoDao.buscarPorNome("CELULARES");
		for(Produto produto : todos1) {
		System.out.println(produto.getNome());
		}
	}

	private static void cadastrarProduto() {
		Carrinho carrinho = new Carrinho();
		
		Produto Frigideira = new Produto("Frigideira", new BigDecimal("80"), new BigDecimal("80"));
		ItemDoCarrinho Eletrodoméstico = new ItemDoCarrinho(Frigideira, 1, carrinho);
		
		EntityManager em = JPAutil.getEntityManager();
		CarrinhoDao carrinhoDao = new CarrinhoDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ItensDao itensdao = new ItensDao(em);
		
		em.getTransaction().begin();
		carrinhoDao.cadastrar(carrinho);
		itensdao.cadastrar(Eletrodoméstico);
		produtoDao.cadastrar(Frigideira);
		em.getTransaction().commit();
		em.close();
	}

}
