package org.ead.java.jdbc.repository;

import java.util.List;

public interface ProdutoRepository<T> {
	List<T> listar();
	
	T buscarPorId(Long id);
	
	void salvar(T t	);
	
	void deletar(Long id);

}
