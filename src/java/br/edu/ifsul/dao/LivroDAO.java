
package br.edu.ifsul.dao;

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
public class LivroDAO implements Serializable {
    
    @PersistenceContext(unitName = "TATrabalhoSilvanaPU")
    private EntityManager em;
    private List<Livro> listarTodos;

    public LivroDAO() {
    }
    
    public void persist(Livro objeto) throws Exception {
        em.persist(objeto);        
    }
    
    public void merge(Livro objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remove(Livro objeto) throws Exception{
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
   

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Livro> getListarTodos() {
        return em.createQuery("from Livro order by titulo").getResultList();
    }

    public void setListarTodos(List<Livro> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public Livro getObjectById(Integer cod_exemplar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
