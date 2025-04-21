package projetoUnifor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TabelaHash {

    private final int TAMANHO = 26;
    private ListaEncadeadaPalavras[] tabela;

    public TabelaHash() {
        tabela = new ListaEncadeadaPalavras[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new ListaEncadeadaPalavras();
        }
    }

    private int funcaoHash(String palavra) {
        if (palavra == null || palavra.isEmpty()) {
            return -1;
        }
        char primeiraLetra = palavra.toLowerCase().charAt(0);
        return (primeiraLetra >= 'a' && primeiraLetra <= 'z') ? primeiraLetra - 'a' : -1;
    }

    public void adicionarPalavra(String texto, int linha) {
        if (texto.isEmpty()) {
            return;
        }

        int indice = funcaoHash(texto);
        if (indice < 0 || indice >= TAMANHO) {
            return;
        }

        Palavra palavra = tabela[indice].buscar(texto);

        if (palavra == null) {
            palavra = new Palavra(texto);
            palavra.adicionarOcorrencia(linha);
            tabela[indice].adicionar(palavra);
        } else {
            palavra.adicionarOcorrencia(linha);
        }
    }

    public Palavra buscarPalavra(String texto) {
        if (texto.isEmpty()) {
            return null;
        }

        int indice = funcaoHash(texto);
        if (indice < 0 || indice >= TAMANHO) {
            return null;
        }

        return tabela[indice].buscar(texto);
    }

    public List<Palavra> obterPalavrasOrdenadas() {
        List<Palavra> palavras = new ArrayList<>();

        for (ListaEncadeadaPalavras lista : tabela) {
            palavras.addAll(lista.obterTodas());
        }

        palavras.sort(Comparator.comparing(Palavra::getTexto));
        return palavras;
    }
}
