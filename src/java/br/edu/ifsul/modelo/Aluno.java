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
@Table(name = "aluno")
public class Aluno extends Cliente implements Serializable {

    @NotBlank(message = "A matrícula deve ser informada")
    @Length(max = 15, message = "A matrícula não deve possuir mais de {max} digitos")
    @Column(name = "matricula", length = 15, nullable = false)
    private String matricula;
    @NotBlank(message = "O curso deve ser informado")
    @Column(name = "curso", length = 50, nullable = false)
    private String curso;
    @NotBlank(message = "A turma deve ser informada")
    @Column(name = "turma", length = 50, nullable = false)
    private String turma;
    @NotNull(message = "A data de matrícula deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_matricula", nullable = false)
    private Calendar data_matricula;
    @Column(name = "nivel",  nullable = false)
    private Integer nivel;
    
    

    public Aluno() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Calendar getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(Calendar data_matricula) {
        this.data_matricula = data_matricula;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    
}
