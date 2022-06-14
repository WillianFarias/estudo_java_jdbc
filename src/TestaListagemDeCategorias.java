import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import model.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			 CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			 List<Categoria> listaDeCategorias = categoriaDAO.listarTodasCategorias();
			 listaDeCategorias.stream().forEach(System.out::println);
		}
	}
}
