/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cliente;
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
public class ClienteDAO implements Serializable {
    @PersistenceContext(unitName = "TATrabalhoSilvanaPU")
    private EntityManager em;
    private List<Cliente> listarTodos;

    public ClienteDAO() {
    }
    
    
 public void persist(Cliente objeto) throws Exception {
        em.persist(objeto);
    }

    public void merge(Cliente objeto) throws Exception {
        em.merge(objeto);
    }

    public void remove(Cliente objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }

    public Cliente getObjectById(Integer id) throws Exception {
        return em.find(Cliente.class, id);
    }

    

    public List<Cliente> getListarTodos() {
        return em.createQuery("from Cliente order by nome").getResultList();
    }

    public void setListarTodos(List<Cliente> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
