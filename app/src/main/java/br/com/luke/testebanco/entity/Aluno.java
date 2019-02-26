package br.com.luke.testebanco.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tb_aluno", foreignKeys = @ForeignKey(entity = Turma.class, parentColumns = "id", childColumns = "id_turma"))
public class Aluno implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "nm_aluno")
    private String nome;

    @ColumnInfo(name = "id_turma")
    private Long idTurma;

    public Aluno() {
    }

    @Ignore
    public Aluno(String nome, Long idTurma) {
        this.nome = nome;
        this.idTurma = idTurma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }
}
