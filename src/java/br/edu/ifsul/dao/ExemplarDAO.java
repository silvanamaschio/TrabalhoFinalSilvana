/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Exemplar;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Silvana Maschio
 */
@Stateless
public class ExemplarDAO implements Serializable {
    @PersistenceContext(unitName = "TATrabalhoSilvanaPU")
    private EntityManager em;
    private List<Exemplar> listarTodos;

    public ExemplarDAO() {
    }
    
    
 public void persist(Exemplar objeto) throws Exception {
        em.persist(objeto);
    }

    public void merge(Exemplar objeto) throws Exception {
        em.merge(objeto);
    }

    public void remove(Exemplar objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }

    public Exemplar getObjectById(Integer id) throws Exception {
        return em.find(Exemplar.class, id);
    }

    

    public List<Exemplar> getListarTodos() {
        return em.createQuery("from Exemplar order by titulo").getResultList();
    }

    public void setListarTodos(List<Exemplar> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
