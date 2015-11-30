package teste;


import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Livro;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TesteInserirLivro {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirLivro() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TATrabalhoSilvanaPULocal");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste(){
        boolean excecao = false;
        try {
            Livro l = new Livro();
            l.setTitulo("A Berlinda");
            l.setAno("1980");
            l.setCidade("Rio de Janeiro");
            l.setData_aquisicao(Calendar.getInstance());
            l.setEditora("Miraú");
            l.setEstoque(12);
            l.setFornecedor("Saraiva");
            l.setValor(40.00);
            l.setNro_paginas(120);
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
