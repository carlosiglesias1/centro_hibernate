package com.model.alumno;

import java.util.List;

import com.model.DAO;

import org.hibernate.Session;

public class AlumnoDAO implements DAO<Alumno> {
    @Override
    public void persist(Alumno entity, Session session) {
        session.persist(entity);
    }

    @Override
    public void update(Alumno entity, Session session) {
        session.update(entity);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Alumno> findAll(Session session) {
        return (List<Alumno>) session.createQuery("from Alumno").list();
    }

    @Override
    public Alumno findById(int id, Session session) {
        return session.find(Alumno.class, id);
    }

    @Override
    public void delete(Alumno entity, Session session) {
        session.delete(entity);

    }

    @Override
    public void deleteAll(Session sesion) {
        sesion.createQuery("delete from Alumno").executeUpdate();
    }
}
