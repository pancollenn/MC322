package lab01;

public class CartaSorte {
	private int id;
	private String descricao;
	private int movimento; // Quantas casas avançar ou voltar
	private int efeito; // -1: negativo, 0: neutro; 1: positivo
	private float valor; // Valor negativo para ser pago ao banco e positivo para receber do banco
	private String acao; // Ação específica da carta
	public int tempo; // 0: usar imediatamente, 1: pode guardar para utilizar posteriormente
	private String restricao; // Condições de uso
	
	// Construtor
	public CartaSorte(int id, String descricao, int movimento, int efeito, float valor, String acao, int tempo, String restricao) {
		this.id = id;
		this.descricao = descricao;
		this.movimento = movimento;
		this.efeito = efeito;
		this.valor = valor;
		this.acao = acao;
		this.tempo = tempo;
		this.restricao = restricao;
	}
	
	// Getters e Setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
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
	
	public void setValor(float valor) {
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
		return "CartaSorte [Id= " + id + " Descrição= " + descricao + " Movimento= " + movimento 
				+ " Efeito= " + efeito + " Valor= " + valor + " Ação= " + acao + " Tempo= " + tempo 
				+ " Restrição= " + restricao + "]";
	}
}
