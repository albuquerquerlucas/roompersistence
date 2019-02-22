package br.com.luke.testebanco.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.luke.testebanco.entity.Turma;

@Dao
public interface TurmaDao {

    @Query("select * from tb_turma")
    List<Turma> getAll();

    @Insert
    void insert(Turma turma);

    @Update
    void update(Turma turma);

    @Delete
    void delete(Turma turma);
}
