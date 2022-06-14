package model;

public class Categoria {

	private Integer id;
	private String nome;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Categoria: " + getNome() + " Id: " + getId();
	}

}
