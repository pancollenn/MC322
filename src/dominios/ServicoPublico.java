package dominios;

import lab01.Jogador;

public class ServicoPublico extends Propriedade {

	public ServicoPublico(int id, String descricao, String nome, Jogador dono, int preco, int aluguel) {
		super(id, descricao, nome, dono, preco, aluguel);
	}
	
	// Métodos definidos para subclasse ServicoPublico
	
	public int calcularAluguel(int dados) {
		int aluguel = this.aluguel * dados;
		System.out.println("Aluguel de " + this.getNome() + ": " + aluguel);
		return aluguel;
	}
}
