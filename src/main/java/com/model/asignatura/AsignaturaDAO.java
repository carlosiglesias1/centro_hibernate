package com.model.asignatura;

import java.util.List;

import com.model.DAO;

import org.hibernate.Session;

public class AsignaturaDAO implements DAO<Asignatura> {
    
    /** 
     * @param asignatura
     * @param session
     */
    @Override
    public void persist(Asignatura asignatura, Session session) {
        session.persist(asignatura);
    }

    
    /** 
     * @param asignatura
     * @param session
     */
    @Override
    public void update(Asignatura asignatura, Session session) {
        session.update(asignatura);
    }

    
    /** 
     * @param asignatura
     * @param session
     */
    @Override
    public void delete(Asignatura asignatura, Session session) {
        session.delete(asignatura);
    }

    
    /** 
     * @param session
     */
    @Override
    public void deleteAll(Session session) {
        session.createQuery("DELETE FROM asignatura").executeUpdate();
    }

    
    /** 
     * @param id
     * @param session
     * @return Asignatura
     */
    @Override
    public Asignatura findById(int id, Session session) {
        return session.find(Asignatura.class, id);
    }

    
    /** 
     * @param session
     * @return List<Asignatura>
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Asignatura> findAll(Session session) {
        return (List<Asignatura>) session.createQuery("FROM Asignatura").list();
    }
}
