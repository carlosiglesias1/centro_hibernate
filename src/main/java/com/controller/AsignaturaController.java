package com.controller;

import java.sql.Connection;
import java.util.List;

import com.model.asignatura.Asignatura;
import com.model.asignatura.AsignaturaDAO;
import com.model.asignatura.AsignaturaService;
import com.view.Errores;
import com.view.Menu;

public class AsignaturaController {
    private AsignaturaController() {
        // Empty
    }

    /**
     * Crea una nueva asignatura
     * 
     * @param AsignaturaService
     * @param menu
     */
    static void crearAsignatura(AsignaturaService asignaturaService, Menu menu) {
        Asignatura asignatura = menu.inputAsignatura();
        asignaturaService.persist(asignatura);
    }

    /**
     * Borra una asignatura existente
     * 
     * @param conn
     * @param menu
     * @param asignaturaDAO
     */
    static void borrarAsignatura(Connection conn, Menu menu, AsignaturaDAO asignaturaDAO) {
        List<Asignatura> asignaturas = asignaturaDAO.getAll(conn);
        try {
            Asignatura materia = asignaturas.get(menu.selectAsignatura(asignaturas) - 1);
            if (asignaturaDAO.delete(conn, materia) != -1) {
                asignaturas = asignaturaDAO.getAll(conn);
                menu.showAsignaturas(asignaturas);
            }
        } catch (IndexOutOfBoundsException ex) {
            Errores.showError(Errores.ErrorTypes.LOSTMATERIA.ordinal());
        }
    }

    /**
     * Sobreescribe una asignatura existente
     * 
     * @param Conexion
     * @param menu
     * @param asignaturaDAO
     */
    static void actualizarAsignatura(Connection conn, Menu menu, AsignaturaDAO asignaturaDAO) {
        List<Asignatura> asignaturas = asignaturaDAO.getAll(conn);
        try {
            Asignatura materia = asignaturas.get(menu.selectAsignatura(asignaturas) - 1);
            if (asignaturaDAO.update(conn, materia) != -1) {
                asignaturas = asignaturaDAO.getAll(conn);
                menu.showAsignaturas(asignaturas);
            }
        } catch (IndexOutOfBoundsException ex) {
            Errores.showError(Errores.ErrorTypes.LOSTMATERIA.ordinal());
        }
    }

    /**
     * Menu para realizar operaciones sobre la tabla de asignaturas
     * 
     * @param Conexion
     */
    public static void gestionarAsignaturas(Connection conn) {
        Menu menu = new Menu();
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
        switch (menu.asignaturaOtions()) {
            case 1:
                crearAsignatura(conn, menu, asignaturaDAO);
                break;
            case 2:
                borrarAsignatura(conn, menu, asignaturaDAO);
                break;
            case 3:
                actualizarAsignatura(conn, menu, asignaturaDAO);
                break;
            default:
                List<Asignatura> asignaturas = asignaturaDAO.getAll(conn);
                menu.showAsignaturas(asignaturas);
                break;
        }
    }
}
