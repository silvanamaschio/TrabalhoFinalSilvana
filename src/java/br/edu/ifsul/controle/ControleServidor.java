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

    public void novo() {
        objeto = new Servidor(); 
    }

    public void salvar() {
        try {
            if (objeto.getCod_cliente()== null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");            
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + e.getMessage());            
        }
    }
    
    

    public void editar(Integer cod_cliente) {
        try {
            objeto = dao.getObjectById(cod_cliente);            
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());            
        }
    }
    
    public void excluir(Integer cod_cliente){
        try {
            objeto = dao.getObjectById(cod_cliente);
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
