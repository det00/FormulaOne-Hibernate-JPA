package dao;

import database.HibernateUtil;
import model.Piloto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PilotoDao {
    Session session;

    public List<Piloto> getPilotos() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Piloto> query = session.createQuery("FROM Piloto", Piloto.class);
        List<Piloto> pilotos = query.list();
        session.getTransaction().commit();
        session.close();
        return pilotos;
    }

    public List<Piloto> getCampeonesMundo() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Piloto> query = session.createQuery("FROM Piloto p WHERE p.campeonatos > 0", Piloto.class);
        List<Piloto> pilotos = query.list();
        session.getTransaction().commit();
        session.close();
        return pilotos;
    }

    public void addPiloto(Piloto piloto) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        if (piloto.getId() == 0) {
            session.save(piloto);
        } else {
            session.update(piloto);
        }
        session.getTransaction().commit();
        session.close();
    }

    public List<Piloto> getPilotosCampeonesPorEquipo() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Piloto> query = session.createQuery(
                "FROM Piloto p JOIN FETCH p.equipo " +
                        "WHERE p.campeonatos > 0 " +
                        "ORDER BY p.campeonatos DESC", Piloto.class
        );
        List<Piloto> result = query.list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<Piloto> getPilotosTodasCarreras() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Long> countQuery = session.createQuery("SELECT COUNT(*) FROM Carrera", Long.class);
        long totalCarreras = countQuery.uniqueResult();
        Query<Piloto> query = session.createQuery(
                "SELECT p FROM Piloto p WHERE SIZE(p.carreras) = :totalCarreras", Piloto.class
        );
        query.setParameter("totalCarreras", totalCarreras);
        List<Piloto> result = query.list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}