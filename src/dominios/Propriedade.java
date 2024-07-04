package dominios;

import lab01.Carta;
import lab01.Jogador;

public abstract class Propriedade extends Carta{
	// Troquei para protected para subclasses poderem acessar
	protected String nome;
	protected int preco;
	protected int aluguel;
	
	// Construtor
	public Propriedade(int id, String descricao, String nome, Jogador dono, int preco, int aluguel) {
		super(id, descricao);
		this.nome = nome;
		this.preco = preco;
		this.aluguel = aluguel;
	}
	
	// Getters e Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		String nomeDono;
		if (dono == null) {
			nomeDono = "Sem dono";
		}
		else {
			nomeDono = dono.getNome();
		}
		return "Propriedade { ID: " + id + ", Nome: " + nome + ", Proprietário: " 
				+ nomeDono + ", Preço: " + preco + ", Aluguel: " + aluguel + "}";
	}
	
	// Métodos das propriedades
	
	// Retorna o aluguel
	public int calcularAluguel() { 
		return this.aluguel;
	}
}
