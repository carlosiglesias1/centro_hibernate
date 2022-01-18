package com.model.asignatura;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignatura")
public class Asignatura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODASIGN")
    private int codAsignatura;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CURSO")
    private String curso;

    public Asignatura(int code, String nombre, String curso) {
        this.codAsignatura = code;
        this.nombre = nombre;
        this.curso = curso;
    }

    public Asignatura() {

    }

    public Asignatura(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    /**
     * @return int
     */
    public int getCodAsignatura() {
        return codAsignatura;
    }

    /**
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return String
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param codAsignatura
     */
    public void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param curso
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return this.codAsignatura + "\t|\t" + this.nombre + "\t|\t" + this.curso;
    }
}
