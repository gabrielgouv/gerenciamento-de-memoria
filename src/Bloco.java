
public class Bloco {

	private int id;
	private int espacoTotal;
	private int espacoEmUso;
	private boolean alocado;
	
	public Bloco(int espacoTotal) {
		this.espacoTotal = espacoTotal;
		this.alocado = false;
	}
	
	public Bloco(int espacoTotal, boolean alocado) {
		this.espacoTotal = espacoTotal;
		this.alocado = alocado;
	}
	
	public void setEspacoEmUso(int espacoEmUso) {
		this.espacoEmUso = espacoEmUso;
	}
	
	public int getEspacoEmUso() {
		return espacoEmUso;
	}
	
	public void setAlocado(boolean alocado) {
		this.alocado = alocado;
	}
	
	public boolean isAlocado() {
		return alocado;
	}
	
	public int getEspacoTotal() {
		return espacoTotal;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
}
