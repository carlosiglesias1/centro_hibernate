package com.model.profesor;

import java.util.List;

import com.model.SesionFactory;

public class ProfesorService {
    private ProfesorDAO profesorDAO;
    private SesionFactory sesionFactory;

    public ProfesorService() {
        this.profesorDAO = new ProfesorDAO();
        this.sesionFactory = SesionFactory.getSesionFactory();
    }

    public void persist(Profesor entity) {
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.profesorDAO.persist(entity, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }

    public void update(Profesor item) {
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.profesorDAO.update(item, sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }

    public Profesor findById(int id) {
        this.sesionFactory.openCurrentSession();
        Profesor profesor = this.profesorDAO.findById(id, sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSession();
        return profesor;
    }

    public List<Profesor> findAll() {
        this.sesionFactory.openCurrentSession();
        List<Profesor> profesores = this.profesorDAO.findAll(this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSession();
        return profesores;
    }

    public void delete(Profesor profesor) {
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.profesorDAO.delete(profesor, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }

    public void deleteAll() {
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.profesorDAO.deleteAll(this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }
}
