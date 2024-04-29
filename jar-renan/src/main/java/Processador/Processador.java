package Processador;

public class Processador {

    private String modelo;
    private String fabricante;
    private Integer nucleosFisicos;
    private Integer nucleosLogicos;


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNucleosFisicos() {
        return String.valueOf(nucleosFisicos);
    }

    public void setNucleosFisicos(Integer nucleosFisicos) {
        this.nucleosFisicos = nucleosFisicos;
    }

    public String getNucleosLogicos() {
        return String.valueOf(nucleosLogicos);
    }

    public void setNuclSeosLogicos(Integer nucleosLogicos) {
        this.nucleosLogicos = nucleosLogicos;
    }

}
