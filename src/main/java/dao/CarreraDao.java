package dao;

import database.HibernateUtil;
import model.Carrera;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CarreraDao {
    Session session;
    public List<Carrera> getCarreras(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Carrera> query = session.createQuery("from Carrera", Carrera.class);
        List<Carrera> listaCarreras = query.list();
        session.getTransaction().commit();
        session.close();
        return listaCarreras;
    }
}
