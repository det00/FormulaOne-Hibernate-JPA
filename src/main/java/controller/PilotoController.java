package controller;

import dao.PilotoDao;
import model.Piloto;

import java.util.List;

public class PilotoController {
    private PilotoDao pilotoDao;

    public PilotoController() {
        this.pilotoDao = new PilotoDao();
    }

    public void addPiloto(Piloto piloto) {
        pilotoDao.addPiloto(piloto);
    }

    public List<Piloto> getPilotos() {
        return pilotoDao.getPilotos();
    }

    public List<Piloto> getCampeonesMundo() {
        return pilotoDao.getCampeonesMundo();
    }

    public List<Piloto> getPilotosCampeonesPorEquipo() {
        return pilotoDao.getPilotosCampeonesPorEquipo();
    }

    public List<Piloto> getPilotosTodasCarreras() {
        return pilotoDao.getPilotosTodasCarreras();
    }
}