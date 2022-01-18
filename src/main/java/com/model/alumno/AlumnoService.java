package com.model.alumno;

import java.util.List;

import com.model.SesionFactory;

public class AlumnoService {
    private AlumnoDAO alumnoDAO;
    private SesionFactory sesion;

    public AlumnoService() {
        this.alumnoDAO = new AlumnoDAO();
        this.sesion = SesionFactory.getSesionFactory();
    }

    public void persist(Alumno object) {
        this.sesion.openCurrentSessionwithTransaction();
        this.alumnoDAO.persist(object, this.sesion.getCurrentSession());
        this.sesion.closeCurrentSessionwithTransaction();
    }

    public void update(Alumno entity) {
        this.sesion.openCurrentSessionwithTransaction();
        this.alumnoDAO.update(entity, this.sesion.getCurrentSession());
        this.sesion.closeCurrentSessionwithTransaction();
    }

    public void delete(Alumno entity) {
        this.sesion.openCurrentSessionwithTransaction();
        this.alumnoDAO.delete(entity, this.sesion.getCurrentSession());
        this.sesion.closeCurrentSessionwithTransaction();
    }

    public void deleteAll() {
        this.sesion.openCurrentSessionwithTransaction();
        this.alumnoDAO.deleteAll(this.sesion.getCurrentSession());
        this.sesion.closeCurrentSessionwithTransaction();
    }

    public Alumno findById(int id) {
        this.sesion.openCurrentSession();
        Alumno alumno = this.alumnoDAO.findById(id, this.sesion.getCurrentSession());
        this.sesion.closeCurrentSession();
        return alumno;
    }

    public List<Alumno> findAll() {
        this.sesion.openCurrentSession();
        List<Alumno> alumnos = this.alumnoDAO.findAll(this.sesion.getCurrentSession());
        this.sesion.closeCurrentSession();
        return alumnos;
    }
}
