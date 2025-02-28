package dto;

public class CarreraPorPais {
    private String pais;
    private long numeroCarreras;
    private int pilotosPorCarrera;

    public CarreraPorPais(String pais, long numeroCarreras, int pilotosPorCarrera) {
        this.pais = pais;
        this.numeroCarreras = numeroCarreras;
        this.pilotosPorCarrera = pilotosPorCarrera;
    }

    public String getPais() {
        return pais;
    }

    public long getNumeroCarreras() {
        return numeroCarreras;
    }

    public int getPilotosPorCarrera() {
        return pilotosPorCarrera;
    }
}