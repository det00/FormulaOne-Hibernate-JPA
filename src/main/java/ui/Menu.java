package ui;

import controller.CarreraController;
import controller.EquipoController;
import controller.JefeEquipoController;
import controller.MotorController;
import controller.PilotoController;
import database.CargarDatos;
import dto.CarreraPorPais;
import model.*;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private MotorController motorController;
    private JefeEquipoController jefeEquipoController;
    private EquipoController equipoController;
    private PilotoController pilotoController;
    private CarreraController carreraController;
    private CargarDatos cargarDatos;
    private Scanner scanner;

    public Menu(MotorController motorController, JefeEquipoController jefeEquipoController,
                       EquipoController equipoController, PilotoController pilotoController,
                       CarreraController carreraController, CargarDatos cargarDatos) {
        this.motorController = motorController;
        this.jefeEquipoController = jefeEquipoController;
        this.equipoController = equipoController;
        this.pilotoController = pilotoController;
        this.carreraController = carreraController;
        this.cargarDatos = cargarDatos;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Menú de Formula 1 2025 ===");
            System.out.println("1. Cargar datos iniciales");
            System.out.println("2. Mostrar pilotos con más campeonatos por equipo");
            System.out.println("3. Mostrar carreras por país con participación de pilotos");
            System.out.println("4. Mostrar equipos con sus jefes y motores");
            System.out.println("5. Mostrar pilotos que corren todas las carreras");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción (1-6): ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    int motoresExistentes = motorController.countMotores();
                    if (motoresExistentes == 0) {
                        System.out.println("Insertando datos iniciales...");
                        cargarDatos.cargarDatosIniciales();
                        System.out.println("Datos iniciales insertados exitosamente.");
                    } else {
                        System.out.println("Los datos ya están cargados en la base de datos.");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Pilotos con más campeonatos por equipo ===");
                    List<Piloto> campeonesPorEquipo = pilotoController.getPilotosCampeonesPorEquipo();
                    for (Piloto piloto : campeonesPorEquipo) {
                        System.out.printf("Piloto: %s %s (Equipo: %s, Campeonatos: %d)%n",
                                piloto.getNombre(), piloto.getApellidos(), piloto.getEquipo().getNombre(), piloto.getCampeonatos());
                    }
                    break;

                case 3:
                    System.out.println("\n=== Carreras por país con participación de pilotos ===");
                    List<CarreraPorPais> carrerasPorPais = carreraController.getCarrerasPorPaisConPilotos();
                    for (CarreraPorPais carrera : carrerasPorPais) {
                        System.out.printf("País: %s (Carreras: %d, Pilotos por carrera: %d)%n",
                                carrera.getPais(), carrera.getNumeroCarreras(), carrera.getPilotosPorCarrera());
                    }
                    break;

                case 4:
                    System.out.println("\n=== Equipos con sus jefes y motores ===");
                    List<Equipo> equiposJefesMotores = equipoController.getEquiposConJefesYMotores();
                    for (Equipo equipo : equiposJefesMotores) {
                        System.out.printf("Equipo: %s (Jefe: %s %s, Motor: %s)%n",
                                equipo.getNombre(), equipo.getJefeEquipo().getNombre(), equipo.getJefeEquipo().getApellido(), equipo.getMotor().getNombre());
                    }
                    break;

                case 5:
                    System.out.println("\n=== Pilotos que corren todas las carreras ===");
                    List<Piloto> pilotosTodasCarreras = pilotoController.getPilotosTodasCarreras();
                    for (Piloto piloto : pilotosTodasCarreras) {
                        System.out.printf("Piloto: %s %s (Equipo: %s)%n",
                                piloto.getNombre(), piloto.getApellidos(), piloto.getEquipo().getNombre());
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione entre 1 y 6.");
                    break;
            }
        }

        scanner.close();
    }
}