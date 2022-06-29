package appView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.AlunoDao;
import dao.InterfaceDao;
import model.Aluno;

public abstract class OpcoesAluno implements InterfaceDao{

	public static void main(String[] args) {
		Scanner opcao = new Scanner(System.in);
		int opcaoSelecionada;
		for( ; ; ) {
			System.out.println();
			System.out.println("1 - INSERIR");
			System.out.println("2 - LISTAR TODOS OS ALUNOS");
			System.out.println("3 - REMOVER");
			System.out.println("4 - PESQUISAR PELA LETRA");
			System.out.println("5 - SAIR");
			System.out.print("SELECIONE UMA OPÇÃO: ");
			opcaoSelecionada = opcao.nextInt();
			switch(opcaoSelecionada) {
				//Inserção
				case 1:{
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
					break;
				}
				//Listagem
				case 2:{
					try {
						AlunoDao listarAlunos = new AlunoDao();
						List<Aluno> alunos = listarAlunos.listar();
						Aluno aluno = new Aluno();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
				//Remoção
				case 3:{
					break;
				}
				//Pesquisa por iniciais
				case 4:{ 
					try {
						AlunoDao pesquisarAluno = new AlunoDao();
						Aluno aluno = new Aluno();
						Scanner inputLetra = new Scanner(System.in);
						System.out.print("INSERIR LETRA PARA PESQUISA: ");
						String letras = inputLetra.nextLine();
						System.out.println();
						pesquisarAluno.ListarPelaLetra(aluno, letras);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
				//Saída
				case 5:{
					break;
				}
			}
		}


	}

}
