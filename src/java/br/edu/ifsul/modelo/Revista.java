package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "revista")
public class Revista extends Exemplar implements Serializable {

    @NotBlank(message = "A editora deve ser informada")
    @Column(name = "editora", length = 50, nullable = false)
    @Length(max = 50, message = "A editora não deve possuir mais de {max} digitos")
    private String editora;
    @Column(name = "lancamento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar lancamento;
    @Column(name = "valor", nullable = false)
    private Double valor;
    @Column(name = "nro_paginas", nullable = false)
    private Integer nro_paginas;
    @Column(name = "cidade", nullable = false, length = 50)
    @Length(max = 50, message = "A cidade não deve ultrapassar (max) caracteres")
    @NotEmpty(message = "A cidade deve ser informada")
    private String cidade;

    public Revista() {
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getLancamento() {
        return lancamento;
    }

    public void setLancamento(Calendar lancamento) {
        this.lancamento = lancamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getNro_paginas() {
        return nro_paginas;
    }

    public void setNro_paginas(Integer nro_paginas) {
        this.nro_paginas = nro_paginas;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

   
}
