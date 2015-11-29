/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.ClienteDAO;
import br.edu.ifsul.modelo.Cliente;
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
@ManagedBean(name="controleCliente")

public class ControleCliente implements Serializable{
    @EJB
    private ClienteDAO dao;
    private Cliente objeto;

    public ControleCliente() {
    }
    
    public String listar(){
        return "/privado/cliente/listar?faces-redirect=true";
        
    }

    public String novo(){
        
        objeto = new Cliente();
        return "formulario?faces-redirect=true";
    }
    
    public String salvar(){
        
        try{
            
            if(objeto.getCod_cliente()== null){
                
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
  
    public String editar(Integer cod_cliente){
        
        try{
            objeto = dao.getObjectById(cod_cliente);
            return "formulario?faces-redirect=true";
        }catch(Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());
            return "listar?faces-redirect=true";
            
            
        }
    }
    
    
    
    public void excluir(Integer cod_cliente){
        
        try{
            objeto = dao.getObjectById(cod_cliente);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        }catch(Exception e){
            Util.mensagemErro("Erro ao remover objeto" + Util.getMensagemErro(e));
        }
        
        
    }
    
     public String voltarIndex() {
        return "/index?faces-redirect=true";
    }
   
    public Cliente getObjeto() {
        return objeto;
    }

    public void setObjeto(Cliente objeto) {
        this.objeto = objeto;
    }    

    public ClienteDAO getDao() {
        return dao;
    }

    public void setDao(ClienteDAO dao) {
        this.dao = dao;
    }

       

}