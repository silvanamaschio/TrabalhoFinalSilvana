package teste;


import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Exemplar;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TesteInserirExemplar {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirExemplar() {
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
            Exemplar e = new Exemplar();
            e.setTitulo("O Manual");
            e.setData_aquisicao(Calendar.getInstance());
            e.setEstoque(10);
            e.setFornecedor("Editora Ática");
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
