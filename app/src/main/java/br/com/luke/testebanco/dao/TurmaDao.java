package br.com.luke.testebanco.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.luke.testebanco.dto.TurmaDTO;
import br.com.luke.testebanco.entity.Aluno;
import br.com.luke.testebanco.entity.Turma;

@Dao
public interface TurmaDao {

    @Query("select * from tb_turma")
    List<Turma> getAll();

    @Query("select tb_turma.id, tb_turma.ds_turma, tb_aluno.nm_aluno from tb_aluno inner join tb_turma on tb_turma.id = tb_aluno.id_turma")
    List<TurmaDTO> getAlunosForTurma();

    @Insert
    void insert(Turma turma);

    @Update
    void update(Turma turma);

    @Delete
    void delete(Turma turma);
}
