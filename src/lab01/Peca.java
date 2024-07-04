package lab01;

import java.util.Random;

public class Peca {
	private String cor;
	private int posicao;
	
	// Construtor
	public Peca(String cor, int posicao) {
		this.cor = cor;
		this.posicao = posicao;
	}
	
	// Getters e Setters
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	// Retorna os atributos da peça
		@Override
		public String toString() {
			return "Peça: Cor: " + cor + ", Posição: " + posicao;
		}
		
	// Metodos da classe Peca
		
	// Obtem a casa atual do tabuleiro
	public Carta getCasaAtual(Tabuleiro t) {
		return t.getCasas().get(posicao) ;
	}
	
	// Move a peca de acordo com o numero rolado pelos dados
	public void moverJogador(int totalDados, Tabuleiro tabuleiro) {
		posicao = (posicao + totalDados) % tabuleiro.getCasas().size();
		this.setPosicao(totalDados);
		if (tabuleiro.getCasas().get(posicao) == null) {
			System.out.println("Casa atual: CasaSorte");
		}
		else {
			System.out.println("Casa atual: " + tabuleiro.getCasas().get(posicao));
		}
	}
}
