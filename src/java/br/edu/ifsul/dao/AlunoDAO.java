
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Livro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Stateless
public class AlunoDAO implements Serializable {
    
    @PersistenceContext(unitName = "TATrabalhoSilvanaPU")
    private EntityManager em;
    private List<Aluno> listarTodos;

    public AlunoDAO() {
    }
    
    public void persist(Aluno objeto) throws Exception {
        em.persist(objeto);        
    }
    
    public void merge(Aluno objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remove(Aluno objeto) throws Exception{
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
   

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Aluno> getListarTodos() {
        return em.createQuery("from Aluno order by nome").getResultList();
    }

    public void setListarTodos(List<Aluno> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public Aluno getObjectById(Integer cod_cliente) {
        return em.find(Aluno.class, cod_cliente);
    }


}
