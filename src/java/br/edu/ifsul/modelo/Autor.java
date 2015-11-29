
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "autor")
public class Autor implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
    private Integer cod_autor;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message="O nome não deve possuir mais de {max} caracteres")
    @Column(name = "nome",length = 50,nullable = false)        
    private String nome;
    @NotNull(message = "O exemplar deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cod_exemplar", referencedColumnName = "cod_exemplar", nullable = false)
    private Exemplar exemplar;

    public Autor() {
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cod_autor);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.cod_autor, other.cod_autor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public Integer getId() {
        return cod_autor;
    }

    public void setId(Integer id) {
        this.cod_autor = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
    
}
