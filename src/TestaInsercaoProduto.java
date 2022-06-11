import java.sql.Connection;
import java.sql.SQLException;

import dao.ProdutoDAO;
import model.Produto;

public class TestaInsercaoProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Comoda", "Comoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			new ProdutoDAO(connection).salvar(comoda);
		}
	}
}
