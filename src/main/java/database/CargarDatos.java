package database;

import controller.CarreraController;
import controller.EquipoController;
import controller.JefeEquipoController;
import controller.MotorController;
import controller.PilotoController;
import model.*;

import java.time.LocalDate;
import java.util.Arrays;

public class CargarDatos {
    private MotorController motorController;
    private JefeEquipoController jefeEquipoController;
    private EquipoController equipoController;
    private PilotoController pilotoController;
    private CarreraController carreraController;

    public CargarDatos(MotorController motorController, JefeEquipoController jefeEquipoController,
                      EquipoController equipoController, PilotoController pilotoController,
                      CarreraController carreraController) {
        this.motorController = motorController;
        this.jefeEquipoController = jefeEquipoController;
        this.equipoController = equipoController;
        this.pilotoController = pilotoController;
        this.carreraController = carreraController;
    }

    public void cargarDatosIniciales() {
        motorController.addMotor(new Motor("Ferrari", null, 800, 7));
        motorController.addMotor(new Motor("Mercedes", null, 850, 8));
        motorController.addMotor(new Motor("Honda RBPT", null, 830, 2));
        motorController.addMotor(new Motor("Renault", null, 780, 1));
        motorController.addMotor(new Motor("Audi", null, 820, 0));

        JefeEquipo fredVasseur = new JefeEquipo("Fred", "Vasseur", "Francia", 56, null);
        JefeEquipo totoWolff = new JefeEquipo("Toto", "Wolff", "Austria", 53, null);
        JefeEquipo christianHorner = new JefeEquipo("Christian", "Horner", "Reino Unido", 51, null);
        JefeEquipo zakBrown = new JefeEquipo("Zak", "Brown", "EE.UU.", 53, null);
        JefeEquipo mikeKrack = new JefeEquipo("Mike", "Krack", "Luxemburgo", 52, null);
        JefeEquipo alessandroAlunni = new JefeEquipo("Alessandro", "Alunni Bravi", "Italia", 49, null);
        JefeEquipo laurentMekies = new JefeEquipo("Laurent", "Mekies", "Francia", 47, null);
        JefeEquipo jamesVowles = new JefeEquipo("James", "Vowles", "Reino Unido", 45, null);
        JefeEquipo ayaoKomatsu = new JefeEquipo("Ayao", "Komatsu", "Japón", 48, null);
        JefeEquipo brunoFamin = new JefeEquipo("Bruno", "Famin", "Francia", 62, null);

        java.util.List<Motor> motoresPersistidos = motorController.getMotores();

        Equipo ferrari = new Equipo("Ferrari", motoresPersistidos.get(0), null, fredVasseur, "Italia", 1947, 16, 15);
        Equipo mercedes = new Equipo("Mercedes", motoresPersistidos.get(1), null, totoWolff, "Alemania", 1954, 8, 9);
        Equipo redBull = new Equipo("Red Bull Racing", motoresPersistidos.get(2), null, christianHorner, "Austria", 2005, 6, 7);
        Equipo mclaren = new Equipo("McLaren", motoresPersistidos.get(1), null, zakBrown, "Reino Unido", 1963, 9, 8);
        Equipo astonMartin = new Equipo("Aston Martin", motoresPersistidos.get(1), null, mikeKrack, "Reino Unido", 2018, 0, 0);
        Equipo sauber = new Equipo("Sauber", motoresPersistidos.get(4), null, alessandroAlunni, "Suiza", 1993, 0, 0);
        Equipo racingBulls = new Equipo("Racing Bulls", motoresPersistidos.get(2), null, laurentMekies, "Italia", 2006, 0, 0);
        Equipo williams = new Equipo("Williams", motoresPersistidos.get(1), null, jamesVowles, "Reino Unido", 1977, 9, 7);
        Equipo haas = new Equipo("Haas", motoresPersistidos.get(0), null, ayaoKomatsu, "EE.UU.", 2016, 0, 0);
        Equipo alpine = new Equipo("Alpine", motoresPersistidos.get(3), null, brunoFamin, "Francia", 2021, 0, 0);

        fredVasseur.setEquipo(ferrari);
        totoWolff.setEquipo(mercedes);
        christianHorner.setEquipo(redBull);
        zakBrown.setEquipo(mclaren);
        mikeKrack.setEquipo(astonMartin);
        alessandroAlunni.setEquipo(sauber);
        laurentMekies.setEquipo(racingBulls);
        jamesVowles.setEquipo(williams);
        ayaoKomatsu.setEquipo(haas);
        brunoFamin.setEquipo(alpine);

        equipoController.addEquipo(ferrari);
        equipoController.addEquipo(mercedes);
        equipoController.addEquipo(redBull);
        equipoController.addEquipo(mclaren);
        equipoController.addEquipo(astonMartin);
        equipoController.addEquipo(sauber);
        equipoController.addEquipo(racingBulls);
        equipoController.addEquipo(williams);
        equipoController.addEquipo(haas);
        equipoController.addEquipo(alpine);

        Piloto lewisHamilton = new Piloto("Lewis", "Hamilton", 40, 7, "Reino Unido", ferrari, null);
        Piloto charlesLeclerc = new Piloto("Charles", "Leclerc", 27, 0, "Mónaco", ferrari, null);
        Piloto georgeRussell = new Piloto("George", "Russell", 27, 0, "Reino Unido", mercedes, null);
        Piloto kimiAntonelli = new Piloto("Kimi", "Antonelli", 18, 0, "Italia", mercedes, null);
        Piloto maxVerstappen = new Piloto("Max", "Verstappen", 27, 4, "Países Bajos", redBull, null);
        Piloto liamLawson = new Piloto("Liam", "Lawson", 23, 0, "Nueva Zelanda", redBull, null);
        Piloto landoNorris = new Piloto("Lando", "Norris", 25, 0, "Reino Unido", mclaren, null);
        Piloto oscarPiastri = new Piloto("Oscar", "Piastri", 23, 0, "Australia", mclaren, null);
        Piloto fernandoAlonso = new Piloto("Fernando", "Alonso", 43, 2, "España", astonMartin, null);
        Piloto lanceStroll = new Piloto("Lance", "Stroll", 26, 0, "Canadá", astonMartin, null);
        Piloto nicoHulkenberg = new Piloto("Nico", "Hülkenberg", 37, 0, "Alemania", sauber, null);
        Piloto gabrielBortoleto = new Piloto("Gabriel", "Bortoleto", 20, 0, "Brasil", sauber, null);
        Piloto yukiTsunoda = new Piloto("Yuki", "Tsunoda", 24, 0, "Japón", racingBulls, null);
        Piloto isackHadjar = new Piloto("Isack", "Hadjar", 20, 0, "Francia", racingBulls, null);
        Piloto carlosSainz = new Piloto("Carlos", "Sainz", 30, 0, "España", williams, null);
        Piloto alexAlbon = new Piloto("Alex", "Albon", 28, 0, "Tailandia", williams, null);
        Piloto estebanOcon = new Piloto("Esteban", "Ocon", 28, 0, "Francia", haas, null);
        Piloto ollieBearman = new Piloto("Ollie", "Bearman", 19, 0, "Reino Unido", haas, null);
        Piloto pierreGasly = new Piloto("Pierre", "Gasly", 29, 0, "Francia", alpine, null);
        Piloto jackDoohan = new Piloto("Jack", "Doohan", 22, 0, "Australia", alpine, null);

        ferrari.setPilotos(Arrays.asList(lewisHamilton, charlesLeclerc));
        mercedes.setPilotos(Arrays.asList(georgeRussell, kimiAntonelli));
        redBull.setPilotos(Arrays.asList(maxVerstappen, liamLawson));
        mclaren.setPilotos(Arrays.asList(landoNorris, oscarPiastri));
        astonMartin.setPilotos(Arrays.asList(fernandoAlonso, lanceStroll));
        sauber.setPilotos(Arrays.asList(nicoHulkenberg, gabrielBortoleto));
        racingBulls.setPilotos(Arrays.asList(yukiTsunoda, isackHadjar));
        williams.setPilotos(Arrays.asList(carlosSainz, alexAlbon));
        haas.setPilotos(Arrays.asList(estebanOcon, ollieBearman));
        alpine.setPilotos(Arrays.asList(pierreGasly, jackDoohan));

        pilotoController.addPiloto(lewisHamilton);
        pilotoController.addPiloto(charlesLeclerc);
        pilotoController.addPiloto(georgeRussell);
        pilotoController.addPiloto(kimiAntonelli);
        pilotoController.addPiloto(maxVerstappen);
        pilotoController.addPiloto(liamLawson);
        pilotoController.addPiloto(landoNorris);
        pilotoController.addPiloto(oscarPiastri);
        pilotoController.addPiloto(fernandoAlonso);
        pilotoController.addPiloto(lanceStroll);
        pilotoController.addPiloto(nicoHulkenberg);
        pilotoController.addPiloto(gabrielBortoleto);
        pilotoController.addPiloto(yukiTsunoda);
        pilotoController.addPiloto(isackHadjar);
        pilotoController.addPiloto(carlosSainz);
        pilotoController.addPiloto(alexAlbon);
        pilotoController.addPiloto(estebanOcon);
        pilotoController.addPiloto(ollieBearman);
        pilotoController.addPiloto(pierreGasly);
        pilotoController.addPiloto(jackDoohan);

        Carrera gpAustralia = new Carrera("GP Australia", LocalDate.of(2025, 3, 16), "Australia", null);
        Carrera gpChina = new Carrera("GP China", LocalDate.of(2025, 3, 23), "China", null);
        Carrera gpJapon = new Carrera("GP Japón", LocalDate.of(2025, 4, 6), "Japón", null);
        Carrera gpBahrein = new Carrera("GP Bahréin", LocalDate.of(2025, 4, 13), "Bahréin", null);
        Carrera gpArabiaSaudita = new Carrera("GP Arabia Saudita", LocalDate.of(2025, 4, 20), "Arabia Saudita", null);
        Carrera gpMiami = new Carrera("GP Miami", LocalDate.of(2025, 5, 4), "EE.UU.", null);
        Carrera gpEmiliaRomagna = new Carrera("GP Emilia-Romaña", LocalDate.of(2025, 5, 18), "Italia", null);
        Carrera gpMonaco = new Carrera("GP Mónaco", LocalDate.of(2025, 5, 25), "Mónaco", null);
        Carrera gpEspana = new Carrera("GP España", LocalDate.of(2025, 6, 1), "España", null);
        Carrera gpCanada = new Carrera("GP Canadá", LocalDate.of(2025, 6, 15), "Canadá", null);
        Carrera gpAustria = new Carrera("GP Austria", LocalDate.of(2025, 6, 29), "Austria", null);
        Carrera gpGranBretana = new Carrera("GP Gran Bretaña", LocalDate.of(2025, 7, 6), "Reino Unido", null);
        Carrera gpBelgica = new Carrera("GP Bélgica", LocalDate.of(2025, 7, 27), "Bélgica", null);
        Carrera gpHungria = new Carrera("GP Hungría", LocalDate.of(2025, 8, 3), "Hungría", null);
        Carrera gpPaisesBajos = new Carrera("GP Países Bajos", LocalDate.of(2025, 8, 31), "Países Bajos", null);
        Carrera gpItalia = new Carrera("GP Italia", LocalDate.of(2025, 9, 7), "Italia", null);
        Carrera gpAzerbaiyan = new Carrera("GP Azerbaiyán", LocalDate.of(2025, 9, 21), "Azerbaiyán", null);
        Carrera gpSingapur = new Carrera("GP Singapur", LocalDate.of(2025, 10, 5), "Singapur", null);
        Carrera gpEEUU = new Carrera("GP Estados Unidos", LocalDate.of(2025, 10, 19), "EE.UU.", null);
        Carrera gpMexico = new Carrera("GP México", LocalDate.of(2025, 10, 26), "México", null);
        Carrera gpBrasil = new Carrera("GP Brasil", LocalDate.of(2025, 11, 9), "Brasil", null);
        Carrera gpLasVegas = new Carrera("GP Las Vegas", LocalDate.of(2025, 11, 22), "EE.UU.", null);
        Carrera gpQatar = new Carrera("GP Qatar", LocalDate.of(2025, 11, 30), "Qatar", null);
        Carrera gpAbuDhabi = new Carrera("GP Abu Dhabi", LocalDate.of(2025, 12, 7), "Emiratos Árabes Unidos", null);

        carreraController.addCarrera(gpAustralia);
        carreraController.addCarrera(gpChina);
        carreraController.addCarrera(gpJapon);
        carreraController.addCarrera(gpBahrein);
        carreraController.addCarrera(gpArabiaSaudita);
        carreraController.addCarrera(gpMiami);
        carreraController.addCarrera(gpEmiliaRomagna);
        carreraController.addCarrera(gpMonaco);
        carreraController.addCarrera(gpEspana);
        carreraController.addCarrera(gpCanada);
        carreraController.addCarrera(gpAustria);
        carreraController.addCarrera(gpGranBretana);
        carreraController.addCarrera(gpBelgica);
        carreraController.addCarrera(gpHungria);
        carreraController.addCarrera(gpPaisesBajos);
        carreraController.addCarrera(gpItalia);
        carreraController.addCarrera(gpAzerbaiyan);
        carreraController.addCarrera(gpSingapur);
        carreraController.addCarrera(gpEEUU);
        carreraController.addCarrera(gpMexico);
        carreraController.addCarrera(gpBrasil);
        carreraController.addCarrera(gpLasVegas);
        carreraController.addCarrera(gpQatar);
        carreraController.addCarrera(gpAbuDhabi);

        java.util.List<Piloto> todosPilotos = Arrays.asList(lewisHamilton, charlesLeclerc, georgeRussell, kimiAntonelli,
                maxVerstappen, liamLawson, landoNorris, oscarPiastri, fernandoAlonso, lanceStroll,
                nicoHulkenberg, gabrielBortoleto, yukiTsunoda, isackHadjar, carlosSainz, alexAlbon,
                estebanOcon, ollieBearman, pierreGasly, jackDoohan);
        java.util.List<Carrera> todasCarreras = carreraController.getCarreras();

        for (Piloto piloto : todosPilotos) {
            piloto.setCarreras(todasCarreras);
            pilotoController.addPiloto(piloto);
        }

        for (Carrera carrera : todasCarreras) {
            carrera.setPilotos(todosPilotos);
        }
    }
}