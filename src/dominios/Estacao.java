package dominios;

import java.util.List;

import lab01.Carta;
import lab01.Jogador;
import lab01.Tabuleiro;

public class Estacao extends Propriedade{
	private int tarifa;

	public Estacao(int id, String descricao, String nome, Jogador dono, int preco, int aluguel, int tarifa) {
		super(id, descricao, nome, dono, preco, aluguel);
		this.tarifa = tarifa;
	}
	
	// Getters e Setters

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}
	
	// Métodos definidos para subclasse ServicoPublico
	@Override
	public int calcularAluguel() { // Multiplica o aluguel base pelo numero total de estacoes que o jogador possui
		int numEstacoes = 0;
		List<Carta> cartas =  dono.getCartas();
		for (Carta carta : cartas) { // Conto o numero de cartas do tipo Estacao o jogador possui
			if (carta instanceof Estacao) {
				numEstacoes++;
			}
		}	
		int aluguel = super.calcularAluguel() * numEstacoes; 
		System.out.println("O jogador possui: " +  numEstacoes + " estacoes.");
		System.out.println("Aluguel de " + this.getNome() + ": " + aluguel);
		return aluguel;
	}
	
}
