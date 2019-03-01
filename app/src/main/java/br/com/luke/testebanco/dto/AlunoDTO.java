package br.com.luke.testebanco.dto;

import java.io.Serializable;

public class AlunoDTO implements Serializable {

    private Long id;
    private String nm_aluno;
    private String ds_turma;

    public AlunoDTO(Long id, String nm_aluno, String ds_turma) {
        this.id = id;
        this.nm_aluno = nm_aluno;
        this.ds_turma = ds_turma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNm_aluno() {
        return nm_aluno;
    }

    public void setNm_aluno(String nm_aluno) {
        this.nm_aluno = nm_aluno;
    }

    public String getDs_turma() {
        return ds_turma;
    }

    public void setDs_turma(String ds_turma) {
        this.ds_turma = ds_turma;
    }
}
