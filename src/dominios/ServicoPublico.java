package dominios;

public class ServicoPublico extends Propriedade {

	public ServicoPublico(int id, String nome, String proprietario, int preco, int aluguel) {
		super(id, nome, proprietario, preco, aluguel);
	}
	
	// Métodos definidos para subclasse ServicoPublico
	
	public int calcularAluguel(int dados) {
		int aluguel = this.aluguel * dados;
		System.out.println("Aluguel de " + this.getNome() + ": " + aluguel);
		return aluguel;
	}
}
