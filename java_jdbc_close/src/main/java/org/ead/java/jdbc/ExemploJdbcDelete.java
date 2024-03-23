package org.ead.java.jdbc;

import org.ead.java.jdbc.model.Produto;
import org.ead.java.jdbc.repository.ProdutoRepository;
import org.ead.java.jdbc.repository.ProdutoRepositoryImpl;

public class ExemploJdbcDelete {

	public static void main(String[] args) {
		
			ProdutoRepository<Produto> repositorio = new ProdutoRepositoryImpl();
			 System.out.println("============= listar =============");
			repositorio.listar().forEach(System.out::println);
			
			System.out.println("============= buscar por id =============");
			System.out.println(repositorio.buscarPorId(1L));
			
			System.out.println("============= Excluir produto =============");
			repositorio.deletar(3L);
            System.out.println("Produto excluído com sucesso!");
            repositorio.listar().forEach(System.out::println);
	}

}
