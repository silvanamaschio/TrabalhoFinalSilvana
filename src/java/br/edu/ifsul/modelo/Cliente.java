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
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Cliente implements Serializable {

    @Id
    @Column(name = "cod_cliente", nullable = false)
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cliente", strategy = GenerationType.SEQUENCE)
    private Integer cod_cliente;
    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ultrapassar (max) caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(name = "nascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar nascimento;
    @Column(name = "cidade", nullable = false, length = 50)
    @Length(max = 50, message = "A cidade não deve ultrapassar (max) caracteres")
    @NotEmpty(message = "A cidade deve ser informada")
    private String cidade;
    @Column(name = "bairro", nullable = false, length = 50)
    @Length(max = 50, message = "O bairro não deve ultrapassar (max) caracteres")
    @NotEmpty(message = "O bairro deve ser informado")
    private String bairro;

    public Cliente() {
    }

    

    @Override
    public String toString() {
        return nome;
    }

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.cod_cliente);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cod_cliente, other.cod_cliente)) {
            return false;
        }
        return true;
    }

    
}
