package appView;

import java.sql.SQLException;
import dao.AlunoDao;
import model.Aluno;

public class TesteDaoInsere {
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setId(100);
		aluno.setNome("Maria Schnaidder");
		aluno.setEmail("maria97@gmail.com");
		aluno.setCpf("12345678901");
		aluno.setDataDeNascimento("19970328");//aaaa/m/d
		aluno.setNaturalidade("Rio de Janeiro");
		aluno.setEndereco("Rua José Campos, 341");
		
//		aluno.setId(101);
//		aluno.setNome("José Campos");
//		aluno.setEmail("josec@gmail.com");
//		aluno.setCpf("12345678902");
//		aluno.setDataDeNascimento("19980427");//aaaa/m/d
//		aluno.setNaturalidade("Espírito Santo");
//		aluno.setEndereco("Rua Independência, 185");
		
		try {
			AlunoDao dao = new AlunoDao();
			dao.adicionar(aluno);
			System.out.println("Inserção realizada com êxito!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
