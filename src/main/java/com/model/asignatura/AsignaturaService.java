package com.model.asignatura;

import java.util.List;

import com.model.DAOFactory;
import com.model.SesionFactory;

public class AsignaturaService {
    private AsignaturaDAO asignaturaDAO;
    private SesionFactory sessionFactory;

    public AsignaturaService() {
        this.asignaturaDAO = new DAOFactory().getAsignaturaDAO();
        this.sessionFactory = SesionFactory.getSesionFactory();
    }

    
    /** 
     * @param entity
     */
    public void persist(Asignatura entity) {
        this.sessionFactory.openCurrentSessionwithTransaction();
        this.asignaturaDAO.persist(entity, sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSessionwithTransaction();
    }

    
    /** 
     * @param entity
     */
    public void update(Asignatura entity) {
        this.sessionFactory.closeCurrentSessionwithTransaction();
        this.asignaturaDAO.update(entity, sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSessionwithTransaction();
    }

    
    /** 
     * @param id
     * @return Asignatura
     */
    public Asignatura findById(int id) {
        this.sessionFactory.openCurrentSession();
        Asignatura asignatura = asignaturaDAO.findById(id, sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSession();
        return asignatura;
    }

    
    /** 
     * @param item
     */
    public void delete(Asignatura item) {
        this.sessionFactory.openCurrentSessionwithTransaction();
        this.asignaturaDAO.delete(item, sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSessionwithTransaction();
    }

    
    /** 
     * @return List<Asignatura>
     */
    public List<Asignatura> findAll() {
        this.sessionFactory.openCurrentSession();
        List<Asignatura> asignaturas = this.asignaturaDAO.findAll(this.sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSession();
        return asignaturas;
    }

    public void deleteAll() {
        this.sessionFactory.openCurrentSessionwithTransaction();
        this.asignaturaDAO.deleteAll(sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSessionwithTransaction();
    }
}
