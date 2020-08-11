import java.util.Random;

public class PacotinhoFigurinha {

	public void comprarPacotinhoFigurinha(Album albumEncontrado) {
		Random gerador = new Random();
		System.out.print("****************************************************");
		for(int i = 1; i <= 5; i++) {
			Figurinha f = new Figurinha();
			FigurinhaRepetida fr = new FigurinhaRepetida();
			int a = gerador.nextInt(681);
			String numero = Integer.toString(a);
			Figurinha figurinhaEncontrada = albumEncontrado.verificarFigurinhaExiste(numero);
			if(figurinhaEncontrada == null) {
				f.setNumero(numero);
				albumEncontrado.colarFigurinha(f);
				System.out.println();
				System.out.printf("A figurinha numero %s foi adicionada ao album ", numero);
				System.out.println();
			}else {
				fr.setNumero(numero);
				albumEncontrado.colarFigurinhasRepetidas(fr);
				System.out.println();
				System.out.printf("A figurinha numero %s foi adicionada a lista de repetidas ", numero);
				System.out.println();
			}
			System.out.print("****************************************************");
		}
	}
}
