package com.controller;

import com.model.profesor.Profesor;
import com.model.profesor.ProfesorService;
import com.view.Menu;

public class ProfesorController {
    private ProfesorController() {
        // Empty
    }

    /**
     * Crea un profesor
     * 
     * @param conn
     * @param menu
     * @param profesorDAO
     */
    public static void crearProfesor(ProfesorService profesorService, Menu menu) {
        Profesor profesor = menu.profesorFields();
        profesorService.persist(profesor);
        menu.showProfes(profesorService.findAll());
    }

    /**
     * Borra un profesor de la base de datos
     * 
     * @param conn
     * @param menu
     * @param profesorDAO
     */
    public static void borrarProfesor(ProfesorService profesorService, Menu menu) {
        Profesor profesor = menu.selectProfesor(profesorService.findAll());
        profesorService.delete(profesor);
        menu.showProfes(profesorService.findAll());
    }

    /**
     * Edita el profesor seleccionado
     * 
     * @param conexion
     * @param menu
     * @param profesorDAO
     * @param departamentoDAO
     */
    public static void editarPorfesor(ProfesorService profesorService, Menu menu) {
        Profesor profesor = menu.selectProfesor(profesorService.findAll());
        Profesor newProfesor = menu.profesorFields();
        profesor.setCodProf(profesor.getCodProf());
        profesorService.update(newProfesor);
    }

    /**
     * Imprime las asignaturas de cada profesor
     * 
     * @param conn
     * @param menu
     * @param profesorDAO
     */
    /*
     * public static void verAsignaturasProfesor(Connection conn, Menu menu,
     * ProfesorDAO profesorDAO) {
     * menu.showAsignaturas(profesorDAO.getSubjects(conn,
     * profesorDAO.getAll(conn).get(menu.selectProfesor(profesorDAO.getAll(conn)) -
     * 1)));
     * }
     */

    /**
     * Gestiona todas las interacciones con la tabla de profesores
     */
    public static void gestionarProfesores() {
        Menu menu = new Menu();
        ProfesorService profesorService = new ProfesorService();
        switch (menu.profesorOptions()) {
            case 1:
                crearProfesor(profesorService, menu);
                break;
            case 2:
                borrarProfesor(profesorService, menu);
                break;
            case 3:
                editarPorfesor(profesorService, menu);
                break;
            case 4:
                // verAsignaturasProfesor(conn, menu);
                // break;
            default:
                menu.showProfes(profesorService.findAll());
                break;
        }
    }
}
