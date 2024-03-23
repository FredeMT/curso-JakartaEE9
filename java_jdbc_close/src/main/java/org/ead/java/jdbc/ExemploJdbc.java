package org.ead.java.jdbc;

import java.util.Date;

import org.ead.java.jdbc.model.Categoria;
import org.ead.java.jdbc.model.Produto;
import org.ead.java.jdbc.repository.ProdutoRepository;
import org.ead.java.jdbc.repository.ProdutoRepositoryImpl;

public class ExemploJdbc {

	public static void main(String[] args) {

			ProdutoRepository<Produto> repositorio = new ProdutoRepositoryImpl();
			 System.out.println("============= listar =============");
			repositorio.listar().forEach(System.out::println);
			
			System.out.println("============= buscar por id =============");
			System.out.println(repositorio.buscarPorId(1L));
			
			System.out.println("============= inserir novo produto =============");
			Produto produto = new Produto();
            produto.setNome("Teclado Red Dragon mecânico");
            produto.setPreco(700);
            produto.setData_registro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            produto.setCategoria(categoria);
            repositorio.salvar(produto);
            System.out.println("Produto salvo com sucesso!");
            repositorio.listar().forEach(System.out::println);
	}

}
