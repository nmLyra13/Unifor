package projetoUnifor;

import java.util.ArrayList;
import java.util.List;

class ListaEncadeadaPalavras {
	private NoPalavra primeiro;

	public ListaEncadeadaPalavras() {
		this.primeiro = null;
	}

	public void adicionar(Palavra palavra) {
		NoPalavra novo = new NoPalavra(palavra);

		if (primeiro == null) {
			primeiro = novo;
			return;
		}

		NoPalavra atual = primeiro;
		while (atual.getProximo() != null) {
			atual = atual.getProximo();
		}

		atual.setProximo(novo);
	}

	public Palavra buscar(String texto) {
		NoPalavra atual = primeiro;

		while (atual != null) {
			if (atual.getPalavra().getTexto().equals(texto)) {
				return atual.getPalavra();
			}
			atual = atual.getProximo();
		}

		return null;
	}

	public List<Palavra> obterTodas() {
		List<Palavra> palavras = new ArrayList<>();
		NoPalavra atual = primeiro;

		while (atual != null) {
			palavras.add(atual.getPalavra());
			atual = atual.getProximo();
		}

		return palavras;
	}
}