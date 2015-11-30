package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ServidorDAO;
import br.edu.ifsul.modelo.Servidor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "controleServidor")
@ViewScoped
public class ControleServidor implements Serializable {

    @EJB
    private ServidorDAO dao;
    private Servidor objeto;
   
    

    public ControleServidor() {
    }

    public String listar() {
        return "/privado/servidor/listar?faces-redirect=true";
    }

    public String novo() {
        objeto = new Servidor();  
        return "formulario?faces-redirect=true";
    }

    public void salvar() {
        try {
            if (objeto.getSiape()== null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");            
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + e.getMessage());            
        }
    }
    
    public String cancelar() {
        objeto = null;
        return "listar?faces-redirect=true";
    }      
    
    
    
     
      
    public void editar(Integer cod_servidor) {
        try {
            objeto = dao.getObjectById(cod_servidor);            
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());            
        }
    }
    
    public void excluir(Integer cod_servidor){
        try {
            objeto = dao.getObjectById(cod_servidor);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto:"+Util.getMensagemErro(e));
        }
    }

    public ServidorDAO getDao() {
        return dao;
    }

    public void setDao(ServidorDAO dao) {
        this.dao = dao;
    }

    public Servidor getObjeto() {
        return objeto;
    }

    public void setObjeto(Servidor objeto) {
        this.objeto = objeto;
    }

   
}
