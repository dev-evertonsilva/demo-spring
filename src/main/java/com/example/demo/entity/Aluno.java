package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="tb_aluno")
public class Aluno {

    @Id
    @Column(name="cd_aluno")
    @SequenceGenerator(name="aluno", sequenceName="sq_tb_aluno", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="aluno")
    private Long cdAluno;

    @Column(name="nm_aluno", nullable = false)
    private String nome;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name="dt_cadastro_aluno")
    private Calendar dataCadastroAluno;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name="dt_modificacao")
    private Calendar dataModificacao;

    public Aluno(){ super(); }

    public Aluno(Long cdAluno, String nome, Calendar dataCadastroAluno) {
        this.cdAluno = cdAluno;
        this.nome = nome;
        this.dataCadastroAluno = dataCadastroAluno;

    }

    public Long getCdAluno() {
        return cdAluno;
    }

    public void setCdAluno(Long cdAluno) {
        this.cdAluno = cdAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataCadastroAluno() {
        return dataCadastroAluno;
    }

    public void setDataCadastroAluno(Calendar dataCadastroAluno) {
        this.dataCadastroAluno = dataCadastroAluno;
    }

    public Calendar getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Calendar dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}
