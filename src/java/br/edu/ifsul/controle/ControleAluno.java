package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AlunoDAO;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "controleAluno")
@ViewScoped
public class ControleAluno implements Serializable {

    @EJB
    private AlunoDAO dao;
    private Aluno objeto;
   
    

    public ControleAluno() {
    }

    public String listar() {
        return "/privado/aluno/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Aluno(); 
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

    public AlunoDAO getDao() {
        return dao;
    }

    public void setDao(AlunoDAO dao) {
        this.dao = dao;
    }

    public Aluno getObjeto() {
        return objeto;
    }

    public void setObjeto(Aluno objeto) {
        this.objeto = objeto;
    }

   
}
