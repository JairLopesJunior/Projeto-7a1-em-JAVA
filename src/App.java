import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
			System.out.println("\n===================================");
			System.out.println("Projeto 7 a 1 em JAVA");
			System.out.println("===================================");
			System.out.println("1. Comprar Album.");
			System.out.println("2. Comprar Pacotinho de Figurinhas.");
			System.out.println("3. Colar Figurinha.");
			System.out.println("4. Verificar se a Figurinha esta colada.");
			System.out.println("5. Verificar se a figurinha esta colada (Boolean).");
			System.out.println("6. Listar as figurinhas que faltam.");
			System.out.println("7. Gravar figurinhas que tenho em um arquivo Txt (eu_tenho.txt).");
			System.out.println("8. Gravar figurinhas que faltam em um arquivo Txt (faltantes.txt).");
			System.out.println("9. Gravar figurinhas Repetidas que tenho em um arquivo Txt (repetidas.txt).");
			System.out.println("10. Ler o arquivo txt (eu_tenho.txt).");
			System.out.println("11. Ler o arquivo txt (faltantes.txt).");
			System.out.println("12. Ler o arquivo txt (repetidas.txt).");
			System.out.println("13. Ver as figurinhas Repetidas.");
			System.out.println("14. Verificar se ja tem a figurinha nas repetidas. (Boolean).");
			System.out.println("15. Listar as figurinhas coladas.");
			System.out.println("16. Trocar Figurinha.");
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
					System.out.println("Album adquirido com sucesso\n");
					System.out.println("*****************************************************");
				}
			}
			
			if(opcao == 2) {
				PacotinhoFigurinha pacotinho = new PacotinhoFigurinha();
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					pacotinho.comprarPacotinhoFigurinha(contaEncontrada);
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não Encontrada");
					System.out.println("**********************************\n");
				}	
			}	
			
			if(opcao == 3) {
				Figurinha figurinha = new Figurinha();
				FigurinhaRepetida figurinhaRepetidas = new FigurinhaRepetida();
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
						System.out.println("*****************************************");
					}else {
						figurinha.setNumero(fig);
						Figurinha figEncontrada = contaEncontrada.verificarFigurinhaExiste(fig);
						if(figEncontrada != null) {
							figurinhaRepetidas.setNumero(fig);
							contaEncontrada.colarFigurinhasRepetidas(figurinhaRepetidas);
							System.out.println("\n**********************************");
							System.out.printf("A figurinha numero %s", fig + " foi  adicionada a  lista das  repetidas. \n");
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
					System.out.println("Informe o numero da figurinha: ");	if(opcao == 9) {
						System.out.println("Informe o seu codigo: ");	
						String codTitular = scan.next();
						Album contaEncontrada = conta.encontrar(codTitular);
						if (contaEncontrada != null) {
							File file = new File("repetidas.txt");
							try {
								
								if(!file.exists()) {
									file.createNewFile();
								}
								
								FileWriter fw = new FileWriter(file.getAbsoluteFile());
								BufferedWriter bw = new BufferedWriter(fw);		
								List<FigurinhaRepetida> listFigRep = contaEncontrada.getFigurinhasRepetidas();
								bw.write("=======Lista de Figurinhas Repetidas========");
								bw.newLine();		
								for(FigurinhaRepetida figRep : listFigRep) {
									bw.write("Numero: " + figRep.getNumero());
									bw.newLine();
									bw.write("===========================");
									bw.newLine();
								}
								bw.close();		
							}catch(Exception e) {
									e.fillInStackTrace();
							}
							System.out.println("\n**********************************");
							System.out.println("Abra o arquivo texto criado (repetidas.txt)");
							System.out.println("**********************************\n");
						}else {
							System.out.println("\n**********************************");
							System.out.println("Album não Encontrada");
							System.out.println("\n**********************************\n");
						}
					}
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
				if (contaEncontrada != null) {
					System.out.println("Informe o numero da figurinha: ");	
					String figura = scan.next();
					Figurinha figurinhaVerificada = contaEncontrada.verificarFigurinhaExiste(figura);
					if(figurinhaVerificada != null) {
						System.out.println("\n**********************************");
						System.out.printf("True");
						System.out.println("\n**********************************\n");
					}else {
						System.out.println("\n**********************************");
						System.out.printf("False");
						System.out.println("\n**********************************\n");
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não encontrado");
					System.out.println("\n**********************************\n");
				}
			}
			
			if(opcao == 6) {
				String s = null;
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if(contaEncontrada != null) {
					List<Figurinha> listFig = contaEncontrada.getFigurinhas();
					for(int i = 1; i <= 681; i++) {
						s = Integer.toString(i);
						for(Figurinha a : listFig)
						{
							if(s.equals(a.getNumero())) {
								s = "";
							}
						}
						System.out.println(s);
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não encontrado");
					System.out.println("\n**********************************");
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
			
			if(opcao == 8) {
				String s = null;
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					File file = new File("faltantes.txt");
					try {
						
						if(!file.exists()) {
							file.createNewFile();
						}
						
						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);		
						List<Figurinha> listFig = contaEncontrada.getFigurinhas();
						bw.write("=======Lista de Figurinhas Faltantes========");
						bw.newLine();		
						for(int i = 1; i <= 681; i++) {
							s = Integer.toString(i);
							for(Figurinha a : listFig)
							{
								if(s.equals(a.getNumero())) {
									s = "";
								}
							}
							bw.write("Numero: " + s);
							bw.newLine();
							bw.write("===========================");
							bw.newLine();
						}
						bw.close();					
					}catch(Exception e) {
							e.fillInStackTrace();
					}
					System.out.println("\n**********************************");
					System.out.println("Abra o arquivo texto criado (faltantes.txt)");
					System.out.println("**********************************\n");
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não Encontrada");
					System.out.println("**********************************\n");
				}
			}
			
			if(opcao == 9) {
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					File file = new File("repetidas.txt");
					try {
						
						if(!file.exists()) {
							file.createNewFile();
						}
						
						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);		
						List<FigurinhaRepetida> listFigRep = contaEncontrada.getFigurinhasRepetidas();
						bw.write("=======Lista de Figurinhas Repetidas========");
						bw.newLine();		
						for(FigurinhaRepetida figRep : listFigRep) {
							bw.write("Numero: " + figRep.getNumero());
							bw.newLine();
							bw.write("===========================");
							bw.newLine();
						}
						bw.close();		
					}catch(Exception e) {
							e.fillInStackTrace();
					}
					System.out.println("\n**********************************");
					System.out.println("Abra o arquivo texto criado (repetidas.txt)");
					System.out.println("**********************************\n");
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não Encontrada");
					System.out.println("\n**********************************\n");
				}
			}
			
			if(opcao == 10) {
				File arquivo = new File("eu_tenho.txt");
				 try {
					 if(!arquivo.exists()) {
						 arquivo.createNewFile();
					 }
					  FileReader lerArquivo = new FileReader(arquivo);
					  BufferedReader bf = new BufferedReader(lerArquivo);
					  
					  while(bf.ready()) {
						  String linha = bf.readLine();
						  System.out.println(linha);
					  }  
					  bf.close();
				 }catch(Exception e) {
					 e.fillInStackTrace();
				 }
			}
			
			if(opcao == 11) {
				File arquivo = new File("faltantes.txt");
				 try {
					 if(!arquivo.exists()) {
						 arquivo.createNewFile();
					 }
					  FileReader lerArquivo = new FileReader(arquivo);
					  BufferedReader bf = new BufferedReader(lerArquivo);
					  
					  while(bf.ready()) {
						  String linha = bf.readLine();
						  System.out.println(linha);
					  }  
					  bf.close();
				 }catch(Exception e) {
					 e.fillInStackTrace();
				 }
			}
			
			if(opcao == 12) {
				File arquivo = new File("repetidas.txt");
				try {
					if(!arquivo.exists()) {
						arquivo.createNewFile();
					}
					
					FileReader fr = new FileReader(arquivo);
					BufferedReader bf = new BufferedReader(fr);
					
					while(bf.ready()) {
						String ler = bf.readLine();
						System.out.println(ler);
					}
					bf.close();
				}catch(Exception e) {
					e.fillInStackTrace();
				}
			}
			
			if(opcao == 13) {
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if(contaEncontrada != null) {
					List<FigurinhaRepetida> listFigRep = contaEncontrada.getFigurinhasRepetidas();
					System.out.println("\n**********************************");
					System.out.println("Figurinhas Repetidas");
					System.out.println("**********************************");
					for(FigurinhaRepetida a : listFigRep)
					{
						System.out.println(a.getNumero());
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não encontrado");
					System.out.println("\n**********************************");
				}
			}
			
			if(opcao == 14) {
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					System.out.println("Informe o numero da figurinha: ");	
					String figura = scan.next();
					FigurinhaRepetida figurinhaRepetidaVerificada = contaEncontrada.verificarFigurinhaRepetidaExiste(figura);
					if(figurinhaRepetidaVerificada != null) {
						System.out.println("\n**********************************");
						System.out.printf("True");
						System.out.println("\n**********************************\n");
					}else {
						System.out.println("\n**********************************");
						System.out.printf("False");
						System.out.println("\n**********************************\n");
					}
				}else {
					System.out.println("\n**********************************");
					System.out.println("Album não encontrado");
					System.out.println("\n**********************************\n");
				}
			}
			
			if(opcao == 15) {
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
			
			if(opcao == 16) {
				PacotinhoFigurinha pacotinho = new PacotinhoFigurinha();
				System.out.println("Informe o seu codigo: ");	
				String codTitular = scan.next();
				Album contaEncontrada = conta.encontrar(codTitular);
				if (contaEncontrada != null) {
					System.out.println("Informe o numero da figurinha que voce deseja trocar?");
					String fig = scan.next();
					FigurinhaRepetida fr = contaEncontrada.verificarFigurinhaRepetidaExiste(fig);
					if(fr == null) {
						System.out.println("\n***********************************************");
						System.out.println("Voce não possui a figurinha informada para troca.");
						System.out.println("***********************************************\n");
					}else {
						contaEncontrada.retirarFigurinhaRepetida(fr);
						System.out.println("Informe a numero da figurinha que voce deseja obter?");
						String figObter = scan.next();
						Figurinha figEncontrada = contaEncontrada.encontrarFigurinhas(figObter);
						if(figEncontrada != null) {
							System.out.println("\n**********************************");
							System.out.println("Voce já possui a figurinha no seu album.");
							System.out.println("**********************************\n");
						}else {
							Figurinha figurinha = new Figurinha();
							figurinha.setNumero(figObter);
							contaEncontrada.colarFigurinha(figurinha);
							System.out.println("\n**********************************");
							System.out.println("Troca realizada com sucesso.");
							System.out.println("**********************************\n");
						}
					}
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
