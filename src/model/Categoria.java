package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos;

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria: " + getNome() + " Id: " + getId();
	}

	public Integer getId() {
		if (id == null) {
			id = new Integer(0);
		}
		return this.id;
	}

	public String getNome() {
		if (nome == null) {
			nome = new String("");
		}
		return this.nome;
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			produtos = new ArrayList<Produto>();
		}
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void adicionar(Produto produto) {
		getProdutos().add(produto);
	}

}
