package lab01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public interface Salvavel {
	
	// Metodo para salvar as acoes dos jogadores
	default void salvaLog(String acao) {
		String nomeArquivo = "log_monopoly.txt";
		try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(acao + "\n");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
	}
	
	// Método padrão para imprimir o conteúdo do log
	default void imprimirLog() {
        String nomeArquivo = "log_monopoly.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de log: " + e.getMessage());
        }
    }
	
}
