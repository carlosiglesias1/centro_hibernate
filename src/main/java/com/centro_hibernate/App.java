package com.centro_hibernate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.controller.AlumnoController;
import com.model.tables.Tables;
import com.res.Conectar;
import com.view.Errores;
import com.view.Menu;

import com.controller.DeptController;
import com.controller.ProfesorController;

import com.controller.AsignaturaController;

public class App {
    static final String URL = "jdbc:mysql://localhost:3306/proyecto";
    static final String USER = "root";
    static final String PASSWORD = "";
    static Menu menu = new Menu();

    /**
     * Permite seleccionar la tabla sobre la que se realizarán las operaciones
     * 
     * @param Conexion a BD
     */
    private static void selectTable(Connection cnxn) {
        try (Statement st = cnxn.createStatement()) {
            String sql = "SHOW TABLES;";
            ResultSet rs = st.executeQuery(sql);
            switch (menu.selectTable(rs)) {
                case 1:
                    AlumnoController.gestionarAlumnos();
                    break;
                case 2:
                    AsignaturaController.gestionarAsignaturas();
                    break;
                case 3:
                    DeptController.gestionarDepartamentos();
                    break;
                case 4:
                    ProfesorController.gestionarProfesores();
                    break;
                default:
                    System.out.println("Fuck");
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
    }

    /**
     * Crea las tablas
     */
    private static void createTables(Connection cnxn) {
        try {
            int[] crearTablas = Tables.createTables(cnxn);
            for (int i = 0; i < crearTablas.length; i++) {
                if (crearTablas[i] == Statement.EXECUTE_FAILED) {
                    System.out.println("Algo no ha ido como debería: " + i);
                    break;
                }
            }
        } catch (SQLException ex) {
            Errores.sqlError(ex);
        }
    }

    /**
     * Borra las tablas
     * 
     * @param Conexion
     */
    private static void deleteTables(Connection conn) {
        try {
            int[] dropTables = Tables.dropTables(conn);
            for (int i = 0; i < dropTables.length; i++) {
                if (dropTables[i] == Statement.EXECUTE_FAILED) {
                    System.out.println("Algo no salió como debería: " + i);
                    break;
                }
            }
        } catch (SQLException e) {
            Errores.sqlError(e);
        }
    }

    /**
     * Control principal de la aplicacion
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            Conectar connection = Conectar.create(URL, USER, PASSWORD);
            Connection cnxn = connection.getConnection();
            System.out.println("Estoy conectado");
            int option = 0;
            do {
                option = menu.selectMenu();
                switch (option) {
                    case 0:
                        menu.goodBye();
                        break;
                    case 1:
                        createTables(cnxn);
                        break;
                    case 2:
                        selectTable(cnxn);
                        break;
                    case 3:
                        deleteTables(cnxn);
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            } while (option != 0);
        } catch (SQLException e) {
            Errores.sqlError(e);
        }
    }
}
