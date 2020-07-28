import java.util.ArrayList;
import java.util.List;

public class Album {
	
	private List<Figurinha> figurinhas = new ArrayList<Figurinha>(681);
	
	private String codigo;
	private Figurinha Figurinha;
	
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

	public Figurinha getFigurinha() {
		return Figurinha;
	}

	public void setFigurinha(Figurinha figurinha) {
		Figurinha = figurinha;
	}

}
