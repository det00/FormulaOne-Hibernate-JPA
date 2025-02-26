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

    public List<Piloto> getCamepeonesMundo(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Piloto> query = session.createQuery("FROM Piloto p where p.campeonatos > 0", Piloto.class);
        List<Piloto> pilotos = query.list();
        session.getTransaction().commit();
        session.close();
        return pilotos;
    }
}