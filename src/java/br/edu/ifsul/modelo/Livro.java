package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "livro")
public class Livro extends Exemplar implements Serializable {

    @NotBlank(message = "O ano deve ser informado")
    @Length(max = 4, message = "O ano não deve possuir mais de {max} digitos")
    @Column(name = "ano", length = 4, nullable = false)
    private String ano;
    @NotBlank(message = "A cidade deve ser informada")
    @Column(name="cidade", nullable = false, length = 50, unique =true)
    private String cidade;
    @Column(name = "valor", nullable = false)
    private Double valor;
    @NotBlank(message = "A editora deve ser informada")
    @Column(name = "editora", length = 50, nullable = false, unique = true)
    private String editora;
    @Column(name = "nro_paginas",  nullable = false)
    private Integer nro_paginas;
    
    

    public Livro() {
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getNro_paginas() {
        return nro_paginas;
    }

    public void setNro_paginas(Integer nro_paginas) {
        this.nro_paginas = nro_paginas;
    }

  
    
}
