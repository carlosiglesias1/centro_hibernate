package com.model.matricula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @Column(name = "IDMATRICULA")
    private int idMatricula;
    @Column(name = "ALUMNO")
    private int idAlumno;
    @Column(name = "ASIGNATURA")
    private int idAsignatura;
    @Column(name = "PROFESOR")
    private int idProfesor;

    public Matricula(){
        //default
    }

    public Matricula(int idMatricula, int idAlumno, int idAsignatura, int idProfesor) {
        this.idMatricula = idMatricula;
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
        this.idProfesor = idProfesor;
    }

    public Matricula (int idAlumno, int idAsignatura, int idProfesor){
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
        this.idProfesor = idProfesor;
    }

    
    /** 
     * @return int
     */
    public int getIdAlumno() {
        return idAlumno;
    }

    
    /** 
     * @return int
     */
    public int getIdAsignatura() {
        return idAsignatura;
    }

    
    /** 
     * @return int
     */
    public int getIdMatricula() {
        return idMatricula;
    }

    
    /** 
     * @return int
     */
    public int getIdProfesor() {
        return idProfesor;
    }

    
    /** 
     * @param idAlumno
     */
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    
    /** 
     * @param idAsignatura
     */
    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    
    /** 
     * @param idMatricula
     */
    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    
    /** 
     * @param idProfesor
     */
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
}
