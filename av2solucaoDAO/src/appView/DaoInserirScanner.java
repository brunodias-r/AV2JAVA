package appView;

import java.sql.SQLException;
import java.util.Scanner;
import dao.AlunoDao;
import model.Aluno;

public class DaoInserirScanner {
	public static void main(String[] args) {
		Scanner inputId = new Scanner(System.in);
		Scanner inputNome = new Scanner(System.in);
		Scanner inputEmail = new Scanner(System.in);
		Scanner inputCpf = new Scanner(System.in);
		Scanner inputNascimento = new Scanner(System.in);
		Scanner inputNaturalidade = new Scanner(System.in);
		Scanner inputEndereco = new Scanner(System.in);
		
		Aluno aluno = new Aluno();
		
		System.out.print("\nId.....................: ");
		aluno.setId(inputId.nextInt());
		System.out.print("\nNome...................: ");
		aluno.setNome(inputNome.nextLine());
		System.out.print("\nE-mail.................: ");
		aluno.setEmail(inputEmail.nextLine());
		System.out.print("\nCPF....................: ");
		aluno.setCpf(inputCpf.nextLine());
		System.out.print("\nNascimento (aaaa/mm/dd): ");
		aluno.setDataDeNascimento(inputNascimento.nextLine());//aaaa/mm/dd
		System.out.print("\nNaturalidade...........: ");
		aluno.setNaturalidade(inputNaturalidade.nextLine());
		System.out.print("\nEndereço...............: ");
		aluno.setEndereco(inputEndereco.nextLine());
		
		try {
			AlunoDao dao = new AlunoDao();
			dao.adicionar(aluno);
			System.out.println("Inserção realizada com êxito!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

