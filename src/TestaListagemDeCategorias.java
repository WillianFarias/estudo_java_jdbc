import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import model.Categoria;
import model.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			 CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			 List<Categoria> listaDeCategorias = categoriaDAO.listarTodasCategorias();
			 listaDeCategorias.stream().forEach(ct -> {
				 System.out.println(ct.getNome());
				 try {
					for(Produto produto : new ProdutoDAO(connection).buscar(ct)) {
						 System.out.println(ct.getNome() +  " - " + produto.getNome());
					 }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 });
		}
	}
}
