
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="item_emprestimo")
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemEmprestimo implements Serializable{
    @Id 
    @Column(name="cod_item_emprestimo", nullable = false )
    @SequenceGenerator(name = "seq_item_emprestimo", sequenceName = "seq_item_emprestimo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_item_emprestimo", strategy = GenerationType.SEQUENCE)
    private Integer cod_item_emprestimo;
    @Column(name="cod_barra", nullable = true, length = 100)
    @NotEmpty(message= "O codigo de barras deve ser informado")
    @Length(max = 50, message = "O código de barros não deve ultrapassar (max) caracteres")
    private String cod_barras;
    
    
   

    public ItemEmprestimo() {
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.cod_item_emprestimo);
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
        final ItemEmprestimo other = (ItemEmprestimo) obj;
        if (!Objects.equals(this.cod_item_emprestimo, other.cod_item_emprestimo)) {
            return false;
        }
        return true;
    }

    public Integer getCod_item_emprestimo() {
        return cod_item_emprestimo;
    }

    public void setCod_item_emprestimo(Integer cod_item_emprestimo) {
        this.cod_item_emprestimo = cod_item_emprestimo;
    }

    public String getCod_barras() {
        return cod_barras;
    }

    public void setCod_barras(String cod_barras) {
        this.cod_barras = cod_barras;
    }

   

    
    }