package dominios;

public class Propriedade {
	// Troquei para protected para subclasses poderem acessar
	protected int id;
	protected String nome;
	protected String proprietario;
	protected int preco;
	protected int aluguel;
	
	// Construtor
	public Propriedade(int id, String nome, String proprietario, int preco, int aluguel) {
		this.id = id;
		this.nome = nome;
		this.proprietario = proprietario;
		this.preco = preco;
		this.aluguel = aluguel;
	}
	
	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public int getAluguel() {
		return aluguel;
	}

	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}
	@Override
	public String toString() {
		return "Propriedade { ID: " + id + ", Nome: " + nome + ", Proprietário: " + proprietario + ", Preço: " + preco + ", Aluguel: " + aluguel + "}";
	}
	
	// Métodos das propriedades
	
	// Retorna o aluguel
	public int calcularAluguel() { // Calcular se há monopólio ou construções
		System.out.println("Aluguel de " + this.getNome() + ": " + this.aluguel);
		return this.aluguel;
	}
}
