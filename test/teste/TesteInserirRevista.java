package teste;


import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Livro;
import br.edu.ifsul.modelo.Revista;
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
public class TesteInserirRevista {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirRevista() {
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
            Revista r = new Revista();
            r.setTitulo("A Máfia");
            r.setCidade("Rio Pardo");
            r.setData_aquisicao(Calendar.getInstance());
            r.setEditora("Poá");
            r.setEstoque(12);
            r.setFornecedor("Saraiva");
            r.setValor(40.00);
            r.setNro_paginas(120);
            r.setLancamento(Calendar.getInstance());
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
