import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = ConnectionFactory.recuperaConexao()) {

			try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?")) {

				stm.setInt(1, 2);
				stm.execute();

				Integer linhasModificadas = stm.getUpdateCount();
				System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);
			}
		}
	}
}