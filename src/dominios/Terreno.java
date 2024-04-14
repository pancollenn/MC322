package dominios;

import lab01.Jogador;

public class Terreno extends Propriedade {
	private int numeroCasas;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel;
	
	public Terreno(int id, String nome, String proprietario, int preco, int aluguel, int numeroCasas, int valorCasa, int valorHotel, boolean hotel) {
		super(id, nome, proprietario, preco, aluguel); // Atributos da superclasse
		this.numeroCasas = numeroCasas;
		this.valorCasa = valorCasa;
		this.valorHotel = valorHotel;
		this.hotel = hotel;
	}
	
	// Getters e Setters da subclasse
	public int getNumeroCasas() {
		return numeroCasas;
	}

	public void setNumeroCasas(int numeroCasas) {
		this.numeroCasas = numeroCasas;
	}

	public int getValorCasa() {
		return valorCasa;
	}

	public void setValorCasa(int valorCasa) {
		this.valorCasa = valorCasa;
	}

	public int getValorHotel() {
		return valorHotel;
	}

	public void setValorHotel(int valorHotel) {
		this.valorHotel = valorHotel;
	}

	public boolean getHotel() {
		return hotel;
	}

	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
	    return "Propriedade { ID: " + id + ", Nome: " + nome + ", Proprietário: " + proprietario + ", Preço: " + preco + ", Aluguel: " + aluguel + ", Número de Casas: " + numeroCasas + ", Valor Casa: " + valorCasa + ", Valor Hotel: " + valorHotel + ", Possui Hotel: " + hotel + "}";
	}

	// Métodos definidos para terreno
	
	public boolean comprarCasa(Jogador j) {
		// Verificar se o jogador possui a propriedade, se possui dinheiro suficiente e se tem menos de 4 casas
		if (proprietario.equals(j.getNome()) && j.getDinheiro() >= valorCasa && numeroCasas < 4) {
			int dinheiro = j.getDinheiro() - valorCasa; // Subtrai o preço da casa do saldo do jogador
			j.setDinheiro(dinheiro);
			System.out.println("Jogador " + j.getNome() + " saldo: " + j.getDinheiro());
			numeroCasas++; // Aumenta uma casa no terreno
			System.out.println("Casa comprada em " + this.nome + " com sucesso!");
			return true;
		}
		System.out.println("Não foi possível realizar a compra da casa.");
		return false;
	}
	
	public boolean comprarHotel(Jogador j) {
		// Verificar se o jogador possui a propriedade, se possui dinheiro suficiente, se já tem 4 casas e se ainda não tem hotel
		if (proprietario.equals(j.getNome()) && j.getDinheiro() >= valorHotel && numeroCasas == 4 && !hotel) {
			int dinheiro = j.getDinheiro() - valorHotel; // Subtrai o preço do hotel do saldo do jogador
			j.setDinheiro(dinheiro);
			System.out.println("Jogador " + j.getNome() + " saldo: " + j.getDinheiro());
			hotel = true; // O terreno passa a ter um hotel
			System.out.println("Hotel comprado em " + this.nome + " com sucesso!");
			return true;
		}
		System.out.println("Não foi possível realizar a compra do hotel.");
		return false;
	}
}
