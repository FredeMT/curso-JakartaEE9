package org.ead.java.jdbc.model;

import java.util.Date;

public class Produto {
	
	private Long id;
	private String nome;
	private Integer preco;
	private Date data_registro;
	
	@Override
	public String toString() {
		return id + " | " + nome + " | " + preco + " | " + data_registro ;
	}

	public Produto() {
	}

	public Produto(Long id, String nome, Integer preco, Date data_registro) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.data_registro = data_registro;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPreco() {
		return preco;
	}
	public void setPreco(Integer preco) {
		this.preco = preco;
	}
	public Date getData_registro() {
		return data_registro;
	}
	public void setData_registro(Date data_registro) {
		this.data_registro = data_registro;
	}

}
