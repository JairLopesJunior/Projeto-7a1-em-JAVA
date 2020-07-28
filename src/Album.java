import java.util.ArrayList;
import java.util.List;

public class Album {
	
	private String codigo;
	
	private List<Figurinha> figurinhas = new ArrayList<Figurinha>(681);

	public Figurinha figursinhas() {
		for(Figurinha f : figurinhas){
			return f;
		}
		return null;
	}
	
	public List<Figurinha> getAlbum() {
		return figurinhas;
	}
	
	public void colarFigurinha(Figurinha fig) {
		figurinhas.add(fig);
	}
	
	public void verificarExistencia(String figurinha) {
		for(Figurinha f : figurinhas) {
			String fig = f.getFigurinha();
			if(figurinha.equals(fig)) {
				System.out.println("OK");
			}
		}
	}
	
	public Figurinha encontrarFigurinhas(String figurinha) {
		for(Figurinha f : figurinhas){
			String fig = f.getFigurinha();
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

}
