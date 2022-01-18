package com.model.alumno;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.model.asignatura.Asignatura;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    private int idAlumno;
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fecha")
    private LocalDate birthDate;

    public Alumno(int idAlumno, String dni, String nombre, String apellidos, LocalDate nacimiento) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.birthDate = nacimiento;
    }

    public Alumno() {
    }

    /**
     * @return int
     */
    public int getIdAlumno() {
        return idAlumno;
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

    /**
     * @return LocalDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * @param idAlumno
     */
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
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

    /**
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return this.idAlumno + "\t|\t" + this.dni + "\t|\t" + this.nombre + "\t|\t" + this.apellidos + "\t|\t"
                + this.birthDate;
    }
}
