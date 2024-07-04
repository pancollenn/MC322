package lab01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import dominios.Estacao;
import dominios.Propriedade;
import dominios.SaldoInsuficienteException;
import dominios.ServicoPublico;
import dominios.Terreno;

public class Tabuleiro implements Salvavel {
	private List<Jogador> jogadores;
	private List<Propriedade> propriedades;
	private List<CartaSorte> cartasSorte;
	private List<Carta> casas;
	
	// Construtor
	public Tabuleiro() {
		this.jogadores = new ArrayList<> ();
		this.propriedades = new ArrayList<> ();
		this.casas = new ArrayList<> ();
		this.cartasSorte = new ArrayList<> ();
		inicializarTabuleiro();
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
	
	public List<Carta> getCasas() {
		return casas;
	}
	
	public void setCasas(List<Carta> casas) {
		this.casas = casas;
	}
	
	public List<CartaSorte> getCartasSorte() {
		return cartasSorte;
	}
	
	public void setCartasSorte(List<CartaSorte> cartasSorte) {
		this.cartasSorte = cartasSorte;
	}
	
	// Métodos da classe Tabuleiro
	
	// Insere as propriedades e as cartas sorte no tabuleiro
	private void inicializarTabuleiro() {
		// Declaro as cartas sorte
			CartaSorte c1 = new CartaSorte(1, "Avance até a partida", null, 0, 0, 0,
	                "Avance para a casa de partida e receba 200", 0,
	                "Nao tem restricao", TipoCarta.SORTE);
			CartaSorte c2 = new CartaSorte(1, "Avance até a partida", null, 0, 0, 0,
	                "Avance para a casa de partida e receba 200", 0,
	                "Nao tem restricao", TipoCarta.SORTE);
			CartaSorte c3 = new CartaSorte(2, "Pague um imposto de luxo de 100", null, -1, -1, 100,
	                "Pague um imposto de luxo de 100", 0,
	                "Nao tem restricao", TipoCarta.REVES);
			CartaSorte c4 = new CartaSorte(3, "Receba 50 de aluguel", null, -1, 1, 50,
	                "Receba 50 de aluguel", 0,
	                "Nao tem restricao", TipoCarta.SORTE);
			CartaSorte c5 = new CartaSorte(4, "Vá para a cadeia", null, -1, -1, 0,
	                "Va direto para a cadeia", 0,
	                "Nao tem restricao", TipoCarta.REVES);
			CartaSorte c6 = new CartaSorte(5, "Receba 100", null, -1, 1, 100,
	                "Receba 100", 0,
	                "Nao tem restricao", TipoCarta.SORTE);
			CartaSorte c7 = new CartaSorte(6, "Pague 50 por casa e 200 por hotel", null, -1, -1, 0,
	                "Pague 50 por cada casa e 200 por cada hotel que possuir", 0,
	                "Nao tem restricao", TipoCarta.REVES);
			CartaSorte c8 = new CartaSorte(7, "Vá até o shopping", null, -1, 0, 0,
	                "Va ate o shopping", 0,
	                "Nao tem restricao", TipoCarta.SORTE);
			CartaSorte c9 = new CartaSorte(8, "Receba 25 de presente", null, -1, 1, 25,
	                "Receba 25 de presente", 0,
	                "Nao tem restricao", TipoCarta.SORTE);
			CartaSorte c10 = new CartaSorte(9, "Vá até a avenida Paulista", null, 16, 0, 0,
	                "Va ate a avenida Paulista", 0,
	                "Nao tem restricao", TipoCarta.SORTE);
			CartaSorte c11 = new CartaSorte(10, "Receba 20 de presente", null, -1, 1, 20,
	                 "Receba 20 de presente", 0,
	                 "Nao tem restricao", TipoCarta.SORTE);
			addCartaSorte(c1);
			addCartaSorte(c2);
			addCartaSorte(c3);
			addCartaSorte(c4);
			addCartaSorte(c5);
			addCartaSorte(c6);
			addCartaSorte(c7);
			addCartaSorte(c8);
			addCartaSorte(c9);
			addCartaSorte(c10);
			addCartaSorte(c11);
			
			// Declaro as estações
			Estacao e1 = new Estacao(1, "Estação Ferroviária Central", "Central", null, 200, 50, 25);
	        Estacao e2 = new Estacao(2, "Estação do Norte", "Norte", null, 250, 60, 30);
	        Estacao e3 = new Estacao(3, "Estação Sul", "Sul", null, 220, 55, 27);
	        Estacao e4 = new Estacao(4, "Estação Oeste", "Oeste", null, 230, 57, 28);
	        addPropriedade(e1);
	        addPropriedade(e2);
	        addPropriedade(e3);
	        addPropriedade(e4);
			
			// Declaro os terrenos
	        Terreno t1 = new Terreno(1, "Avenida Mediterrâneo", "Mediterrâneo", null, 60, 2, 0, 50, 50, false);
	        Terreno t2 = new Terreno(2, "Avenida Báltica", "Báltica", null, 60, 4, 0, 50, 50, false);
	        Terreno t3 = new Terreno(3, "Avenida Oriental", "Oriental", null, 100, 6, 0, 50, 50, false);
	        Terreno t4 = new Terreno(4, "Avenida Vermont", "Vermont", null, 100, 6, 0, 50, 50, false);
	        Terreno t5 = new Terreno(5, "Avenida Connecticut", "Connecticut", null, 120, 8, 0, 50, 50, false);
	        Terreno t6 = new Terreno(6, "Rua São Carlos", "São Carlos", null, 140, 10, 0, 100, 100, false);
	        Terreno t7 = new Terreno(7, "Rua Estados Unidos", "Estados Unidos", null, 140, 10, 0, 100, 100, false);
	        Terreno t8 = new Terreno(8, "Avenida São João", "São João", null, 160, 12, 0, 100, 100, false);
	        Terreno t9 = new Terreno(9, "Avenida Ipiranga", "Ipiranga", null, 160, 12, 0, 100, 100, false);
	        Terreno t10 = new Terreno(10, "Rua Augusta", "Augusta", null, 180, 14, 0, 100, 100, false);
	        Terreno t11 = new Terreno(11, "Avenida Paulista", "Paulista", null, 200, 16, 0, 150, 150, false);
	        Terreno t12 = new Terreno(12, "Jardins", "Jardins", null, 200, 16, 0, 150, 150, false);
	        Terreno t13 = new Terreno(13, "Brooklin", "Brooklin", null, 220, 18, 0, 150, 150, false);
	        Terreno t14 = new Terreno(14, "Moema", "Moema", null, 220, 18, 0, 150, 150, false);
	        Terreno t15 = new Terreno(15, "Morumbi", "Morumbi", null, 240, 20, 0, 200, 200, false);
	        Terreno t16 = new Terreno(16, "Butantã", "Butantã", null, 260, 22, 0, 200, 200, false);
	        Terreno t17 = new Terreno(17, "Itaim Bibi", "Itaim Bibi", null, 260, 22, 0, 200, 200, false);
	        Terreno t18 = new Terreno(18, "Vila Madalena", "Vila Madalena", null, 280, 24, 0, 200, 200, false);
	        Terreno t19 = new Terreno(19, "Tatuapé", "Tatuapé", null, 300, 26, 0, 250, 250, false);
	        Terreno t20 = new Terreno(20, "Liberdade", "Liberdade", null, 300, 26, 0, 250, 250, false);
	        Terreno t21 = new Terreno(21, "Santana", "Santana", null, 320, 28, 0, 250, 250, false);
	        Terreno t22 = new Terreno(22, "Interlagos", "Interlagos", null, 350, 35, 0, 300, 300, false);
			addPropriedade(t1);
			addPropriedade(t2);
			addPropriedade(t3);
			addPropriedade(t4);
			addPropriedade(t5);
			addPropriedade(t6);
			addPropriedade(t7);
			addPropriedade(t8);
			addPropriedade(t9);
			addPropriedade(t10);
			addPropriedade(t11);
			addPropriedade(t12);
			addPropriedade(t13);
			addPropriedade(t14);
			addPropriedade(t15);
			addPropriedade(t16);
			addPropriedade(t17);
			addPropriedade(t18);
			addPropriedade(t19);
			addPropriedade(t20);
			addPropriedade(t21);
			addPropriedade(t22);
			
			// Declaro os serviços públicos
			ServicoPublico sp1 = new ServicoPublico(1, "Companhia de Água", "Água", null, 150, 0, 4);
	        ServicoPublico sp2 = new ServicoPublico(2, "Companhia de Energia", "Energia", null, 150, 0, 4);
			addPropriedade(sp1);
			addPropriedade(sp2);
			
			// Salvo nas posicoes corretas no tabuleiro
			CartaSorte cartasorte = null; // Sinaliza que o jogador deve comprar uma carta sorte
			casas.add(t1);
			casas.add(cartasorte);
			casas.add(t2);
			casas.add(e1);
			casas.add(t3);
			casas.add(cartasorte);
			casas.add(t4);
			casas.add(t5);
			casas.add(t6);
			casas.add(sp1);
			casas.add(t7);
			casas.add(t8);
			casas.add(e2);
			casas.add(t9);
			casas.add(cartasorte);
			casas.add(t10);
			casas.add(t11);
			casas.add(t12);
			casas.add(cartasorte);
			casas.add(t13);
			casas.add(t14);
			casas.add(e3);
			casas.add(t15);
			casas.add(t16);
			casas.add(sp2);
			casas.add(t17);
			casas.add(t18);
			casas.add(t19);
			casas.add(cartasorte);
			casas.add(t20);
			casas.add(e4);
			casas.add(cartasorte);
			casas.add(t21);
			casas.add(t22);
	}
	
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
	
	// Adiciona carta sorte
	public boolean addCartaSorte(CartaSorte c) {
		return cartasSorte.add(c);
	}
	// Remove uma carta sorte buscando pelo seu id
		public boolean removeCartaSorte(int id) {
			for (int i = 0; i < cartasSorte.size(); i++) {
				if (id == cartasSorte.get(i).getId()) {
					cartasSorte.remove(i);
					return true;
				}
			}
			return false; // Retorna false se não achar a carta sorte
		}
	
	public void menuAcoes(Scanner entrada, Jogador jogador) throws SaldoInsuficienteException {
		// Lembrar de  usar salvaLog()
	
		while (true) {
			// Listo as opções de ação
		    System.out.println("Menu de ações:\n"
		            + "1. Estado do jogador\n"
		            + "2. Comprar propriedade\n"
		            + "3. Construir casa\n"
		            + "4. Construir hotel\n"
		            + "5. Passar a vez");

		    String comando = entrada.next();
		    if (comando.equals("1")) {	
		    	
                System.out.println(jogador); // Imprime o estado do jogador      
		    }
		    
		    else if (comando.equals("2")) {

		        boolean propriedadeComprada = false;

		        try {
		            Carta casaAtual = jogador.getPeca().getCasaAtual(this);

		            // Verificar se algum jogador já possui a propriedade
		            if (casaAtual.getDono() != null) {
		                System.out.println("Um jogador já possui esta propriedade!");
		                System.out.println();
		            } 
		            else {
		                // Verifica se a casa atual é uma propriedade
		                if (casaAtual instanceof Propriedade) {
		                    Propriedade propriedade = (Propriedade) casaAtual;
		                    System.out.println("Casa atual: " + propriedade.getDescricao() // Imprime a descricao e o preco da propriedade
		                            + ", Preco: " + propriedade.getPreco());
		                    int dinheiro = jogador.getDinheiro() - propriedade.getPreco();
		                    if (dinheiro >= 0) {
		                        jogador.setDinheiro(dinheiro);
		                        casaAtual.setDono(jogador); // Define o jogador como dono da propriedade
		                        jogador.distribuirCartas(propriedade); // Entrega a carta da propriedade para o jogador
		                        System.out.println("Propriedade comprada com sucesso!");
		                        propriedadeComprada = true;
		                        String compraPropriedade = String.format("%s comprou propriedade %s", jogador.getNome(), casaAtual.descricao);
								executarAcao(compraPropriedade); // Salva a acao
		                    } 
	                    else {
	                        // Se o jogador nao tiver dinheiro suficiente lanca uma exceção
	                        throw new SaldoInsuficienteException("Saldo insuficiente para pagar a propriedade.");
	                    }
	                } 
		                else {
		                    System.out.println("A casa atual não é uma propriedade.");
		                }
		            }
		        } 
		        catch (SaldoInsuficienteException e) { // Tratamento da exceção
		            System.out.println(e.getMessage());
		        }

		        // Se a propriedade foi comprada com sucesso, sair do loop while
		        if (propriedadeComprada) {
		            break;
		        }
		    }

		    else if (comando.equals("3")) {
		    	
            	Carta casaAtual = jogador.getPeca().getCasaAtual(this);
            	// Verifica se a casa atual é uma propriedade
                if (casaAtual instanceof Propriedade) {
                    Propriedade propriedade = (Propriedade) casaAtual;
                    if (propriedade instanceof Terreno) {
                    	Terreno terreno = (Terreno) propriedade;
                    	terreno.construirCasa(jogador, this);
                    	break;
                    }
                    else {
                    	System.out.println("Nao e possivel construir casas fora de terreno.");
                    	System.out.println();
                    }
                }
	            else {
	            	System.out.println("Jogador nao encontrado.");
	            }
		    }
		    
		    else if (comando.equals("4")) {
            	Carta casaAtual = jogador.getPeca().getCasaAtual(this);
            	// Verifica se a casa atual é uma propriedade
                if (casaAtual instanceof Propriedade) {
                    Propriedade propriedade = (Propriedade) casaAtual;
                    if (propriedade instanceof Terreno) {
                    	Terreno terreno = (Terreno) propriedade;
                    	terreno.construirHotel(jogador, this);
                    	break;
                    }
                }
                else {
	            	System.out.println("Jogador nao encontrado.");
                }
		    }
		    
		    else if (comando.equals("5")) {
		    	String acao = String.format("%s passou sua vez.", jogador.getNome());
				executarAcao(acao); // Salva a acao
		    	break;
		    }
		}	    
	}
	public void executarAcao(String acao) {
        // Anotar a ação no log
        salvaLog(acao);
    }
}

