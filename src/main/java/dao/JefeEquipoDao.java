package dao;

import database.HibernateUtil;
import model.JefeEquipo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class JefeEquipoDao {
    Session session;

    public List<JefeEquipo> getJefesEquipo() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<JefeEquipo> query = session.createQuery("FROM JefeEquipo", JefeEquipo.class);
        List<JefeEquipo> jefes = query.list();
        session.getTransaction().commit();
        session.close();
        return jefes;
    }

    public void addJefeEquipo(JefeEquipo jefeEquipo) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(jefeEquipo);
        session.getTransaction().commit();
        session.close();
    }
}