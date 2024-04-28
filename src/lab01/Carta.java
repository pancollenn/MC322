package lab01;

public class Carta {
	public int id;
	public String descricao;
	public Jogador dono;
	
	// Construtor
	public Carta(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
		this.dono = null;
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

		public Jogador getDono() {
			return dono;
		}

		public void setDono(Jogador dono) {
			this.dono = dono;
		}	
}

