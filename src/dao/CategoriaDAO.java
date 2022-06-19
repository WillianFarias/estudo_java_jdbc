package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listarTodasCategorias() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT * FROM CATEGORIA";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Categoria categoria = criarCategoria(rst);
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	private Categoria criarCategoria(ResultSet rst) throws SQLException {
		Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
		return categoria;
	}

	public List<Categoria> listaCategoriasComProdutos() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		Categoria ultimaCategoria = null;
		String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						if (ultimaCategoria == null || !ultimaCategoria.getNome().equals(rst.getString(2))) {
							Categoria categoria = criarCategoria(rst);
						ultimaCategoria = categoria;
						categorias.add(categoria);
					}
						Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
						ultimaCategoria.adicionar(produto);
				}
			}
		}
		return categorias;
	}
}