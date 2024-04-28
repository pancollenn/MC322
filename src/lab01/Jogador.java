package lab01;

import java.util.ArrayList;
import java.util.List;

import dominios.Propriedade;

public class Jogador {
	static int contador = 0; // Contador de jogadores
	private String nome;
	private String cpf;
	private String email;
	private String foto;
	private int id;
	private int dinheiro;
	private Peca peca;
	private List<Carta> cartas;
	
	// Construtor
	public Jogador(String nome, String cpf, String email, String foto, Peca peca) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.foto = foto;
		this.id = contador;
		this.dinheiro = 1500;
		this.peca = peca;
		this.cartas = new ArrayList<>();
		contador++;
	}
	
	// Getters e Setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDinheiro() {
		return dinheiro;
	}
	
	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro; 
	}
	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	// Retorna os atributos do jogador
	@Override
	public String toString() {
	    return "Jogador { Nome: " + nome + ", CPF: " + cpf + ", Email: " 
	    		+ email + ", Foto: " + foto + ", ID: " + id + ", Dinheiro: " 
	    		+ dinheiro + ", " + peca + " }";
	}
	
	// Métodos dos Jogadores
	
	public boolean comprarPropriedade(Propriedade p) {
		if (dinheiro > p.getPreco()) {
			dinheiro -= p.getPreco();
			cartas.add(p);
			p.setDono(this);
			System.out.println("Propriedade " + p.getNome() + " comprada com sucesso.");
			System.out.println("Jogador " + nome + " saldo: " + dinheiro);
		}
		else {
			System.out.println("Saldo insuficiente.");
			return false;
		}
		return true;
	}
}