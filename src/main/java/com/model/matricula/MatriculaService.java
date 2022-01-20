package com.model.matricula;

import java.util.List;

import com.model.SesionFactory;

public class MatriculaService {
    private SesionFactory sesionFactory;
    private MatriculaDAO matriculaDAO;

    public MatriculaService() {
        this.sesionFactory = SesionFactory.getSesionFactory();
        this.matriculaDAO = new MatriculaDAO();
    }

    
    /** 
     * @param matricula
     */
    public void persist(Matricula matricula) {
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.matriculaDAO.persist(matricula, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }

    
    /** 
     * @param matricula
     */
    public void update(Matricula matricula) {
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.matriculaDAO.update(matricula, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }

    
    /** 
     * @param matricula
     */
    public void delete(Matricula matricula){
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.matriculaDAO.delete(matricula, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSession();
    }

    public void deleteAll (){
        this.sesionFactory.openCurrentSessionwithTransaction();
        this.matriculaDAO.deleteAll(this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSessionwithTransaction();
    }
    
    /** 
     * @param id
     * @return Matricula
     */
    public Matricula findById(int id){
        this.sesionFactory.openCurrentSession();
        Matricula found = this.matriculaDAO.findById(id, this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSession();
        return found;
    }

    
    /** 
     * @return List<Matricula>
     */
    public List<Matricula> findAll(){
        this.sesionFactory.openCurrentSession();
        List<Matricula> matriculas = this.matriculaDAO.findAll(this.sesionFactory.getCurrentSession());
        this.sesionFactory.closeCurrentSession();
        return matriculas;
    }
}
