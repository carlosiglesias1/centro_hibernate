package com.model.departamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.model.profesor.Profesor;

@Entity
@Table(name = "dept")
public class Departamento {
    @Id
    @Column(name = "CODDEPT")
    private int code;
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPARTAMENTO")
    private List<Profesor> profesores;

    public Departamento(int code, String nombre) {
        this.code = code;
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
    }

    public Departamento(String nombre){
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
    }

    public Departamento() {
        // default constructor
    }

    /**
     * @return int
     */
    public int getCode() {
        return code;
    }

    /**
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * @return List<Profesor>
     */
    public List<Profesor> getProfesores() {
        return profesores;
    }

    /**
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * @param profesores
     */
    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "|" + this.code + "\t|\t" + this.nombre + "|";
    }
}
