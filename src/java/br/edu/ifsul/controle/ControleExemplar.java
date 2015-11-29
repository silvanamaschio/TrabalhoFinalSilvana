/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.ExemplarDAO;
import br.edu.ifsul.modelo.Exemplar;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Silvana Maschio
 */



   
@SessionScoped
@ManagedBean(name="controleExemplar")

public class ControleExemplar implements Serializable{
    @EJB
    private ExemplarDAO dao;
    private Exemplar objeto;

    public ControleExemplar() {
    }
    
    public String listar(){
        return "/privado/exemplar/listar?faces-redirect=true";
        
    }

    public String novo(){
        
        objeto = new Exemplar();
        return "formulario?faces-redirect=true";
    }
    
    public String salvar(){
        
        try{
            
            if(objeto.getCod_exemplar()== null){
                
                dao.persist(objeto);
            }else{
                dao.merge(objeto);                
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
            return "listar?faces-redirect=true";
            
            }catch(Exception e){
                    Util.mensagemErro("Erro ao persistir objeto" + e.getMessage());
                    return "formulario?faces-redirect=true";
                            }
    }
    
       public String cancelar() {
        objeto = null;
        return "listar?faces-redirect=true";
    }        
  
    public String editar(Integer cod_exemplar){
        
        try{
            objeto = dao.getObjectById(cod_exemplar);
            return "formulario?faces-redirect=true";
        }catch(Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());
            return "listar?faces-redirect=true";
            
            
        }
    }
    
    
    
    public void excluir(Integer cod_exemplar){
        
        try{
            objeto = dao.getObjectById(cod_exemplar);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        }catch(Exception e){
            Util.mensagemErro("Erro ao remover objeto" + Util.getMensagemErro(e));
        }
        
        
    }
    
     public String voltarIndex() {
        return "/index?faces-redirect=true";
    }
   
    public Exemplar getObjeto() {
        return objeto;
    }

    public void setObjeto(Exemplar objeto) {
        this.objeto = objeto;
    }    

    public ExemplarDAO getDao() {
        return dao;
    }

    public void setDao(ExemplarDAO dao) {
        this.dao = dao;
    }

       

}