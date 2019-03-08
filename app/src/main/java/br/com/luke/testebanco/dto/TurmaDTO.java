package br.com.luke.testebanco.dto;

import java.util.List;

import br.com.luke.testebanco.entity.Aluno;

public class TurmaDTO {

    private Long id;
    private String ds_turma;
    private String nm_aluno;

    public TurmaDTO(Long id, String ds_turma, String nm_aluno) {
        this.id = id;
        this.ds_turma = ds_turma;
        this.nm_aluno = nm_aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDs_turma() {
        return ds_turma;
    }

    public void setDs_turma(String ds_turma) {
        this.ds_turma = ds_turma;
    }

    public String getNm_aluno() {
        return nm_aluno;
    }

    public void setNm_aluno(String nm_aluno) {
        this.nm_aluno = nm_aluno;
    }
}
