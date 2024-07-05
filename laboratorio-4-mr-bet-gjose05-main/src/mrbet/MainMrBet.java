package mrbet;

import java.util.Scanner;

/**
* Interface com menus texto para manipular o sistema FilmNow.
* 
* @author Guilherme Jose
*
*/
public class MainMrBet {
		
	public static void main(String[] args) {
			
		MrBetSistema mbs = new MrBetSistema();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, mbs, scanner);
		}
	}
		
	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	
	private static String menu(Scanner scanner) {
		System.out.println("(M)Minha inclusão de times\n" 
							+ "(R)Recuperar time\n" 
							+ "(.)Adicionar campeonato\n" 
							+ "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" 
							+ "(E)Exibir campeonatos que o time participa\n" 
							+ "(T)Tentar a sorte e status\n"
							+ "(!)Já pode fechar o programa!\n"
							+ "\n"+ "Opção>\n"
							+ "");
		return scanner.nextLine().toUpperCase();
	}
		
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param mbs  O sistema MrBet que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	
	private static void comando(String opcao, MrBetSistema mbs, Scanner scanner) {
		switch (opcao) {
		case "M":
			adicionaTimes(mbs, scanner);
			break;
		case "R":
			recuperaTime(mbs,scanner);
			break;
			case ".":
			adicionaCampeonato(mbs, scanner);
			break;
		case "B":
			incluiTimeVerifica(mbs, scanner);
			break;
		case "E":
			exibeCampeonatosTimes(mbs, scanner);
			break;
		case "T":
			fazBet(mbs,scanner);
			break;
		case "!":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * adiciona times no sistema
	 * @param mbs
	 * @param scanner
	 */
	
	private static void adicionaTimes(MrBetSistema mbs,Scanner scanner) {
		System.out.println("Código: ");
		String codigo = scanner.nextLine();
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Mascote: ");
		String mascote = scanner.nextLine();
		System.out.println(mbs.cadastraTime(codigo, nome, mascote));
	}
	
	/**
	 * recupera times no sistema atraves do codigo
	 * @param mbs
	 * @param scanner
	 */

	private static void recuperaTime(MrBetSistema mbs, Scanner scanner) {
		System.out.println("Código: ");
		String codigo = scanner.nextLine();
		System.out.println(mbs.recuperaCodigo(codigo));
	}
	
	/**
	 * cria um campeonato com a quantidade de participantes
	 * @param mbs
	 * @param scanner
	 */
	
	private static void adicionaCampeonato(MrBetSistema mbs, Scanner scanner) {
		System.out.println("Campeonato: ");
		String nome = scanner.nextLine();
		System.out.println("Participantes: ");
		String qntParticipantes = scanner.nextLine();
		System.out.println(mbs.adicionaCampeonato(nome, Integer.parseInt(qntParticipantes)));
	}
	
	/**
	 * inclui time no campeonato ou 
	 * @param mbs
	 * @param scanner
	 */
	
	private static void incluiTimeVerifica(MrBetSistema mbs, Scanner scanner) {
		System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
		String escolha = scanner.nextLine().toUpperCase();
		System.out.println("Codigo: ");
		String codigo = scanner.nextLine();
		System.out.println("Campeonato: ");
		String campeonato = scanner.nextLine();
		if (escolha.equals("I")){
			System.out.println(mbs.incluiNoCampeonato(codigo,campeonato));
		}
		if (escolha.equals("V")) {
				System.out.println(mbs.verificaCampeonato(codigo,campeonato));
		}
	}
	
	/**
	 * exibe os campeonatos que o time escolhido participa
	 * @param mbs
	 * @param scanner
	 */
	
	private static void exibeCampeonatosTimes(MrBetSistema mbs, Scanner scanner) {
		System.out.println("Time: ");
		String codigo = scanner.nextLine();
		System.out.println(mbs.campeonatosTimes(codigo));
	}
	
	/**
	 * cria uma aposta ou exibe as apostas feitas
	 * @param mbs
	 * @param scanner
	 */
	
	private static void fazBet(MrBetSistema mbs, Scanner scanner) {
		System.out.println("(A)Apostar ou (S)Status das Apostas?");
		String escolha = scanner.nextLine().toUpperCase();
		if (escolha.equals("A")){
			System.out.println("Codigo: ");
			String codigo = scanner.nextLine();
			System.out.println("Campeonato");
			String campeonato = scanner.nextLine();
			System.out.println("Colocação: ");
			String colocaçao = scanner.nextLine();
			System.out.println("Valor da aposta: ");
			String valor = scanner.nextLine();
			System.out.println(mbs.criaBet(codigo, campeonato, Integer. parseInt(colocaçao), valor));
		}
		if (escolha.equals("S")){
			System.out.println("Apostas: \n");
			System.out.println(mbs.getBet());
		}
	}
		
	/**
	 * sai do programa
	 */
	private static void sai() {
		System.out.println("\nPor hoje é só pessoal!");
		System.exit(0);
	}
		
}



