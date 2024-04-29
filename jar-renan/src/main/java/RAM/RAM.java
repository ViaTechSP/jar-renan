package RAM;

public class RAM {
    private String disponivel;
    private String memoriaTotal;
    private String memoriaUtilizada;

    public String getDisponivel() {
        return String.valueOf(disponivel);
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getMemoriaTotal() {
        return String.valueOf(memoriaTotal);
    }

    public void setMemoriaTotal(String memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public String getMemoriaUtilizada() {
        return String.valueOf(memoriaUtilizada);
    }

    public void setMemoriaUtilizada(String memoriaUtilizada) {
        this.memoriaUtilizada = memoriaUtilizada;
    }
}
