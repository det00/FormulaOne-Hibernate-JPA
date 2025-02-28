package dao;

import database.HibernateUtil;
import model.Motor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MotorDao {
    Session session;

    public List<Motor> getMotores() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Motor> query = session.createQuery("FROM Motor", Motor.class);
        List<Motor> motores = query.list();
        session.getTransaction().commit();
        session.close();
        return motores;
    }

    public void addMotor(Motor motor) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(motor);
        session.getTransaction().commit();
        session.close();
    }

    public int countMotores() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Motor", Long.class);
        long count = query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return (int) count;
    }
}