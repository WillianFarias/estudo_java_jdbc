package model;

public class Categoria {

	private Integer id;
	private String nome;

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

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria: " + getNome() + " Id: " + getId();
	}

}
