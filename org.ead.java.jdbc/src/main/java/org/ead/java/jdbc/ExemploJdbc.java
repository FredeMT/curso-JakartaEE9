package org.ead.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.ead.java.jdbc.model.Produto;
import org.ead.java.jdbc.repository.ProdutoRepository;
import org.ead.java.jdbc.repository.ProdutoRepositoryImpl;
import org.ead.java.jdbc.util.DataBaseConnection;

public class ExemploJdbc {

	public static void main(String[] args) {
		

		try (Connection conn = DataBaseConnection.getInstance()) {
			ProdutoRepository<Produto> repositorio = new ProdutoRepositoryImpl();
			 System.out.println("============= listar =============");
			repositorio.listar().forEach(System.out::println);
			
			System.out.println("============= buscar por id =============");
			System.out.println(repositorio.buscarPorId(1L));
			
			System.out.println("============= inserir novo produto =============");
			Produto produto = new Produto();
            produto.setNome("Teclado mecânico");
            produto.setPreco(500);
            produto.setData_registro(new Date());
            repositorio.salvar(produto);
            System.out.println("Produto salvo com sucesso!");
            repositorio.listar().forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
