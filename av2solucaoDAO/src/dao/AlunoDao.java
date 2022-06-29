package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bancodedados.ConnectionFactory;
import model.Aluno;

public class AlunoDao {
	private final Connection con;
	
	public AlunoDao() throws SQLException {
		this.con = ConnectionFactory.getConnection();		
	}
	
	public void adicionar(Aluno aluno) throws SQLException {
		String sql;
		sql = "insert into alunos (id, nome, email, cpf, dataDeNascimento, naturalidade, endereco) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
	
		stmt.setInt(1,aluno.getId());
		stmt.setString(2,aluno.getNome());
		stmt.setString(3,aluno.getEmail());
		stmt.setString(4,aluno.getCpf());
		stmt.setString(5,aluno.getDataDeNascimento());//aaaa/mm/dd
		stmt.setString(6,aluno.getNaturalidade());
		stmt.setString(7,aluno.getEndereco());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public List<Aluno> listar() throws SQLException{
		List<Aluno> alunos = new ArrayList<Aluno>();
		String sql = "select * from alunos";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Aluno aluno = new Aluno();
				
				System.out.println("Id..............: "+rs.getInt(1));
				System.out.println("Nome............: "+rs.getString(2));
				System.out.println("E-mail..........: "+rs.getString(3));
				System.out.println("CPF.............: "+rs.getString(4));
				System.out.println("Nascimento......: "+rs.getString(5));
				System.out.println("Naturalidade....: "+rs.getString(6));
				System.out.println("Endereço........: "+rs.getString(7));
				System.out.println("=========================================");

				alunos.add(aluno);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e);
		}
		stmt.close();
		con.close();
		return alunos;
	}
	
	public void ListarPelaLetra(Aluno aluno, String letras) {
		String sql = "SELECT * FROM alunos WHERE nome like '"+letras+"%'";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			Aluno alunos = new Aluno();

			while(rs.next()) {
					
				System.out.println("Id..............: "+rs.getInt(1));
				System.out.println("Nome............: "+rs.getString(2));
				System.out.println("E-mail..........: "+rs.getString(3));
				System.out.println("CPF.............: "+rs.getString(4));
				System.out.println("Nascimento......: "+rs.getString(5));
				System.out.println("Naturalidade....: "+rs.getString(6));
				System.out.println("Endereço........: "+rs.getString(7));
				System.out.println("=========================================");

			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e);
		}
	}
}
