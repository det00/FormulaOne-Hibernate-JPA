package dao;

import database.HibernateUtil;
import model.Equipo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EquipoDao {
    Session session;
    public List<Equipo> getEquipos(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Equipo> query = session.createQuery("FROM Equipo e JOIN FETCH e.pilotos JOIN FETCH e.motor", Equipo.class);
        List<Equipo> listaEquipos = query.list();
        session.getTransaction().commit();
        session.close();
        return listaEquipos;
    }
}
