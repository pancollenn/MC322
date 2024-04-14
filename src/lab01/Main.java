package lab01;

import java.util.ArrayList;
import java.util.Scanner;
import dominios.Propriedade;
import dominios.Estacao;
import dominios.ServicoPublico;
import dominios.Terreno;

public class Main {

	public static void main(String[] args) {
		// Declaro o tabuleiro
		Tabuleiro tabuleiro = new Tabuleiro(); 
		
		// Declaro as cartas sorte
		CartaSorte c1 = new CartaSorte(0, "Volte ao ponto de partida", 0, 0, 1000.00f , "Sem ação específica", 0, "Sem restrições");
		
		// Declaro as peças
		Peca p1 = new Peca("Vermelho", 0);
		
		// Declaro as estações
		Estacao e1 = new Estacao(0, "Estação férrea", "Victor", 500, 50);
		tabuleiro.addPropriedade(e1.getId());
		
		// Declaro os terrenos
		Terreno t1 = new Terreno(10, "Curitiba", "Victor", 100, 10, 0, 50, 100, false);
		tabuleiro.addPropriedade(t1.getId());
		
		// Declaro os serviços públicos
		ServicoPublico sp1 = new ServicoPublico(20, "Encanação", "Victor", 100, 10);
		tabuleiro.addPropriedade(sp1.getId());
		
		// Crio uma lista para os jogadores
		ArrayList<Jogador> jogadores = new ArrayList<>();
		
		// Declaro o jogador 1 para testar as funções
		Jogador j1 = new Jogador("Victor", "039.104.640-33", "victor@gmail.com", "foto");
		jogadores.add(j1);
		tabuleiro.addJogador(j1.getId());
	
		// Recebo as entradas dos jogadores
		Scanner entrada = new Scanner(System.in);
		while (true) {
			System.out.println("Registre o jogador");
			System.out.println("Nome: ");
			String comando = entrada.next();
			if (comando.equals("break")) {
                System.out.println("Jogadores registrados.");
                break; // Sai do loop se o comando for "break"
            }
			String nome = comando;
			System.out.println("CPF: ");
			String cpf = entrada.next();
			// Verifico o cpf
			if (!Funcoes.validarCPF(cpf)) {
				System.out.println("CPF inválido, dê as entradas novamente");
				continue; // Reinicia loop se o comando for inválido
			}
			System.out.println("Email: ");
			String email = entrada.next();
			// Verifico o email
			if (!Funcoes.validarEmail(email)) {
				System.out.println("Email inválido, dê as entradas novamente");
				continue; // Reinicia loop se o comando for inválido
			}
			System.out.println("Foto: ");
			String foto = entrada.next();
			Jogador j = new Jogador(nome, cpf, email, foto);
			// Verifico a entrada do 
			jogadores.add(j);
		}
		entrada.close();
		
		
		// Verifico as entradas dos jogadores
		for (int i = 0; i < jogadores.size(); i++) {
			System.out.println(jogadores.get(i));
		}
		
		// Imprimo os dados de cada classe
		System.out.println(c1);
		System.out.println(p1);
		System.out.println(e1);
		System.out.println(t1);
		System.out.println(sp1);
		tabuleiro.imprimirTabuleiro();		
		
		// Testo calcularAluguel()
		e1.calcularAluguel();
		t1.calcularAluguel();
		sp1.calcularAluguel(5); // Caso tenha lançado 5 nos dados
		
		// Testo comprarCasa() e comprarHotel()
		t1.comprarCasa(j1);
		t1.comprarCasa(j1);
		t1.comprarCasa(j1);
		t1.comprarCasa(j1);
		t1.comprarHotel(j1);
		
		// Confiro se os atributos de t1 foram atualizados
		System.out.println(t1);
	}

}
