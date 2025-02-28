package dao;

import database.HibernateUtil;
import model.Carrera;
import dto.CarreraPorPais;  // Asegúrate de importar desde dto
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CarreraDao {
    Session session;

    public List<Carrera> getCarreras() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Carrera> query = session.createQuery("FROM Carrera", Carrera.class);
        List<Carrera> listaCarreras = query.list();
        session.getTransaction().commit();
        session.close();
        return listaCarreras;
    }

    public void addCarrera(Carrera carrera) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(carrera);
        session.getTransaction().commit();
        session.close();
    }

    public List<CarreraPorPais> getCarrerasPorPaisConPilotos() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<CarreraPorPais> query = session.createQuery(
                "SELECT new dto.CarreraPorPais(c.pais, COUNT(c), SIZE(c.pilotos)) " +
                        "FROM Carrera c " +
                        "GROUP BY c.pais " +
                        "ORDER BY c.pais", CarreraPorPais.class
        );
        List<CarreraPorPais> result = query.list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}