package com.model.departamento;

import java.util.List;
import com.model.DAO;
import org.hibernate.Session;

public class DepartamentoDAO implements DAO<Departamento> {

    @Override
    public void persist(Departamento entity, Session session) {
        session.persist(entity);

    }

    @Override
    public void update(Departamento entity, Session session) {
        session.update(entity);

    }

    @Override
    public void delete(Departamento entity, Session session) {
        session.delete(entity);

    }

    @Override
    public void deleteAll(Session sesion) {
        sesion.createQuery("delete from Departamento").executeUpdate();

    }

    @Override
    public Departamento findById(int id, Session session) {
        return session.find(Departamento.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Departamento> findAll(Session session) {
        return (List<Departamento>) session.createQuery("from Departamento").list();
    }

}
