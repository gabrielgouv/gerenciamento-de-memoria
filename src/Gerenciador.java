
public class Gerenciador {

	public static void firstFit(int tamanhoProcesso, Memoria memoria) {

		for (Bloco bloco : memoria.getBlocos()) {
			if ((bloco.getEspacoTotal() >= tamanhoProcesso) && (!bloco.isAlocado())) {
				bloco.setEspacoEmUso(tamanhoProcesso);
				bloco.setAlocado(true);
				memoria.setUltimoBlocoModificado(bloco);				
				break;
			}
		}
	}

	public static void nextFit(int tamanhoProcesso, Memoria memoria) {
		
		for (Bloco bloco : memoria.getBlocos()) {
			if (bloco == memoria.getUltimoBlocoModificado()) {
				for (int i = bloco.getId() - 1; i < memoria.getBlocos().size(); i++) {
					
					Bloco b = memoria.getBlocos().get(i);
					
					if ((b.getEspacoTotal() >= tamanhoProcesso) && (!memoria.getBlocos().get(i).isAlocado())) {
						b.setEspacoEmUso(tamanhoProcesso);
						b.setAlocado(true);
						memoria.setUltimoBlocoModificado(memoria.getBlocos().get(i));						
						return;
					}
				}
			}
			
		}
		
		memoria.setUltimoBlocoModificado(memoria.getBlocos().get(0));
		nextFit(tamanhoProcesso, memoria);

	}
	
	public static void bestFit(int tamanhoProcesso, Memoria memoria) {

		int sobra = Integer.MAX_VALUE;
		Bloco melhorBloco = null;
		
		for (Bloco bloco : memoria.getBlocos()) {		
			if ((bloco.getEspacoTotal() >= tamanhoProcesso) && (!bloco.isAlocado())) {
				int livre = bloco.getEspacoTotal() - tamanhoProcesso;
				if (livre < sobra) {
					sobra = livre;
					melhorBloco = bloco;
				}
			}	
		}
		
		for (Bloco bloco : memoria.getBlocos()) {				
			if (bloco == melhorBloco) {
				bloco = melhorBloco;
				bloco.setEspacoEmUso(tamanhoProcesso);
				bloco.setAlocado(true);
				memoria.setUltimoBlocoModificado(bloco);
				break;
			}		
		}
		
	}
	
	public static void worstFit(int tamanhoProcesso, Memoria memoria) {

		Bloco piorBloco = new Bloco(0, false);
		
		for (Bloco bloco : memoria.getBlocos()) {
			if ((bloco.getEspacoTotal() >= tamanhoProcesso) && (!bloco.isAlocado())) {
				if (bloco.getEspacoTotal() > piorBloco.getEspacoTotal()) {
					piorBloco = bloco;
				}
			}	
		}
		
		for (Bloco bloco : memoria.getBlocos()) {
			if (bloco == piorBloco) {
				bloco = piorBloco;
				bloco.setEspacoEmUso(tamanhoProcesso);
				bloco.setAlocado(true);
				memoria.setUltimoBlocoModificado(bloco);
				break;
			}		
		}
		
	}
	
}
