package lab01;

public class Main {

	public static void main(String[] args) {
		// Declaro as cartas sorte
		CartaSorte c1 = new CartaSorte(0, "Volte ao ponto de partida", 0, 0, 1000.00f , "Sem ação específica", 0, "Sem restrições");
		
		// Declaro as peças
		Peca p1 = new Peca("Vermelho", 0);
		
		// Declaro o jogador
		Jogador j1 = new Jogador("Victor", "039.104.640-33", "victor@gmail.com", "foto");
		
		// Verifico a validade do CPF
		if (!j1.validarCPF(j1.getCpf())) {
			System.out.println("CPF inválido");
		}
		// Verifico a validade do email
		if (!j1.validarEmail(j1.getEmail())) {
			System.out.println("Email inválido");
		}
		// Imprimo os dados de cada classe
		System.out.println(j1);
		System.out.println(c1);
		System.out.println(p1);
	}

}
