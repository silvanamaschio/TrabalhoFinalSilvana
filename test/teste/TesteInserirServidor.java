package teste;


import br.edu.ifsul.modelo.Servidor;
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
public class TesteInserirServidor {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirServidor() {
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
            Servidor s = new Servidor();
            s.setBairro("Copacabana");
            s.setCidade("Rio de Janeiro");
            s.setNascimento(Calendar.getInstance());
            s.setNome("Garota de Ipanema");
            s.setData_admissao(Calendar.getInstance());
            s.setDepartamento("Depex");
            s.setSetor("Informática");
            s.setSiape("1865855");
            s.setData_admissao(Calendar.getInstance());
            s.setEfetivo(true);
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
