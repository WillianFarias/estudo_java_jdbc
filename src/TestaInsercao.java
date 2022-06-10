import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = ConnectionFactory.recuperaConexao();
		//assumindo o controle do commit que antes estava no JDBC
		connection.setAutoCommit(Boolean.FALSE);
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

		adicionarVariavel("TV", "GIGANTE", stm);
		adicionarVariavel("MICROONDAS", "BRANCO", stm);
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O Id inserido foi: " + id);
		}
	}

}
