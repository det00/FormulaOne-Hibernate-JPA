import controller.CarreraController;
import controller.EquipoController;
import controller.JefeEquipoController;
import controller.MotorController;
import controller.PilotoController;
import database.CargarDatos;
import ui.Menu;

public class Entrada {
    public static void main(String[] args) {
        MotorController motorController = new MotorController();
        JefeEquipoController jefeEquipoController = new JefeEquipoController();
        EquipoController equipoController = new EquipoController();
        PilotoController pilotoController = new PilotoController();
        CarreraController carreraController = new CarreraController();

        CargarDatos cargarDatos = new CargarDatos(motorController, jefeEquipoController, equipoController, pilotoController, carreraController);

        Menu menu = new Menu(motorController, jefeEquipoController, equipoController, pilotoController, carreraController, cargarDatos);
        menu.mostrarMenu();

        System.out.println("Programa finalizado.");
    }
}