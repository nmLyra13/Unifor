package projetoUnifor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IndiceRemissivo {
	private TabelaHash tabelaHash;

	public IndiceRemissivo() {
		tabelaHash = new TabelaHash();
	}

	// Processa o texto do arquivo e armazena palavras e suas ocorrências
	public void processarTexto(String nomeArquivo) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
			String linha;
			int numeroLinha = 1;

			while ((linha = br.readLine()) != null) {
				// Remove pontuação e divide a linha em palavras
				String[] palavras = linha.replaceAll("[^a-zA-Z\\s-]", "").toLowerCase().split("\\s+");

				for (String palavra : palavras) {
					if (!palavra.isEmpty()) {
						tabelaHash.adicionarPalavra(palavra, numeroLinha);
					}
				}

				numeroLinha++;
			}
		}
	}

	// Gera o índice remissivo a partir das palavras-chave
	public void gerarIndiceRemissivo(String arquivoPalavrasChave, String arquivoSaida) throws IOException {
		// Lê as palavras-chave
		List<String> palavrasChave = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(arquivoPalavrasChave))) {
			String linha;

			while ((linha = br.readLine()) != null) {
				String[] palavras = linha.split(",\\s*");
				Collections.addAll(palavrasChave, palavras);
			}
		}

		// Ordena as palavras-chave
		Collections.sort(palavrasChave);

		// Gera o arquivo de saída
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {
			for (String palavraChave : palavrasChave) {
				Palavra palavra = tabelaHash.buscarPalavra(palavraChave.trim().toLowerCase());

				if (palavra != null) {
					bw.write(palavra.getTexto() + " " + palavra.getOcorrenciasFormatadas());
					bw.newLine();
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			IndiceRemissivo indice = new IndiceRemissivo();

			// Processar o texto (substitua pelos nomes corretos dos arquivos)
			indice.processarTexto("texto.txt");

			// Gerar o índice remissivo
			indice.gerarIndiceRemissivo("palavras-chave.txt", "indice-remissivo.txt");

			System.out.println("Índice remissivo gerado com sucesso!");
		} catch (IOException e) {
			System.err.println("Erro ao processar os arquivos: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
