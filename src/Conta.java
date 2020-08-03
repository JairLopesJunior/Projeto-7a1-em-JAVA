import java.util.ArrayList;
import java.util.List;

public class Conta {

	private List<Album> albuns = new ArrayList<Album>();
	
	private Album album;
	
	public Album encontrar(String codTitular) {
		for (Album alb : albuns) {
			if (alb.getCodigo().equals(codTitular)) {
				return alb;
			}
		}
		return null;
	}
	
	public Album verificarExistenciaAlbum(String album){
		for(Album alb : albuns) {
			String cod = alb.getCodigo();
			if(cod.equals(album)) {
				return alb;
			}
		}
		return null;
	}
	
	public void salvar(Album album) {
		albuns.add(album);
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
}
