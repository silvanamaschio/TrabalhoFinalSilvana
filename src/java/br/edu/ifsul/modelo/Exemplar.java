
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
@Table(name="exemplar")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Exemplar implements Serializable{
    @Id 
    @Column(name="cod_exemplar", nullable = false )
    @SequenceGenerator(name = "seq_exemplar", sequenceName = "seq_exemplar_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_exemplar", strategy = GenerationType.SEQUENCE)
    private Integer cod_exemplar;
    @NotEmpty(message= "O titulo deve ser informado")
    @Length(max = 50, message = "O titulo não deve ultrapassar (max) caracteres")
    @Column(name="titulo", nullable = false, length = 50)
    private String titulo;
    @Column(name="DataAquisicao", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar data_aquisicao;
    @Column(name="fornecedor", nullable = false, length = 50)
    @Length(max = 50, message = "O fornecedor não deve ultrapassar (max) caracteres")
    @NotEmpty(message= "O fornecedor deve ser informado")
    private String fornecedor;
    @Column(name="estoque", nullable = false)
    private Integer estoque;
    
   

    public Exemplar() {
    }

   
    @Override
    public String toString() {
        return titulo;
    }

    public Integer getCod_exemplar() {
        return cod_exemplar;
    }

    public void setCod_exemplar(Integer cod_exemplar) {
        this.cod_exemplar = cod_exemplar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Calendar data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

     @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.cod_exemplar);
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
        final Exemplar other = (Exemplar) obj;
        if (!Objects.equals(this.cod_exemplar, other.cod_exemplar)) {
            return false;
        }
        return true;
    }


}
