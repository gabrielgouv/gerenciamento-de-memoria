import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private int idGerado;
	private List<Bloco> blocos;
	private Bloco ultimoBlocoModificado;
	
	public Memoria() {
		blocos = new ArrayList<>();		
	}
	
	public void addBloco(Bloco bloco) {
		bloco.setId(geraId());
		blocos.add(bloco);
		ultimoBlocoModificado = null;
	}
	
	public List<Bloco> getBlocos() {
		return blocos;	
	}
	
	public void atualizarBloco(Bloco blocoNovo) {
		for (Bloco bloco : blocos) {
			if (bloco.getId() == blocoNovo.getId()) {
				bloco = blocoNovo;
				ultimoBlocoModificado = bloco;
			}
		}
	}
	
	public Bloco getUltimoBlocoModificado() {
		return ultimoBlocoModificado;
	}
	
	public void setUltimoBlocoModificado(Bloco ultimoBlocoModificado) {
		
		this.ultimoBlocoModificado = ultimoBlocoModificado;
		
	}
	
	private int geraId() {
		idGerado++;
		return idGerado;	
	}
	
}
