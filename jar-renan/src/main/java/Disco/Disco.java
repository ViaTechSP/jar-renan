package Disco;

public class Disco {

    private String tempoEmAtividade;
    private String espacoDisponivel;
    private String espacoTotal;

    public String getTempoEmAtividade() {
        return String.valueOf(tempoEmAtividade);
    }

    public void setTempoEmAtividade(String tempoEmAtividade) {
        this.tempoEmAtividade = tempoEmAtividade;
    }

    public String getEspacoDisponivel() {
        return String.valueOf(espacoDisponivel);
    }

    public void setEspacoDisponivel(String espacoDisponivel) {
        this.espacoDisponivel = espacoDisponivel;
    }

    public String getEspacoTotal() {
        return String.valueOf(espacoTotal);
    }

    public void setEspacoTotal(String espacoTotal) {
        this.espacoTotal = espacoTotal;
    }
}
