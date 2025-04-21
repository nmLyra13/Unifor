package projetoUnifor;

class NoPalavra {
	private Palavra palavra;
	private NoPalavra proximo;

	public NoPalavra(Palavra palavra) {
		this.palavra = palavra;
		this.proximo = null;
	}

	public Palavra getPalavra() {
		return palavra;
	}

	public NoPalavra getProximo() {
		return proximo;
	}

	public void setProximo(NoPalavra proximo) {
		this.proximo = proximo;
	}
}