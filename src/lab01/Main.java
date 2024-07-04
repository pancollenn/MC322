package lab01;

import java.util.Random;
import java.util.Scanner;
import dominios.Propriedade;
import dominios.SaldoInsuficienteException;
import dominios.Estacao;
import dominios.ServicoPublico;
import dominios.Terreno;

public class Main {

	public static void main(String[] args) throws SaldoInsuficienteException {
		// Declaro o tabuleiro
		Tabuleiro tabuleiro = new Tabuleiro(); 
		
		// Registro os jogadores
		Scanner entrada = new Scanner(System.in);
		System.out.println("Numero de jogadores: ");
		String numJogadoresStr = entrada.nextLine();
		int numJogadores = Integer.parseInt(numJogadoresStr);
		int k = 0;
		while (k < numJogadores) {
			System.out.println("Registre o jogador: ");
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
			k++;
		}
		
		// Imprimo os dados dos jogadores para checar se está tudo correto
		for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
			System.out.println(tabuleiro.getJogadores().get(i));
		}
		
		boolean jogoRolando = true;
		
		while (jogoRolando) { // Enquanto nenhum jogador tiver falido, o jogo continua
			for (int id = 0; id < numJogadores; id++) {
				System.out.println();
				System.out.println("Vez do jogador de id: " + id);
				
				Jogador jogador = tabuleiro.getJogadores().get(id); // Jogador que esta na vez
				
				// Rolam os dados
				
				Random random = new Random();
				int dado1 = random.nextInt(6) + 1; // Gera um numero aleatorio de 1 a 6
				int dado2 = random.nextInt(6) + 1;
				int totalDados = dado1 + dado2;

				
				System.out.println("Dados: " + dado1 + " + " + dado2 + " = " + totalDados);
				String movePeca = String.format("%s move peca %s %d casas.", jogador.getNome(), jogador.getPeca().getCor(), totalDados);
				tabuleiro.executarAcao(movePeca); // Salva a acao
				
				jogador.getPeca().moverJogador(totalDados, tabuleiro); // Move a peca de acordo com o numero tirado
				
				if (jogador.getPeca().getCasaAtual(tabuleiro) == null) { // Se parar em Carta Sorte, deve comprar uma carta sorte
					
					int indiceCartaSorte = random.nextInt(tabuleiro.getCartasSorte().size()); // Sorteia uma carta sorte para o jogador
				    CartaSorte cs = tabuleiro.getCartasSorte().get(indiceCartaSorte);
	    			System.out.println("Carta tipo: " + cs.tipo + ", " + cs.descricao);
	    			String compraCartaSorte = String.format("%s compra carta tipo %s: %s", jogador.getNome(), cs.tipo, cs.descricao);
					tabuleiro.executarAcao(compraCartaSorte); // Salva a acao
    				if (cs.tipo == TipoCarta.SORTE) {
    					int dinheiro = (int) (jogador.getDinheiro() + cs.getValor()); // Adiciona o valor ao saldo
    					jogador.setDinheiro(dinheiro);
    				}
    				else if (cs.tipo == TipoCarta.REVES) {
    					int dinheiro = (int) (jogador.getDinheiro() - cs.getValor()); // Retira o valor do saldo
    					jogador.setDinheiro(dinheiro);
    				}
    				if (cs.getMovimento() != -1) {
    					int novaCasa = cs.getMovimento();
    					jogador.getPeca().setPosicao(novaCasa); // Move a peca ate a casa indicada
    				}	    			
	        	}
				else if (jogador.getPeca().getCasaAtual(tabuleiro).getDono() != null && jogador.getPeca().getCasaAtual(tabuleiro).getDono() != jogador) { // Se cair em uma propriedade com outro dono deve pagar aluguel
					System.out.println("Pague aluguel!");
					Carta casaAtual = jogador.getPeca().getCasaAtual(tabuleiro);
					if(!Aluguel.pagarAluguel(jogador, casaAtual, tabuleiro, totalDados)) { // O jogador paga o aluguel, se acabar o dinheiro acaba o jogo
						jogoRolando = false;
						String perdeu = String.format("%s faliu. Fim de jogo.", jogador.getNome());
						tabuleiro.executarAcao(perdeu); // Salva a acao
						break;
					}
				}
	        	else {
	        		tabuleiro.menuAcoes(entrada, jogador); // Menu de acoes para o jogador escolher o que fazer 
				}
			}
		}
		entrada.close();
	}

}
