package com.model;

import com.model.asignatura.AsignaturaDAO;

public class DAOFactory {
    public DAOFactory(){
        super();
    }
    
    /** 
     * @return AsignaturaDAO
     */
    public AsignaturaDAO getAsignaturaDAO(){
        return new AsignaturaDAO();
    }
}
