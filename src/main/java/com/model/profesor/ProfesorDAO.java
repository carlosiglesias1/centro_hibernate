package com.model.profesor;

import java.util.List;

import com.model.DAO;

import org.hibernate.Session;

public class ProfesorDAO implements DAO<Profesor> {
    public ProfesorDAO() {
        // empty
    }

    
    /** 
     * @param item
     * @param session
     */
    @Override
    public void persist(Profesor item, Session session) {
        session.persist(item);
    }

    
    /** 
     * @param item
     * @param session
     */
    @Override
    public void update(Profesor item, Session session) {
        session.update(item);
    }

    
    /** 
     * @param id
     * @param session
     * @return Profesor
     */
    @Override
    public Profesor findById(int id, Session session) {
        return session.find(Profesor.class, id);
    }

    
    /** 
     * @param item
     * @param session
     */
    @Override
    public void delete(Profesor item, Session session) {
        session.delete(item);
    }

    
    /** 
     * @param session
     */
    @Override
    public void deleteAll(Session session) {
        session.createQuery("DELETE FROM profesor").executeUpdate();
    }

    
    /** 
     * @param session
     * @return List<Profesor>
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> findAll(Session session) {
        return (List<Profesor>) session.createQuery("FROM Profesor").list();
    }
}
