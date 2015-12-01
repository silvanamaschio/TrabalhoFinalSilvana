
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Emprestimo;
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
public class EmprestimoDAO implements Serializable {
    
    @PersistenceContext(unitName = "TATrabalhoSilvanaPU")
    private EntityManager em;
    private List<Emprestimo> listarTodos;

    public EmprestimoDAO() {
    }
    
    public void persist(Emprestimo objeto) throws Exception {
        em.persist(objeto);        
    }
    
    public void merge(Emprestimo objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remove(Emprestimo objeto) throws Exception{
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Emprestimo getObjectById(Integer cod_emprestimo) throws Exception {
        return em.find(Emprestimo.class, cod_emprestimo);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Emprestimo> getListarTodos() {
        return em.createQuery("from Emprestimo order by data").getResultList();
    }

    public void setListarTodos(List<Emprestimo> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
