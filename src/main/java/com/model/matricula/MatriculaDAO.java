package com.model.matricula;

import java.util.List;

import com.model.DAO;

import org.hibernate.Session;

public class MatriculaDAO implements DAO<Matricula> {

    @Override
    public void persist(Matricula entity, Session session) {
        session.persist(entity);

    }

    @Override
    public void update(Matricula entity, Session session) {
        session.update(entity);

    }

    @Override
    public void delete(Matricula entity, Session session) {
        session.delete(entity);

    }

    @Override
    public void deleteAll(Session sesion) {
        sesion.createQuery("delete from Matricula").executeUpdate();

    }

    @Override
    public Matricula findById(int id, Session session) {
        return session.find(Matricula.class, id);
    }

    @Override
    public List<Matricula> findAll(Session session) {
        return (List<Matricula>) session.createQuery("from Matricula").list();
    }

}
