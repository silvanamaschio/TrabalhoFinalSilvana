
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Revista;
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
public class RevistaDAO implements Serializable {
    
    @PersistenceContext(unitName = "TATrabalhoSilvanaPU")
    private EntityManager em;
    private List<Revista> listarTodos;

    public RevistaDAO() {
    }
    
    public void persist(Revista objeto) throws Exception {
        em.persist(objeto);        
    }
    
    public void merge(Revista objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remove(Revista objeto) throws Exception{
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
   

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Revista> getListarTodos() {
        return em.createQuery("from Revista order by titulo").getResultList();
    }

    public void setListarTodos(List<Revista> listarTodos) {
        this.listarTodos = listarTodos;
    }

   public Revista getObjectById(Integer cod_exemplar) {
        return em.find(Revista.class, cod_exemplar);
    }

}
