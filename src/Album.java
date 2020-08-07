import java.util.ArrayList;
import java.util.List;

public class Album {
	
	private List<Figurinha> figurinhas = new ArrayList<Figurinha>(681);
	private List<FigurinhaRepetida> figurinhasRepetidas = new ArrayList<FigurinhaRepetida>();
	Conta conta =  new Conta();
	private String codigo;
	private Figurinha Figurinhas;

	public List<FigurinhaRepetida> getFigurinhasRepetidas() {
		return figurinhasRepetidas;
	}
	
	public void colarFigurinhasRepetidas(FigurinhaRepetida figurinhaRepetida) {
		figurinhasRepetidas.add(figurinhaRepetida);
	}

	public List<Figurinha> getAlbum() {
		return figurinhas;
	}
	
	public void colarFigurinha(Figurinha figurinha) {
		figurinhas.add(figurinha);
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
	
	public FigurinhaRepetida verificarFigurinhaRepetidaExiste(String num) {
		for(FigurinhaRepetida f : figurinhasRepetidas) {
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
