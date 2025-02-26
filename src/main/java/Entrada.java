import dao.CarreraDao;
import dao.EquipoDao;
import dao.PilotoDao;
import model.Carrera;
import model.Equipo;
import model.Piloto;

import java.util.List;

public class Entrada {

    public static void main(String[] args) {
        PilotoDao pilotoDao = new PilotoDao();
        EquipoDao equipoDao = new EquipoDao();
        CarreraDao carreraDao = new CarreraDao();

        /*for (Equipo e: equipoDao.getEquipos()){
            System.out.println(e);
        }

        for (Piloto p:pilotoDao.getCamepeonesMundo()){
            System.out.println(p);
        }*/

        for (Carrera c: carreraDao.getCarreras()){
            System.out.println(c.getFecha() + " " + c.getNombre() + " (" + c.getPais() + ")");
            System.out.println();
        }

        List<Piloto> campeones = pilotoDao.getCamepeonesMundo();

        System.out.println("Campeones del Mundo:");
        System.out.printf("%-20s %-10s %-15s%n", "Nombre", "Edad", "Campeonatos");
        System.out.println("-".repeat(45));

        for (Piloto p : campeones) {
            System.out.printf("%-20s %-10d %-15d%n",
                    p.getNombre() + " " + p.getApellidos(),
                    p.getEdad(),
                    p.getCampeonatos());
        }
    }
}