package org.ead.java.jdbc.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.ead.java.jdbc.model.Produto;
import org.ead.java.jdbc.util.DataBaseConnection;

public class ProdutoRepositoryImpl implements ProdutoRepository<Produto>{
	
	private Connection getConnection() throws SQLException {
		return DataBaseConnection.getInstance();
	}

	@Override
	public List<Produto> listar() {
		List<Produto> produtos = new ArrayList<Produto>();
		try (Statement stmt = getConnection().createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM produtos")){
			while(rs.next()) {
				Produto p = criarProduto(rs);
				produtos.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}

	@Override
	public Produto buscarPorId(Long id) {
		Produto produto = null;
		try(PreparedStatement stmt = getConnection()
				.prepareStatement("SELECT * FROM produtos WHERE id = ?")) {
			stmt.setLong(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					produto = criarProduto(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}

	@Override
	public void salvar(Produto produto) {
		String sql = null;
		if (produto.getId() != null && produto.getId() > 0) {
			sql = "	UPDATE produtos SET nome=?, preco=? WHERE id=?";
		} else {
			sql = "INSERT INTO produtos(nome, preco, data_registro) VALUES(?,?,?)";
		}
		try(PreparedStatement stmt = getConnection().prepareStatement(sql)) {
			stmt.setString(1, produto.getNome());
			stmt.setLong(2, produto.getPreco());
			if (produto.getId() != null && produto.getId() > 0) {
				stmt.setLong(3, produto.getId());
			} else {
				stmt.setDate(3, new Date(produto.getData_registro().getTime()));
			}
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void deletar(Long id) {
		try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM produtos WHERE id=?")) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Produto criarProduto(ResultSet rs) throws SQLException {
		Produto p = new Produto();
		p.setId(rs.getLong("id"));
		p.setNome(rs.getString("nome"));
		p.setPreco(rs.getInt("preco"));
		p.setData_registro(rs.getDate("data_registro"));
		return p;
	}

}
