package dominios;

import lab01.Jogador;

public class ServicoPublico extends Propriedade {
	private int multiplicador;

	public ServicoPublico(int id, String descricao, String nome, Jogador dono, int preco, int aluguel, int multiplicador) {
		super(id, descricao, nome, dono, preco, aluguel);
		this.multiplicador = multiplicador; // número do dado
	}
	
	// Getters e Setters

	public int getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}
	
	// Métodos definidos para subclasse ServicoPublico

	public int calcularAluguel(int dados) { // Multiplica o aluguel base pelo numero tirado nos dados
		int aluguel = super.calcularAluguel() * dados;
		System.out.println("Aluguel de " + this.getNome() + ": " + aluguel);
		return aluguel;
	}
}
