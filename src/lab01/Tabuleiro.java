package lab01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominios.Propriedade;

public class Tabuleiro {
	private List<Jogador> jogadores;
	private List<Propriedade> propriedades;
	
	// Construtor
	public Tabuleiro() {
		this.jogadores = new ArrayList<> ();
		this.propriedades = new ArrayList<> ();
	}
	
	// Getters e Setters
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public List<Propriedade> getPropriedades() {
		return propriedades;
	}
	
	public void setPropriedades(List<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}
	
	// Métodos da classe Tabuleiro
	
	// Adiciona um jogador
	public boolean addJogador(Jogador j) {
		return jogadores.add(j);
	}
	
	// Remove um jogador buscando pelo seu id
	public boolean removeJogador(int id) {
		for (int i = 0; i < jogadores.size(); i++) {
			if (id == jogadores.get(i).getId()) {
				jogadores.remove(i);
				return true;
			}
		}
		return false;
	}
	// Adiciona uma propriedade
	public boolean addPropriedade(Propriedade p) {
		return propriedades.add(p);
	}
	// Remove uma propriedade buscando pelo seu id
	public boolean removePropriedade(int id) {
		for (int i = 0; i < propriedades.size(); i++) {
			if (id == propriedades.get(i).getId()) {
				propriedades.remove(i);
				return true;
			}
		}
		return false; // Retorna false se não achar a propriedade
	}
	
	public void menuAcoes(Scanner entrada) {
	    // Listo as opções de ação
	    System.out.println("Menu de ações:\n"
	            + "1. Estado do jogador\n"
	            + "2. Comprar carta sorte\n"
	            + "3. Comprar propriedade\n"
	            + "4. Comprar casa\n"
	            + "5. Comprar hotel");

	    String comando = entrada.next();
	    if (comando.equals("1")) {
	        System.out.println("Digite o ID do jogador: ");
	        String idString = entrada.next();
	        int id = Integer.parseInt(idString);
	        for (int i = 0; i < jogadores.size(); i++) {
	            if(id == jogadores.get(i).getId()) {
	                System.out.println(jogadores.get(i));
	            }
	        }
	    }
	    else if (comando.equals("2") || comando.equals("3") || comando.equals("4") || comando.equals("5")) {
	        System.out.println("Função ainda não disponível");
	    }
	}
}

