package appView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import bancodedados.ConnectionFactory;

public class JdbcInsere {
	public static void main(String[] args) {
		try {
			String sql = "insert into alunos (id, nome, email, cpf, dataDeNascimento, naturalidade, endereco) values(?, ?, ?, ?, ?, ?, ?)";
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1,101);
			stmt.setString(2,"José Campos");
			stmt.setString(3,"josec@gmail.com");
			stmt.setString(4,"12345678902");
			stmt.setString(5,"19980427");//aaaa/mm/dd
			stmt.setString(6,"Espírito Santo");
			stmt.setString(7,"Rua Independência, 185");
			
			stmt.execute();
			stmt.close();
			System.out.println("Gravação executada com sucesso!");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
