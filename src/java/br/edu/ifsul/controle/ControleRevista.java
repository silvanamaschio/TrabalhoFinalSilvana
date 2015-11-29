package br.edu.ifsul.controle;

import br.edu.ifsul.dao.RevistaDAO;
import br.edu.ifsul.modelo.Revista;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "controleRevista")
@ViewScoped
public class ControleRevista implements Serializable {

    @EJB
    private RevistaDAO dao;
    private Revista objeto;
   
    

    public ControleRevista() {
    }

    public String listar() {
        return "/privado/revista/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Revista();        
    }

    public void salvar() {
        try {
            if (objeto.getCod_exemplar()== null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");            
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + e.getMessage());            
        }
    }
    
    
    
     
      
    public void editar(Integer cod_livro) {
        try {
            objeto = dao.getObjectById(cod_livro);            
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());            
        }
    }
    
    public void excluir(Integer cod_livro){
        try {
            objeto = dao.getObjectById(cod_livro);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto:"+Util.getMensagemErro(e));
        }
    }

    public RevistaDAO getDao() {
        return dao;
    }

    public void setDao(RevistaDAO dao) {
        this.dao = dao;
    }

    public Revista getObjeto() {
        return objeto;
    }

    public void setObjeto(Revista objeto) {
        this.objeto = objeto;
    }

   
}
