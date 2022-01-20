package com.model.asignatura;

import java.util.List;

import com.model.DAO;

import org.hibernate.Session;

public class AsignaturaDAO implements DAO<Asignatura> {
    @Override
    public void persist(Asignatura asignatura, Session session) {
        session.persist(asignatura);
    }

    @Override
    public void update(Asignatura asignatura, Session session) {
        session.update(asignatura);
    }

    @Override
    public void delete(Asignatura asignatura, Session session) {
        session.delete(asignatura);
    }

    @Override
    public void deleteAll(Session session) {
        session.createQuery("DELETE FROM asignatura").executeUpdate();
    }

    @Override
    public Asignatura findById(int id, Session session) {
        return session.find(Asignatura.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Asignatura> findAll(Session session) {
        return (List<Asignatura>) session.createQuery("FROM Asignatura").list();
    }
}
