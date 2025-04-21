package projetoUnifor;

import java.util.Objects;

class Palavra {

    private String texto;
    private ListaEncadeada ocorrencias;

    public Palavra(String texto) {
        this.texto = texto;
        this.ocorrencias = new ListaEncadeada();
    }

    public String getTexto() {
        return texto;
    }

    public void adicionarOcorrencia(int linha) {
        if (!ocorrencias.contem(linha)) {
            ocorrencias.adicionar(linha);
        }
    }

    public String getOcorrenciasFormatadas() {
        if (ocorrencias.getPrimeiro() == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        No atual = ocorrencias.getPrimeiro();

        while (atual != null) {
            sb.append(atual.getValor());
            if (atual.getProximo() != null) {
                sb.append(" ");
            }
            atual = atual.getProximo();
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Palavra palavra = (Palavra) obj;
        return Objects.equals(texto, palavra.texto);
    }
}
