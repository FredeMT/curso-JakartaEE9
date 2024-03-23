package org.ead.java.jdbc;

import org.ead.java.jdbc.model.Categoria;
import org.ead.java.jdbc.model.Produto;
import org.ead.java.jdbc.repository.ProdutoRepository;
import org.ead.java.jdbc.repository.ProdutoRepositoryImpl;

public class ExemploJdbcUpdate {

	public static void main(String[] args) {
		
			ProdutoRepository<Produto> repositorio = new ProdutoRepositoryImpl();
			 System.out.println("============= listar =============");
			repositorio.listar().forEach(System.out::println);
			
			System.out.println("============= buscar por id =============");
			System.out.println(repositorio.buscarPorId(1L));
			
			System.out.println("============= atualizar produto =============");
			Produto produto = new Produto();
			produto.setId(5L);
            produto.setNome("Teclado Corsair k95 mecânico");
            produto.setPreco(650);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            produto.setCategoria(categoria);
            repositorio.salvar(produto);
            System.out.println("Produto atualizado com sucesso!");
            repositorio.listar().forEach(System.out::println);
	}

}
