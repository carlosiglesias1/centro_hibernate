package com.model.departamento;

import java.util.List;

import com.model.SesionFactory;

public class DepartamentoService {
    private SesionFactory sesionFactory;
    private DepartamentoDAO departamentoDAO;

    public DepartamentoService(){
        this.sesionFactory = SesionFactory.getSesionFactory();
        this.departamentoDAO = new DepartamentoDAO();
    }

    public void persist(Departamento departamento){
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.departamentoDAO.persist(departamento, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }

    public void update (Departamento departamento){
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.departamentoDAO.update(departamento, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }

    public void delete (Departamento departamento){
        this.sesionFactory.closeCurrentSessionwithTransaction();
        this.departamentoDAO.delete(departamento, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }

    public void deleteAll(){
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.departamentoDAO.deleteAll(this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }

    public Departamento findById(int id){
        this.sesionFactory.openCurrentSession();
        Departamento departamento = this.departamentoDAO.findById(id, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSession();
        return departamento;
    }
    public List<Departamento> findAll(){
        this.sesionFactory.openCurrentSession();
        List<Departamento> departamentos = this.departamentoDAO.findAll(this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSession();
        return departamentos;
    }
}
