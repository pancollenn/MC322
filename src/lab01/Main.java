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
		
		// Declaro as peças
		Peca p1 = new Peca("Vermelho", 0);
		
		// Declaro o jogador 1 para testar as funções
		Jogador j1 = new Jogador("Victor", "039.104.640-33", "victor@gmail.com", "foto", p1);
		tabuleiro.addJogador(j1);
		
		// Declaro as cartas sorte
		CartaSorte c1 = new CartaSorte(0, "Volte ao ponto de partida", null, 0, 0, 1000.00f , "Sem ação específica", 0, "Sem restrições");
		
		// Declaro as estações
		Estacao e1 = new Estacao(0, "Sem descrição.", "Estação férrea", null, 500, 50);
		tabuleiro.addPropriedade(e1);
		
		// Declaro os terrenos
		Terreno t1 = new Terreno(10, "Sem descrição.", "Curitiba", null, 100, 10, 0, 50, 100, false);
		tabuleiro.addPropriedade(t1);
		
		// Declaro os serviços públicos
		ServicoPublico sp1 = new ServicoPublico(20, "Sem descrição.", "Encanação", null, 100, 10);
		tabuleiro.addPropriedade(sp1);
	
		// Registro os jogadores
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
			if (!Validacoes.validarCPF(cpf)) { // Verifico o cpf
				System.out.println("CPF inválido, dê as entradas novamente");
				continue; // Reinicia loop se o comando for inválido
			}
			System.out.println("Email: ");
			String email = entrada.next();
			if (!Validacoes.validarEmail(email)) { // Verifico o email
				System.out.println("Email inválido, dê as entradas novamente");
				continue; // Reinicia loop se o comando for inválido
			}
			System.out.println("Foto: ");
			String foto = entrada.next(); // Registro a foto
			
			System.out.println("Peça: ");
			String cor = entrada.next();
			Peca peca = new Peca(cor, 0); // Registro a peça 
			
			Jogador j = new Jogador(nome, cpf, email, foto, peca); 
			tabuleiro.addJogador(j); // Adiciono o jogador ao tabuleiro
		}
		
		// Imprimo os dados dos jogadores para checar se está tudo correto
		for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
			System.out.println(tabuleiro.getJogadores().get(i));
		}
		
		// Imprimo os dados de cada classe para checar se está correto
		System.out.println(c1);
		System.out.println(e1);
		System.out.println(t1);
		System.out.println(sp1);	
		
		// Testo calcularAluguel()
		e1.calcularAluguel();
		t1.calcularAluguel();
		sp1.calcularAluguel(5); // Caso tenha lançado 5 nos dados
		
		// Testo comprarPropriedade(), comprarCasa() e comprarHotel()
		j1.comprarPropriedade(t1);
		t1.comprarCasa(j1);
		t1.comprarCasa(j1);
		t1.comprarCasa(j1);
		t1.comprarCasa(j1);
		t1.comprarHotel(j1);
		
		// Confiro se os atributos de t1 foram atualizados
		System.out.println(t1);
		
		// Listo as opções de ação
		//menuAcoes(tabuleiro);
		tabuleiro.menuAcoes(entrada);
		
		entrada.close();
	}

}
