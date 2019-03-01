package br.com.luke.testebanco.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.luke.testebanco.dto.AlunoDTO;
import br.com.luke.testebanco.entity.Aluno;

@Dao
public interface AlunoDao {

    @Query("select * from tb_aluno")
    List<Aluno> getAll();

    @Query("select tb_aluno.id, tb_aluno.nm_aluno, tb_turma.ds_turma from tb_aluno inner join tb_turma on tb_turma.id = tb_aluno.id_turma")
    List<AlunoDTO> getAlunos();

    @Insert
    void insert(Aluno aluno);

    @Update
    void update(Aluno aluno);

    @Delete
    void delete(Aluno aluno);
}
