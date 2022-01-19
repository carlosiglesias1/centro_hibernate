package com.controller;

import com.model.departamento.Departamento;
import com.model.departamento.DepartamentoService;
import com.view.Menu;

public class DeptController {
    private DeptController(){
        //Empty
    }
    /**
     * @param conn
     */
    public static void gestionarDepartamentos() {
        Menu menu = new Menu();
        DepartamentoService departamentoService = new DepartamentoService();
        switch (menu.departamentoOptions()) {
        case 1:
            Departamento dept = menu.inputDepartamento();
            departamentoService.persist(dept);
            break;
        case 2:
            Departamento departamento = menu.selectDept(departamentoService.findAll());
            departamentoService.delete(departamento);
            break;
        case 3:
            Departamento selectedDept = menu.selectDept(departamentoService.findAll());
            menu.showProfes(selectedDept.getProfesores());
            break;
        default:
            menu.showDepts(departamentoService.findAll());
            break;
        }
    }
}
