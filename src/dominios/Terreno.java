package dominios;

import java.util.List;

import lab01.Carta;
import lab01.Jogador;
import lab01.Tabuleiro;

public class Terreno extends Propriedade {
	private int numeroCasas;
	private int valorCasa;
	private int valorHotel;
	private boolean hotel;
	
	public Terreno(int id, String descricao, String nome, Jogador dono, int preco, int aluguel, int numeroCasas, int valorCasa, int valorHotel, boolean hotel) {
		super(id, descricao, nome, dono, preco, aluguel); // Atributos da superclasse
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
		String nomeDono;
		if (dono == null) {
			nomeDono = "Sem dono";
		}
		else {
			nomeDono = dono.getNome();
		}
	    return "Propriedade { ID: " + id + ", Nome: " + nome + ", Proprietário: " + nomeDono + 
	    		", Preço: " + preco + ", Aluguel: " + aluguel + ", Número de Casas: " + numeroCasas + 
	    		", Valor Casa: " + valorCasa + ", Valor Hotel: " + valorHotel + ", Possui Hotel: " + hotel + "}";
	}

	// Métodos definidos para terreno
	
	public boolean construirCasa(Jogador j, Tabuleiro t) throws SaldoInsuficienteException {
		// Verificar se o jogador possui a propriedade, se possui dinheiro suficiente e se tem menos de 4 casas
		if (dono != null ) {
			if (dono.getNome().equals(j.getNome()) && numeroCasas < 4) {
				try {
					int dinheiro = j.getDinheiro() - valorCasa; // Subtrai o preço da casa do saldo do jogador
					if (dinheiro >= 0) {
						System.out.println("Casa comprada em " + this.nome + " com sucesso!");
						j.setDinheiro(dinheiro);
						System.out.println("Jogador " + j.getNome() + " saldo: " + j.getDinheiro());
						numeroCasas++; // Aumenta uma casa no terreno
						String constroiCasa = String.format("%s construiu uma casa na propriedade %s", j.getNome(), this.nome);
						t.executarAcao(constroiCasa); // Salva a acao
						return true;
					}
					else {
						// Se o jogador nao tiver dinheiro suficiente lanca uma excessao
	                    throw new SaldoInsuficienteException("Saldo insuficiente para pagar a casa.");
					}
				}
				catch (SaldoInsuficienteException e) { // Tratamento da excessao
	                System.out.println(e.getMessage());
				}
			}
		}
		
		System.out.println("Não foi possível realizar a compra da casa.");
		return false;
	}
	
	public boolean construirHotel(Jogador j, Tabuleiro t) throws SaldoInsuficienteException{
		// Verificar se o jogador possui a propriedade, se possui dinheiro suficiente, se já tem 4 casas e se ainda não tem hotel
		if (dono.getNome().equals(j.getNome()) && numeroCasas == 4 && !hotel) {
			try {
				int dinheiro = j.getDinheiro() - valorHotel; // Subtrai o preço do hotel do saldo do jogador
				if (dinheiro>= 0) {
					System.out.println("Hotel comprado em " + this.nome + " com sucesso!");
					j.setDinheiro(dinheiro);
					System.out.println("Jogador " + j.getNome() + " saldo: " + j.getDinheiro());
					hotel = true; // O terreno passa a ter um hotel
					String constroiHotel = String.format("%s construiu um hotel na propriedade %s", j.getNome(), this.nome);
					t.executarAcao(constroiHotel); // Salva a acao
					return true;
				}
				else {
					// Se o jogador nao tiver dinheiro suficiente lanca uma excessao
                    throw new SaldoInsuficienteException("Saldo insuficiente para pagar o hotel.");
				}
			}
			catch(SaldoInsuficienteException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Não foi possível realizar a compra do hotel.");
		return false;
	}
	
	@Override
	public int calcularAluguel() { // O aluguel pode variar dependendo do numero de construcoes
		
		int aluguel;
		int numCasas = 0;
		numCasas = this.getNumeroCasas();
		if (this.getHotel()) {
			numCasas = 6; // O aluguel de um hotel corresponde ao preco do aluguel de 6 casas
		}
		if (numCasas > 0) {
			aluguel = super.calcularAluguel() + (super.calcularAluguel() * numCasas); // Novo aluguel corresponde a valor base vezes numero de casas construidas
		}
		else {
			System.out.println("Aluguel de " + this.getNome() + ": " + super.calcularAluguel()); // Se o terreno nao tiver casas, paga o valor base
			return super.calcularAluguel();
		}

		System.out.println("Aluguel de " + this.getNome() + ": " + aluguel);
		return aluguel;
	}
}
