package lab01;

public class CartaSorte extends Carta {

	private int movimento; // Para que casa deve avancar (-1 caso nao haja movimento)
	private int efeito; // -1: negativo, 0: neutro; 1: positivo
	private int valor; // Valor para ser pago ou recebido
	private String acao; // Ação específica da carta
	public int tempo; // 0: usar imediatamente, 1: pode guardar para utilizar posteriormente
	private String restricao; // Condições de uso
	TipoCarta tipo;
	
	// Construtor
	public CartaSorte(int id, String descricao, Jogador dono, int movimento, int efeito, int valor, String acao, int tempo, String restricao, TipoCarta tipo) {
		
		super(id, descricao);
		this.dono = dono;
		this.movimento = movimento;
		this.efeito = efeito;
		this.valor = valor;
		this.acao = acao;
		this.tempo = tempo;
		this.restricao = restricao;
		this.tipo = tipo;
	}
	
	// Getters e Setters
	
	public int getMovimento() {
		return movimento;
	}
	
	public void setMovimento(int movimento) {
		this.movimento = movimento;
	}
	
	public int getEfeito() {
		return efeito;
	}
	
	public void setEfeito(int efeito) {
		this.efeito = efeito;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public int getTempo() {
		return tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public String getRestricao() {
		return restricao;
	}
	
	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}
	
	// Retorna os atributos da carta
	@Override
	public String toString() {
	    return "CartaSorte { Id: " + id + ", Descrição: " + descricao + 
	    		", Movimento: " + movimento + ", Efeito: " + efeito + 
	    		", Valor: " + valor + ", Ação: " + acao + ", Tempo: " + 
	    		tempo + ", Restrição: " + restricao + " }";

	}
	// Métodos da classe CartaSorte
	public void executaAcao(Jogador j, CartaSorte c) {
		switch (c.tipo) {
		case SORTE:
			j.setDinheiro(valor);
			System.out.println("Carta Sorte: ");
			System.out.println("O jogador ganhou " + valor + " reais.");
			break;
		case REVES:
			j.setDinheiro(valor);
			System.out.println("Carta Reves: ");
			System.out.println("O jogador perdeu " + valor + " reais.");
			break;
		}
	}
}
