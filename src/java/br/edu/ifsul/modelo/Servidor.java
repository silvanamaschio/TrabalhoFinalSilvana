package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "servidor")
public class Servidor extends Cliente implements Serializable {

    @NotBlank(message = "O siape deve ser informado")
    @Length(max = 15, message = "O Siape não deve possuir mais de {max} digitos")
    @Column(name = "siape", length = 15, nullable = false)
    private String siape;
    @NotBlank(message = "O departamento deve ser informado")
    @Column(name = "departamento", length = 50, nullable = false)
    private String departamento;
    @NotBlank(message = "O setor deve ser informado")
    @Column(name = "setor", length = 50, nullable = false)
    private String setor;
    @NotNull(message = "A data de admissão deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_admissao", nullable = false)
    private Calendar data_admissao;
    @Column(name = "efetivo")
    private Boolean efetivo;
    
    

    public Servidor() {
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Calendar getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Calendar data_admissao) {
        this.data_admissao = data_admissao;
    }

    public Boolean getEfetivo() {
        return efetivo;
    }

    public void setEfetivo(Boolean efetivo) {
        this.efetivo = efetivo;
    }

  
}
