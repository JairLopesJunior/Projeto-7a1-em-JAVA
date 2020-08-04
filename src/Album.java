import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Album {
	
	private List<Figurinha> figurinhas = new ArrayList<Figurinha>(681);
	Conta conta =  new Conta();
	
	private String codigo;
	private Figurinha Figurinhas;
	Scanner scan = new Scanner(System.in);
	
	public List<Figurinha> getAlbum() {
		return figurinhas;
	}
	
	public void colarFigurinha(Figurinha figurinha) {
		figurinhas.add(figurinha);
	}
	
	public void verificarFigurinhasFaltantes(Album contaEncontrada){
		String s = null;
		int i;
		if (contaEncontrada != null) {
		List<Figurinha> listFig = contaEncontrada.getFigurinhas();
		System.out.println("\n**********************************");
		System.out.println("Figurinhas que faltam");
		System.out.println("**********************************");
		for(i = 1; i <= 681; i++) {
			for(Figurinha a : listFig) {
				s = Integer.toString(i);
			if(s.equals(a.getNumero())) {
				s = "";
			}else {
				System.out.println("Numero: " + (i));
			}
			}
		}
		}else {
			System.out.println("\n**********************************");
			System.out.println("Album não Encontrada");
			System.out.println("**********************************");
		}
	}
	
	public Figurinha verificarFigurinhaExiste(String num) {
		for(Figurinha f : figurinhas) {
			String numero = f.getNumero();
			if(numero.equals(num)) {
				return f;
			}
		}
		return null;
	}
	
	public boolean validarNumero(String numero) {
		int num = Integer.parseInt(numero);
		if(num <= 0 || num > 681) {
			return true;
		}
		return false;
	}
	
	public Figurinha encontrarFigurinhas(String figurinha) {
		for(Figurinha f : figurinhas){
			String fig = f.getNumero();
			if(figurinha.equals(fig)) {
				return f;
			}
		}
		return null;
	}

	public List<Figurinha> getFigurinhas() {
		return figurinhas;
	}

	public void setFigurinhas(List<Figurinha> figurinhas) {
		this.figurinhas = figurinhas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setFigurinhas(Figurinha figurinhas) {
		Figurinhas = figurinhas;
	}

	
}
