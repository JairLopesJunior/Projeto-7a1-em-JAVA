import java.util.List;
import java.util.Scanner;

public class App {

	private static Scanner scan;

	public static void main(String[] args) {
		
		Album album = new Album();
		Conta conta = new Conta();
		Figurinha figurinha = new Figurinha();
		scan = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("===================================");
			System.out.println("Projeto 7 a 1 em JAVA");
			System.out.println("===================================");
			System.out.println("1. Comprar Album.");
			System.out.println("2. Ver Album.");
			System.out.println("3. Colar Figurinha.");
			System.out.println("0. Sair.");
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				System.out.println("Informe o seu codigo:");
				String codigo = scan.next();
				album.setCodigo(codigo);
				conta.salvar(album);
				System.out.println("\n**********************************");
				System.out.println("Album adquirido com sucesso");
				System.out.println("**********************************");
			}
			
			if(opcao == 2) {
				System.out.println("Informe o seu codigo: ");	
				String cpfTitular = scan.next();
				Album contaEncontrada = conta.encontrar(cpfTitular);
				if (contaEncontrada != null) {
					List<Figurinha> listFig = contaEncontrada.getFigurinhas();
					for(Figurinha a : listFig) {
						System.out.println("Figurinha: " + a.getFigurinha());
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não Encontrada");
					System.out.println("**********************************");
				}
			}
			
			if(opcao == 3) {
				System.out.println("Informe o seu codigo: ");	
				String cpfTitular = scan.next();
				Album contaEncontrada = conta.encontrar(cpfTitular);
				if (contaEncontrada != null) {
					System.out.println("Informe o numero da Figurinha:");
					String fig = scan.next();
					figurinha.setFigurinha(fig);
					Figurinha a = album.encontrarFigurinhas(fig);
					System.out.println(a);
					if(a != null) {
						album.colarFigurinha(figurinha);
						System.out.println("\n**********************************");
						System.out.println("Figurinha colada com sucesso");
						System.out.println("**********************************");
					}else {
						System.out.println("\n**********************************");
						System.out.println("Você já possui esta figurinha");
						System.out.println("**********************************");
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não Encontrada");
					System.out.println("**********************************");
				}
			}
			
		}while(opcao != 0);{
			System.out.println("===================================");
			System.out.println("Projeto finalizado");
			System.out.println("===================================");
			System.exit(0);
		}

	}
}
