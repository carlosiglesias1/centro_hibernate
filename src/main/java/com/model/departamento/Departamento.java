package com.model.departamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Departamento {
    @Id
    @Column(name = "CODDEPT")
    private int code;
    @Column(name = "NOMBRE")
    private String nombre;

    public Departamento(int code, String nombre) {
        this.code = code;
        this.nombre = nombre;
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
     * @return String
     */
    @Override
    public String toString() {
        return "|" + this.code + "\t|\t" + this.nombre + "|";
    }
}
