package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.model.matricula.Matricula;
import com.model.matricula.MatriculaService;
import com.model.alumno.Alumno;
import com.model.alumno.AlumnoService;
import com.model.asignatura.Asignatura;
import com.model.asignatura.AsignaturaService;
import com.model.profesor.Profesor;
import com.model.profesor.ProfesorService;
import com.view.Errores;
import com.view.Menu;

public class AlumnoController {
    private AlumnoController() {
        // Empty
    }

    private static void crearAlumno(AlumnoService alumnoService, Menu menu) {
        Alumno newAlumno = menu.inputAlumnoFields();
        alumnoService.persist(newAlumno);
        menu.showAlumnos(alumnoService.findAll());
    }

    private static void borrarAlumno(AlumnoService alumnoService, Menu menu) {
        Alumno alumno = menu.selectAlumno(alumnoService.findAll());
        alumnoService.delete(alumno);
        menu.showAlumnos(alumnoService.findAll());
    }

    /**
     * Llama al método actualizar del DAO para sobreescribir un alumno en una
     * posición
     * 
     * @param Conexion
     * @param menu
     * @param alumnoDAO
     * @param alumnos
     */
    private static void actualizarAlumno(AlumnoService alumnoService, Menu menu) {
        Alumno selected = menu.selectAlumno(alumnoService.findAll());
        alumnoService.update(selected);
        menu.showAlumnos(alumnoService.findAll());
    }

    /**
     * Inserta una matricula
     * 
     * @param Conexion
     * @param matriculas
     * @param alumnos
     */
    private static void insertMatricula(MatriculaService matriculaService, Matricula[] matriculas) {
        for (Matricula matricula : matriculas) {
            matriculaService.persist(matricula);
        }
    }

    /**
     * Matricula un alumno en una o varias asignaturas, para esto requiere de la
     * materia, un alumno y un profesor; sino hay profesores, el sistema recomendará
     * crear uno
     * 
     * @param Conexion
     * @param menu
     * @param alumnos
     * @param asignaturas
     */
    private static void matricularAlumno(AlumnoService alumnoService, Menu menu) {
        Alumno alumno = menu.selectAlumno(alumnoService.findAll());
        List<Asignatura> asignaturas = new AsignaturaService().findAll();
        List<Profesor> profesors = new ProfesorService().findAll();
        if (!(asignaturas.isEmpty() || profesors.isEmpty())) {
            Matricula[] matriculas = new Matricula[menu.setNumMatriculas()];
            for (int i = 0; i < matriculas.length; i++) {
                Asignatura asignatura = menu.selectAsignatura(asignaturas);
                Profesor profesor = menu.selectProfesor(profesors);
                matriculas[i] = new Matricula(alumno.getIdAlumno(), asignatura.getCodAsignatura(),
                        profesor.getCodProf());
            }
            insertMatricula(new MatriculaService(), matriculas);
        } else {
            AsignaturaService asignaturaService = new AsignaturaService();
            if (Errores.noAsignaturas(menu.getTeclado())) {
                AsignaturaController.crearAsignatura(asignaturaService, menu);
                if (Errores.noProfes(menu.getTeclado()))
                    ProfesorController.crearProfesor(new ProfesorService(), menu);
                matricularAlumno(alumnoService, menu);
            }
        }
    }

    private static List<Asignatura> getAsignaturas(Alumno alumno){
        AsignaturaService asignaturaService = new AsignaturaService();
        MatriculaService matriculaService = new MatriculaService();
        List<Asignatura> asignaturasAlumno = new ArrayList<>();
        for (Matricula matricula : matriculaService.findAll()) {
            if (matricula.getIdAlumno() == alumno.getIdAlumno()) {
                asignaturasAlumno.add(asignaturaService.findById(matricula.getIdAsignatura()));
            }
        }
        return asignaturasAlumno;
    }

    /**
     * Menu para gestionar los alumnos de la bd
     * 
     * @param Conexion
     */
    public static void gestionarAlumnos() {
        Menu menu = new Menu();
        AlumnoService alumnoService = new AlumnoService();
        switch (menu.alumnoOPtions()) {
            case 1:
                crearAlumno(alumnoService, menu);
                break;
            case 2:
                borrarAlumno(alumnoService, menu);
                break;
            case 3:
                actualizarAlumno(alumnoService, menu);
                break;
            case 4:
                matricularAlumno(alumnoService, menu);
                break;
            case 5:
                Alumno alumno = menu.selectAlumno(alumnoService.findAll());
                menu.showAsignaturasAlumno(getAsignaturas(alumno));
                break;
            default:
                menu.showAlumnos(alumnoService.findAll());
                break;
        }
    }
}
