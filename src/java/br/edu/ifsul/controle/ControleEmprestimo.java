package br.edu.ifsul.controle;

import br.edu.ifsul.dao.EmprestimoDAO;
import br.edu.ifsul.dao.AlunoDAO;
import br.edu.ifsul.dao.ServidorDAO;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Emprestimo;
import br.edu.ifsul.modelo.Servidor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@ManagedBean(name = "controleEmprestimo")
@SessionScoped
public class ControleEmprestimo implements Serializable {

    @EJB
    private EmprestimoDAO dao;
    private Emprestimo objeto;
    @EJB
    private Aluno daoAluno;
    private Servidor daoServidor;
   

    public ControleEmprestimo() {
    }

    public String listar() {
        return "/privado/emprestimo/listar?faces-redirect=true";
    }

    public String novo() {
        objeto = new Emprestimo();
        return "formulario?faces-redirect=true";
    }

    public void salvar() {
        try {
            if (objeto.getCod_emprestimo()== null) {
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

    public void editar(Integer cod_emprestimo) {
        try {
            objeto = dao.getObjectById(cod_emprestimo);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());
        }
    }
    
    public void excluir(Integer cod_emprestimo){
        try {
            objeto = dao.getObjectById(cod_emprestimo);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto:"+Util.getMensagemErro(e));
        }
    }

    public EmprestimoDAO getDao() {
        return dao;
    }

    public void setDao(EmprestimoDAO dao) {
        this.dao = dao;
    }

    public Emprestimo getObjeto() {
        return objeto;
    }

    public void setObjeto(Emprestimo objeto) {
        this.objeto = objeto;
    }

    public Aluno getDaoAluno() {
        return daoAluno;
    }

    public void setDaoAluno(Aluno daoAluno) {
        this.daoAluno = daoAluno;
    }

    public Servidor getDaoServidor() {
        return daoServidor;
    }

    public void setDaoServidor(Servidor daoServidor) {
        this.daoServidor = daoServidor;
    }

    
}
