package lab01;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	private List<Integer> jogadores;
	private List<Integer> propriedades;
	
	// Construtor
	public Tabuleiro() {
		this.jogadores = new ArrayList<> ();
		this.propriedades = new ArrayList<> ();
	}
	
	// Getters e Setters
	public List<Integer> getJogadores() {
		return jogadores;
	}
	
	public void setJogadores(List<Integer> jogadores) {
		this.jogadores = jogadores;
	}
	
	public List<Integer> getPropriedades() {
		return propriedades;
	}
	
	public void setPropriedades(List<Integer> propriedades) {
		this.propriedades = propriedades;
	}
	
	// Métodos da classe Tabuleiro
	
	// Imprime os id's da lista de jogadores e de propriedades
	public void imprimirTabuleiro() {
        System.out.println("Propriedades do tabuleiro:");
        for (int id_p : propriedades) {
            System.out.println(id_p);
        }
        System.out.println("Jogadores no tabuleiro:");
        for (int id_j : jogadores) {
            System.out.println(id_j);
        }
    }
	// Adiciona um jogador
	public boolean addJogador(int id) {
		return jogadores.add(id);
	}
	// Remove um jogador
	public boolean removeJogador(int id) {
		for (int i = 0; i < jogadores.size(); i++) {
			if (id == jogadores.get(i)) {
				jogadores.remove(i);
				return true;
			}
		}
		return false;
	}
	// Adiciona uma propriedade
	public boolean addPropriedade(int id) {
		return propriedades.add(id);
	}
	// Remove uma propriedade
	public boolean removePropriedade(int id) {
		for (int i = 0; i < propriedades.size(); i++) {
			if (id == propriedades.get(i)) {
				propriedades.remove(i);
				return true;
			}
		}
		return false; // Retorna false se não achar a propriedade
	}
}

