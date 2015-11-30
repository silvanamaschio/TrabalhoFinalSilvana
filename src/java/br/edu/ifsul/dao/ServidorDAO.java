
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Servidor;
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
public class ServidorDAO implements Serializable {
    
    @PersistenceContext(unitName = "TATrabalhoSilvanaPU")
    private EntityManager em;
    private List<Servidor> listarTodos;

    public ServidorDAO() {
    }
    
    public void persist(Servidor objeto) throws Exception {
        em.persist(objeto);        
    }
    
    public void merge(Servidor objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remove(Servidor objeto) throws Exception{
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
   

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Servidor> getListarTodos() {
        return em.createQuery("from Servidor order by nome").getResultList();
    }

    public void setListarTodos(List<Servidor> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public Servidor getObjectById(Integer cod_servidor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
