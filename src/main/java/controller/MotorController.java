package controller;

import dao.MotorDao;
import model.Motor;

import java.util.List;

public class MotorController {
    private MotorDao motorDao;

    public MotorController() {
        this.motorDao = new MotorDao();
    }

    public void addMotor(Motor motor) {
        motorDao.addMotor(motor);
    }

    public List<Motor> getMotores() {
        return motorDao.getMotores();
    }

    public int countMotores() {
        return motorDao.countMotores();
    }
}