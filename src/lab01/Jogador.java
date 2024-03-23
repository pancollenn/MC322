package lab01;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome;
	private String cpf;
	private String email;
	private String foto;
	
	// Construtor
	public Jogador(String nome, String cpf, String email, String foto) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.foto = foto;
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
	
	// Checa se o cpf possui 11 dígitos
	public boolean tamanhoCorreto(String cpfNumerico) {
		if (cpfNumerico.length() != 11) { // Se não possuir 11 dígitos, cpf é inválido
			return false;
		}
		return true;
	}
	
	// Checa se o cpf é formado por 11 dígitos iguais
	public boolean tudoIgual(String cpfNumerico) {
		int i = 0;
		char primeiroCaracter = cpfNumerico.charAt(0); // Salva o primeiro caracter do cpf
		// Percorre o cpf, sempre que um caracter for igual ao primeiro, adiciona à "i". Se i chegar a 11, todos os caracteres são iguais
		for (int j = 0; j < cpfNumerico.length(); j++) { 
			if (cpfNumerico.charAt(j) == primeiroCaracter) {
				i++;
			}
		}
		if (i == 11) { // Se os 11 dígitos forem iguais, retorna true
			return true;
		}
		return false;
	}
	
	// Realiza as operações para determinar o primeiro dígito verificador
	public boolean verificarPrimeiro(List<Integer> digitosInt) {
		int digito = 0;
		int operacao = (digitosInt.get(0) * 10) + (digitosInt.get(1) * 9)
					 + (digitosInt.get(2) * 8) + (digitosInt.get(3) * 7)
					 + (digitosInt.get(4) * 6) + (digitosInt.get(5) * 5)
					 + (digitosInt.get(6) * 4) + (digitosInt.get(7) * 3)
					 + (digitosInt.get(8) * 2);
		int resto = operacao % 11;
		// Se o resto for 0 ou 1, digito continua valendo 0
		// Se o resto for diferente disso, o digito recebe 11 - resto
		if (resto > 1) {
			digito = 11 - resto;
		}
		if (digito == digitosInt.get(9)) {
			return true;
		}
		return false;
	}
	
	// Realiza as operações para determinar o segundo dígito verificador
	public boolean verificarSegundo(List<Integer> digitosInt) {
		int digito = 0;
		int operacao = (digitosInt.get(0) * 11) + (digitosInt.get(1) * 10)
				 	+ (digitosInt.get(2) * 9) + (digitosInt.get(3) * 8)
				 	+ (digitosInt.get(4) * 7) + (digitosInt.get(5) * 6)
				 	+ (digitosInt.get(6) * 5) + (digitosInt.get(7) * 4)
				 	+ (digitosInt.get(8) * 3) + (digitosInt.get(9) * 2);
		int resto = operacao % 11;
		// Se o resto for 0 ou 1, digito continua valendo 0
		// Se o resto for diferente disso, o digito recebe 11 - resto
		if (resto > 1) {
			digito = 11 - resto;
		}
		if (digito == digitosInt.get(10)) {
			return true;
		}
		return false;
	}
	
	// Checa se os dígitos verificadores estão corretos
	public boolean verificadoresCorretos(String cpfNumerico) {
		// Crio uma lista de inteiros para salvar o cpf
		List<Integer> digitosInt = new ArrayList<>();
		
		for (int i = 0; i < cpfNumerico.length(); i++) {
			char caracter = cpfNumerico.charAt(i); // Acesso cada dígito
			int digito = Character.getNumericValue(caracter); // Transformo em int
			digitosInt.add(digito); // Salvo cada dígito na lista
		}	
		// Realizo a checagem dos dígitos verificadores
		if (!verificarPrimeiro(digitosInt)) {
			return false;
		}
		else if (!verificarSegundo(digitosInt)) {
			return false;
		}
		return true;
	}
	
	// Verifica se o CPF é válido
	public boolean validarCPF(String cpf) {
		String cpfNumerico = cpf.replaceAll("[^0-9]", ""); // Remove todos os caracteres não numéricos do cpf
		if (!tamanhoCorreto(cpfNumerico)) { // Se não tiver 11 dígitos, retorna false
			return false;
		}
		else if (tudoIgual(cpfNumerico)) { // Se todos os digitos forem iguais, retorna false
			return false;
		}
		else if (!verificadoresCorretos(cpfNumerico)) { // Se os dígitos verificadores forem inválidos, retorna false
			return false;
		}
		return true;
	}
	
	// Verifica se o email é válido
	public boolean validarEmail(String email) {
		// Verifico se o campo está em branco
		if (email == null || email.isEmpty()) {
			return false;
		}
		// Verifica se há um e apenas um @
		int posicaoArroba = email.indexOf('@');
		if (posicaoArroba == -1 || posicaoArroba != email.lastIndexOf('@')) {
			return false;
		}
		// Verifica se há um . depois do @
		int posicaoPonto = email.indexOf('.', posicaoArroba);
		if (posicaoPonto == -1 || posicaoPonto == email.length() - 1) {
			return false;
		}
		// Verifica se há mais de um caracter especial seguido
		String regex = ".*\\p{Punct}\\p{Punct}.*"; // Qualquer caracter de pontuação
		if (email.matches(regex)) {
			return false;
		}
		// Verifica se há espaços em branco
		if (email.contains(" ")) {
			return false;
		}
		return true;
	}
	// Retorna os atributos do jogador
	@Override
	public String toString() {
		return "Jogador [Nome= " + nome + " CPF= " + cpf + " Email= " + email + " Foto= " + foto + "]";
	}
}