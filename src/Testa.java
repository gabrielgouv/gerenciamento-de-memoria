import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Testa {

	private static Memoria memoria;
	private static Scanner s;

	public static void main(String[] args) {

		s = new Scanner(System.in);
		memoria = new Memoria();

		memoria.addBloco(new Bloco(500));
		memoria.addBloco(new Bloco(450));
		memoria.addBloco(new Bloco(400));
		memoria.addBloco(new Bloco(390));
		memoria.addBloco(new Bloco(100));
		memoria.addBloco(new Bloco(350));
		memoria.addBloco(new Bloco(410));
		memoria.addBloco(new Bloco(100));
		memoria.addBloco(new Bloco(50));
		memoria.addBloco(new Bloco(25));

		int opcao = 0;

		do {

			mostraMemoria();

			System.out.println("Escolha o algoritmo de gerenciamento de espaco:"
					+ "\n1 - First Fit (primeiro encaixe)"
					+ "\n2 - Next Fit (próximo encaixe)"
					+ "\n3 - Best Fit (melhor encaixe)"
					+ "\n4 - Worst Fit (pior encaixe)"
					+ "\n0 - Sair");

			opcao = s.nextInt();

			verificaOpcao(opcao);

		} while (opcao != 0);

	}

	private static void verificaOpcao(int opcao) {
		int tamanho = 0;
		switch (opcao) {
		case 1:
			System.out.println("[FIRST FIT] Insira o tamanho do processo:");
			tamanho = s.nextInt();
			Gerenciador.firstFit(tamanho, memoria);
			break;
		case 2:
			System.out.println("[NEXT FIT] Insira o tamanho do processo:");
			tamanho = s.nextInt();
			Gerenciador.nextFit(tamanho, memoria);
			break;
		case 3:
			System.out.println("[BEST FIT] Insira o tamanho do processo:");
			tamanho = s.nextInt();
			Gerenciador.bestFit(tamanho, memoria);
			break;
		case 4:
			System.out.println("[WORST FIT] Insira o tamanho do processo:");
			tamanho = s.nextInt();
			Gerenciador.worstFit(tamanho, memoria);
			break;
		case 0:
			System.exit(0);
		default:
			System.out.println("Escolha invalida!");
		}
	}

	private static void mostraMemoria() {
		List<Bloco> blocos = memoria.getBlocos();
		DecimalFormat df = new DecimalFormat("#00");

		String saida = "";

		for (int i = 0; i < blocos.size(); i++) {

			saida += "[Bloco " + df.format(i + 1) + "]:    " + blocos.get(i).getEspacoEmUso() + "K   de   "
					+ blocos.get(i).getEspacoTotal() + "K   " + (blocos.get(i).isAlocado() ? "(Alocado)" : "")
					+ (blocos.get(i) == memoria.getUltimoBlocoModificado() ? " <---" : "") + "\n";
		}

		System.out.println(saida);

	}

}
