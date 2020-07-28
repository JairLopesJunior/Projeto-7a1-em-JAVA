import java.util.ArrayList;
import java.util.List;

public class Conta {

	private List<Album> albuns = new ArrayList<Album>();
	
	private Album album;
	
	public Album encontrar(String cpfTitular) {
		for (Album alb : albuns) {
			String cpfCorrente = alb.getCodigo();
			if (cpfCorrente.equals(cpfTitular))
				return alb;
		}
		return null;
	}
	
	public void salvar(Album album){
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
