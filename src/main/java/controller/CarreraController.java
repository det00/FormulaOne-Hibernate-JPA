package controller;

import dao.CarreraDao;
import model.Carrera;
import dto.CarreraPorPais;

import java.util.List;

public class CarreraController {
    private CarreraDao carreraDao;

    public CarreraController() {
        this.carreraDao = new CarreraDao();
    }

    public void addCarrera(Carrera carrera) {
        carreraDao.addCarrera(carrera);
    }

    public List<Carrera> getCarreras() {
        return carreraDao.getCarreras();
    }

    public List<CarreraPorPais> getCarrerasPorPaisConPilotos() {
        return carreraDao.getCarrerasPorPaisConPilotos();
    }
}