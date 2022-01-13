package com.model.profesor;

import java.util.List;

import com.model.DAO;

import org.hibernate.Session;

public class ProfesorDAO implements DAO<Profesor> {
    public ProfesorDAO() {
        // empty
    }

    @Override
    public void persist(Profesor item, Session session) {
        session.persist(item);
    }

    @Override
    public void update(Profesor item, Session session) {
        session.update(item);
    }

    @Override
    public Profesor findById(int id, Session session) {
        return session.find(Profesor.class, id);
    }

    @Override
    public void delete(Profesor item, Session session) {
        session.delete(item);
    }

    @Override
    public void deleteAll(Session session) {
        session.createQuery("DELETE FROM profesor").executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> findAll(Session session) {
        return  session.createQuery("FROM profesor").list();
    }
}
