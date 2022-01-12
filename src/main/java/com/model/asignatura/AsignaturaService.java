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

    public void persist(Asignatura entity) {
        this.sessionFactory.openCurrentSessionwithTransaction();
        this.asignaturaDAO.persist(entity, sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSessionwithTransaction();
    }

    public void update(Asignatura entity) {
        this.sessionFactory.closeCurrentSessionwithTransaction();
        this.asignaturaDAO.update(entity, sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSessionwithTransaction();
    }

    public Asignatura findById(int id) {
        this.sessionFactory.openCurrentSession();
        Asignatura asignatura = asignaturaDAO.findById(id, sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSession();
        return asignatura;
    }

    public void delete(int id) {
        this.sessionFactory.openCurrentSessionwithTransaction();
        Asignatura asignatura = this.asignaturaDAO.findById(id, sessionFactory.getCurrentSession());
        this.asignaturaDAO.delete(asignatura, sessionFactory.getCurrentSession());
        this.sessionFactory.closeCurrentSessionwithTransaction();
    }

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
