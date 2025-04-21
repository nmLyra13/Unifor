package projetoUnifor;

class ListaEncadeada {
	private No primeiro;

	public ListaEncadeada() {
		this.primeiro = null;
	}

	public No getPrimeiro() {
		return primeiro;
	}

	public void adicionar(int valor) {
		No novo = new No(valor);

		if (primeiro == null) {
			primeiro = novo;
			return;
		}

		if (valor < primeiro.getValor()) {
			novo.setProximo(primeiro);
			primeiro = novo;
			return;
		}

		No atual = primeiro;
		while (atual.getProximo() != null && atual.getProximo().getValor() < valor) {
			atual = atual.getProximo();
		}

		novo.setProximo(atual.getProximo());
		atual.setProximo(novo);
	}

	public boolean contem(int valor) {
		No atual = primeiro;

		while (atual != null) {
			if (atual.getValor() == valor) {
				return true;
			}
			atual = atual.getProximo();
		}

		return false;
	}
}