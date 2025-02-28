package controller;

import dao.JefeEquipoDao;
import model.JefeEquipo;

import java.util.List;

public class JefeEquipoController {
    private JefeEquipoDao jefeEquipoDao;

    public JefeEquipoController() {
        this.jefeEquipoDao = new JefeEquipoDao();
    }

    public void addJefeEquipo(JefeEquipo jefeEquipo) {
        jefeEquipoDao.addJefeEquipo(jefeEquipo);
    }

    public List<JefeEquipo> getJefesEquipo() {
        return jefeEquipoDao.getJefesEquipo();
    }
}