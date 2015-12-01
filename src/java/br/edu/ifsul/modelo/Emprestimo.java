
package br.edu.ifsul.modelo;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="emprestimo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Emprestimo implements Serializable{
    @Id 
    @Column(name="cod_emprestimo", nullable = false )
    @SequenceGenerator(name = "seq_emprestimo", sequenceName = "seq_emprestimo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_emprestimo", strategy = GenerationType.SEQUENCE)
    private Integer cod_emprestimo;
    @Column(name="data", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar data;
    @Column(name = "nro_dias",  nullable = false)
    private Integer nro_dias;
    @NotEmpty(message= "O atendente deve ser informado")
    @Length(max = 50, message = "O atendente não deve ultrapassar (max) caracteres")
    @Column(name="atendente", nullable = false, length = 50)
    private String atendente;
    @Column(name="observacao", nullable = true, length = 100)
    @Length(max = 100, message = "A observacao não deve ultrapassar (max) caracteres")
    private String observacao;
    @NotNull(message = "O Cliente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "cod_cliente", nullable = false)
    private Cliente cliente;
    
    
   

    public Emprestimo() {
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.cod_emprestimo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.cod_emprestimo, other.cod_emprestimo)) {
            return false;
        }
        return true;
    }

    public Integer getCod_emprestimo() {
        return cod_emprestimo;
    }

    public void setCod_emprestimo(Integer cod_emprestimo) {
        this.cod_emprestimo = cod_emprestimo;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Integer getNro_dias() {
        return nro_dias;
    }

    public void setNro_dias(Integer nro_dias) {
        this.nro_dias = nro_dias;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   

    
    }