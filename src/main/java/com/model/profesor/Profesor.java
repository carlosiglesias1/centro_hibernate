package com.model.profesor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODPROF")
    private int codProf;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @JoinColumn(name = "DEPARTAMENTO")
    private int departamento;

    public Profesor(int codProf, String dni, String nombre, String apellidos, int departamento) {
        this.codProf = codProf;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
    }

    public Profesor(String dni, String nombre, String apellidos, int departamento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
    }

    public Profesor() {
    }

    /**
     * @return int
     */
    public int getCodProf() {
        return codProf;
    }

    /**
     * @return String
     */
    public String getDni() {
        return dni;
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
    public String getApellidos() {
        return apellidos;
    }

    public int getDepartamento() {
        return departamento;
    }

    /**
     * @param codProf
     */
    public void setCodProf(int codProf) {
        this.codProf = codProf;
    }

    /**
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "\t|" + this.codProf + "\t|\t" + this.dni + "\t|\t" + this.nombre + "\t|\t" + this.apellidos + "\t|\t";
    }
}
