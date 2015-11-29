package teste;


import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Cliente;
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
public class TesteInserirAluno {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteInserirAluno() {
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
            Aluno a = new Aluno();
            a.setBairro("Copacabana");
            a.setCidade("Rio de Janeiro");
            a.setNascimento(Calendar.getInstance());
            a.setNome("Garota de Ipanema");
            a.setCurso("TSPI");
            a.setData_matricula(Calendar.getInstance());
            a.setMatricula("201113260238");
            a.setTurma("2N1");
            a.setNivel(5);
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e){
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }
    
}
