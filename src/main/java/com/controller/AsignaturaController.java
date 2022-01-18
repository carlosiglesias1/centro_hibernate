package com.controller;

import java.util.List;

import com.model.asignatura.Asignatura;
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
    static void borrarAsignatura(AsignaturaService asignaturaService, Menu menu) {
        asignaturaService.delete(menu.selectAsignatura(asignaturaService.findAll()));
    }

    /**
     * Sobreescribe una asignatura existente
     * 
     * @param Conexion
     * @param menu
     * @param asignaturaDAO
     */
    static void actualizarAsignatura(AsignaturaService asignaturaService, Menu menu) {
        List<Asignatura> asignaturas = asignaturaService.findAll();
        try {
            Asignatura materia = menu.selectAsignatura(asignaturas);
            asignaturaService.update(materia);
        } catch (IndexOutOfBoundsException ex) {
            Errores.showError(Errores.ErrorTypes.LOSTMATERIA.ordinal());
        }
    }

    /**
     * Menu para realizar operaciones sobre la tabla de asignaturas
     * 
     * @param Conexion
     */
    public static void gestionarAsignaturas() {
        Menu menu = new Menu();
        AsignaturaService asignaturaService = new AsignaturaService();
        switch (menu.asignaturaOtions()) {
            case 1:
                crearAsignatura(asignaturaService, menu);
                break;
            case 2:
                borrarAsignatura(asignaturaService, menu);
                break;
            case 3:
                actualizarAsignatura(asignaturaService, menu);
                break;
            default:
                List<Asignatura> asignaturas = asignaturaService.findAll();
                menu.showAsignaturas(asignaturas);
                break;
        }
    }
}
