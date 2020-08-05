import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
			System.out.println("6. Verificar se a figurinha esta colada (Boolean).");
			System.out.println("7. Gravar figurinhas que tenho em um arquivo Txt.");
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
						figurinha.setNumero(fig);
						Figurinha figEncontrada = contaEncontrada.verificarFigurinhaExiste(fig);
						if(figEncontrada != null) {
							System.out.println("\n**********************************");
							System.out.printf("Você já possui a figurinha numero %s", fig + "\n");
							System.out.println("**********************************");
						}else {
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
					Figurinha figurinhaVerificada = contaEncontrada.verificarFigurinhaExiste(figura);
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
			
			if(opcao == 6) {
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					System.out.println("Informe o numero da figurinha: ");	
					String figura = scan.next();
					Figurinha figurinhaVerificada = contaEncontrada.verificarFigurinhaExiste(figura);
					if(figurinhaVerificada != null) {
						System.out.println("\n**********************************");
						System.out.printf("True");
						System.out.println("**********************************\n");
					}else {
						System.out.println("\n**********************************");
						System.out.printf("False");
						System.out.println("**********************************\n");
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não encontrado");
					System.out.println("\n**********************************\n");
				}
			}
			
			if(opcao == 7) {
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					File file = new File("eu_tenho.txt");
					try {
						
						if(!file.exists()) {
							file.createNewFile();
						}
						
						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);		
						List<Figurinha> listFig = contaEncontrada.getFigurinhas();
						bw.write("=======Lista de Figurinhas Obtidas========");
						bw.newLine();
						for(Figurinha a : listFig) {
							bw.write("Numero: " + a.getNumero());
							bw.newLine();
							bw.write("===========================");
							bw.newLine();
						}
						bw.close();					
					}catch(Exception e) {
							e.fillInStackTrace();
					}
					System.out.println("\n**********************************");
					System.out.println("Abra o arquivo texto criado (eu_tenho.txt)");
					System.out.println("**********************************\n");
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não Encontrada");
					System.out.println("**********************************\n");
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
