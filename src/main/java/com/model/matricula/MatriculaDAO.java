package com.model.matricula;

import java.util.List;

import com.model.DAO;

import org.hibernate.Session;

public class MatriculaDAO implements DAO<Matricula> {

    
    /** 
     * @param entity
     * @param session
     */
    @Override
    public void persist(Matricula entity, Session session) {
        session.persist(entity);

    }

    
    /** 
     * @param entity
     * @param session
     */
    @Override
    public void update(Matricula entity, Session session) {
        session.update(entity);

    }

    
    /** 
     * @param entity
     * @param session
     */
    @Override
    public void delete(Matricula entity, Session session) {
        session.delete(entity);

    }

    
    /** 
     * @param sesion
     */
    @Override
    public void deleteAll(Session sesion) {
        sesion.createQuery("delete from Matricula").executeUpdate();

    }

    
    /** 
     * @param id
     * @param session
     * @return Matricula
     */
    @Override
    public Matricula findById(int id, Session session) {
        return session.find(Matricula.class, id);
    }

    
    /** 
     * @param session
     * @return List<Matricula>
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Matricula> findAll(Session session) {
        return (List<Matricula>) session.createQuery("from Matricula").list();
    }

}
