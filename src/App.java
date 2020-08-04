import java.util.List;
import java.util.Scanner;

public class App {

	private static Scanner scan;

	public static void main(String[] args) {
		
		Album album = new Album();
		Conta conta = new Conta();
		scan = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("===================================");
			System.out.println("Projeto 7 a 1 em JAVA");
			System.out.println("===================================");
			System.out.println("1. Comprar Album.");
			System.out.println("2. Listar as figurinhas coladas.");
			System.out.println("3. Colar Figurinha.");
			System.out.println("4. Verificar se a Figurinha esta colada.");
			System.out.println("5. Listar as figurinhas que faltam.");
			System.out.println("0. Sair.");
			opcao = scan.nextInt();
			
			if(opcao == 1) {
				Album album1 = new Album();
				System.out.println("Informe o seu codigo:");
				String codigo = scan.next();
				album1.setCodigo(codigo);
				Album albumEncontrado = conta.verificarExistenciaAlbum(codigo);
				if(albumEncontrado != null) {
					System.out.println("\n*****************************************************");
					System.out.println("Desculpe, o codigo desse album já foi adquirido");
					System.out.println("*****************************************************");
				}else {
					conta.salvar(album1);
					System.out.println("\n*****************************************************");
					System.out.println("Album adquirido com sucesso");
					System.out.println("*****************************************************");
				}
			}
			
			if(opcao == 2) {
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					List<Figurinha> listFig = contaEncontrada.getFigurinhas();
					System.out.println("\n**********************************");
					System.out.println("Figurinhas já obtidas");
					System.out.println("**********************************");
					for(Figurinha a : listFig) {
						System.out.println("Numero: " + a.getNumero());
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não Encontrada");
					System.out.println("**********************************");
				}
			}
			
			if(opcao == 3) {
				Figurinha figurinha = new Figurinha();
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					System.out.println("Informe o numero da Figurinha:");
					String fig = scan.next();
					Boolean numeroValidado = album.validarNumero(fig);
					if(numeroValidado == true) {
						System.out.println("\n*****************************************");
						System.out.printf("A figurinha numero %s informada é invalida", fig);
						System.out.println("\n*****************************************");
					}else {
						Figurinha figEncontrada = album.verificarFigurinhaExiste(fig);
						figurinha.setNumero(fig);
						if(figEncontrada != null) {
							System.out.println("\n**********************************");
							System.out.printf("Você já possui a figurinha numero %s", fig + "\n");
							System.out.println("**********************************");
						}else {
							contaEncontrada.setFigurinhas(figurinha);
							contaEncontrada.colarFigurinha(figurinha);
							System.out.println("\n**********************************");
							System.out.printf("Figurinha numero %s", fig + " adicionada ao album\n");
							System.out.println("**********************************");
						}
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não Encontrada");
					System.out.println("**********************************");
				}
			}
			
			if(opcao == 4) {
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					System.out.println("Informe o numero da figurinha: ");	
					String figura = scan.next();
					Figurinha figurinhaVerificada = album.verificarFigurinhaExiste(figura);
					if(figurinhaVerificada != null) {
						System.out.println("\n**********************************");
						System.out.printf("Voçe ja possui a figurinha numero %s ", figura);
						System.out.println("\n**********************************");
					}else {
						System.out.println("\n**********************************");
						System.out.printf("Voçe não possui a figurinha numero %s ", figura);
						System.out.println("\n**********************************");
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não encontrado");
					System.out.println("\n**********************************");
				}
			}
			
			if(opcao == 5) {
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				album.verificarFigurinhasFaltantes(contaEncontrada);
			}
			
		}while(opcao != 0);{
			System.out.println("===================================");
			System.out.println("Projeto finalizado");
			System.out.println("===================================");
			System.exit(0);
		}

	}
}
