package appView;

import java.sql.SQLException;
import java.util.Scanner;
import dao.AlunoDao;
import model.Aluno;

public class DaoInserirScanner {
	public static void main(String[] args) {
		Scanner inputData = new Scanner(System.in);
		Aluno aluno = new Aluno();
		
		System.out.print("\nId.....................: ");
		aluno.setId(inputData.nextInt());
		System.out.print("\nNome...................: ");
		aluno.setNome(inputData.nextLine());
		System.out.print("\nE-mail.................: ");
		aluno.setEmail(inputData.nextLine());
		System.out.print("\nCPF....................: ");
		aluno.setCpf(inputData.nextLine());
		System.out.print("\nNascimento (aaaa/mm/dd): ");
		aluno.setDataDeNascimento(inputData.nextLine());//aaaa/mm/dd
		System.out.print("\nNaturalidade...........: ");
		aluno.setNaturalidade(inputData.nextLine());
		System.out.print("\nEndereço...............: ");
		aluno.setEndereco(inputData.nextLine());
		
		try {
			AlunoDao dao = new AlunoDao();
			dao.adicionar(aluno);
			System.out.println("Inserção realizada com êxito!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

