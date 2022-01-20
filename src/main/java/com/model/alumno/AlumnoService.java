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

    
    /** 
     * @param object
     */
    public void persist(Alumno object) {
        this.sesion.openCurrentSessionwithTransaction();
        this.alumnoDAO.persist(object, this.sesion.getCurrentSession());
        this.sesion.closeCurrentSessionwithTransaction();
    }

    
    /** 
     * @param entity
     */
    public void update(Alumno entity) {
        this.sesion.openCurrentSessionwithTransaction();
        this.alumnoDAO.update(entity, this.sesion.getCurrentSession());
        this.sesion.closeCurrentSessionwithTransaction();
    }

    
    /** 
     * @param entity
     */
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

    
    /** 
     * @param id
     * @return Alumno
     */
    public Alumno findById(int id) {
        this.sesion.openCurrentSession();
        Alumno alumno = this.alumnoDAO.findById(id, this.sesion.getCurrentSession());
        this.sesion.closeCurrentSession();
        return alumno;
    }

    
    /** 
     * @return List<Alumno>
     */
    public List<Alumno> findAll() {
        this.sesion.openCurrentSession();
        List<Alumno> alumnos = this.alumnoDAO.findAll(this.sesion.getCurrentSession());
        this.sesion.closeCurrentSession();
        return alumnos;
    }
}
