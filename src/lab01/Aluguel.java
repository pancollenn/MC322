package lab01;

import dominios.Estacao;
import dominios.Propriedade;
import dominios.SaldoInsuficienteException;
import dominios.ServicoPublico;
import dominios.Terreno;

public class Aluguel {
	
	public static boolean pagarAluguel (Jogador jogador, Carta casaAtual, Tabuleiro tabuleiro, int dados) throws SaldoInsuficienteException {
		if (casaAtual instanceof Propriedade) {
			
			Propriedade propriedade = (Propriedade) jogador.getPeca().getCasaAtual(tabuleiro);
			
			try {
				if (propriedade instanceof Terreno) { // Se a casa for da classe Terreno 
					Terreno terreno = (Terreno) propriedade;
					int aluguel = terreno.calcularAluguel();
					int dinheiroHospede = jogador.getDinheiro() - aluguel; // Desconta o valor do aluguel do saldo do jogador
					int dinheiroDono = casaAtual.getDono().getDinheiro() + aluguel; // Passa o valor para o dono
					
					if (dinheiroHospede >= 0) {
						jogador.setDinheiro(dinheiroHospede);
						casaAtual.getDono().setDinheiro(dinheiroDono);
						System.out.println("Saldo disponivel: " + dinheiroHospede);
						String pagaAluguel = String.format("%s paga aluguel de %d para %s", jogador.getNome(), aluguel, terreno.getDono().getNome());
						tabuleiro.executarAcao(pagaAluguel); // Salva a acao
						return true;
					}
					else {
						// Se o jogador nao tiver dinheiro suficiente lanca uma excessao
	                    throw new SaldoInsuficienteException("Saldo insuficiente para pagar o aluguel, voce perdeu o jogo!");
					}
				}
				else if (propriedade instanceof Estacao) { // Se a casa for da classe Estacao
					Estacao estacao = (Estacao) propriedade;
					int aluguel = estacao.calcularAluguel();
					int dinheiroHospede = jogador.getDinheiro() - aluguel; // Desconta o valor do aluguel do saldo do jogador
					int dinheiroDono = casaAtual.getDono().getDinheiro() + aluguel; // Passa o valor para o dono
					
					if (dinheiroHospede >= 0) {
						jogador.setDinheiro(dinheiroHospede);
						casaAtual.getDono().setDinheiro(dinheiroDono);
						System.out.println("Saldo disponivel: " + dinheiroHospede);
						String pagaAluguel = String.format("%s paga aluguel de %d para %s", jogador.getNome(), aluguel, estacao.getDono().getNome());
						tabuleiro.executarAcao(pagaAluguel); // Salva a acao
						return true;
					}
					else {
						// Se o jogador nao tiver dinheiro suficiente lanca uma excessao
	                    throw new SaldoInsuficienteException("Saldo insuficiente para pagar o aluguel, voce perdeu o jogo!");
					}
				}
				else if (propriedade instanceof ServicoPublico) { // Se a casa for da classe ServicoPublico
					ServicoPublico servicoPublico = (ServicoPublico) propriedade;
					int aluguel = servicoPublico.calcularAluguel(dados);
					int dinheiroHospede = jogador.getDinheiro() - aluguel; // Desconta o valor do aluguel do saldo do jogador
					int dinheiroDono = casaAtual.getDono().getDinheiro() + aluguel; // Passa o valor para o dono
					
					if (dinheiroHospede >= 0) {
						jogador.setDinheiro(dinheiroHospede);
						casaAtual.getDono().setDinheiro(dinheiroDono);
						System.out.println("Saldo disponivel: " + dinheiroHospede);
						String pagaAluguel = String.format("%s paga aluguel de %d para %s", jogador.getNome(), aluguel, servicoPublico.getDono().getNome());
						tabuleiro.executarAcao(pagaAluguel); // Salva a acao
						return true;
					}
					else {
						// Se o jogador nao tiver dinheiro suficiente lanca uma excessao
	                    throw new SaldoInsuficienteException("Saldo insuficiente para pagar o aluguel, " + jogador.getNome() + " perdeu o jogo!");
					}
				}
			}
			catch (SaldoInsuficienteException e) {
				System.out.println(e.getMessage());
				return false; // Encerra o jogo
			}
		}
		return false;
	}
}