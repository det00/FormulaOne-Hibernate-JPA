package controller;

import dao.EquipoDao;
import model.Equipo;

import java.util.List;

public class EquipoController {
    private EquipoDao equipoDao;

    public EquipoController() {
        this.equipoDao = new EquipoDao();
    }

    public void addEquipo(Equipo equipo) {
        equipoDao.addEquipo(equipo);
    }

    public List<Equipo> getEquipos() {
        return equipoDao.getEquipos();
    }

    public List<Equipo> getEquiposConJefesYMotores() {
        return equipoDao.getEquiposConJefesYMotores();
    }
}