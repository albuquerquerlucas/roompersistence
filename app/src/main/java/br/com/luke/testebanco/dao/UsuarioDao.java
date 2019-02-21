package br.com.luke.testebanco.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.luke.testebanco.entity.Usuario;

@Dao
public interface UsuarioDao {

    @Query("select * from tb_usuario")
    List<Usuario> getAll();

    @Insert
    void insert(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Delete
    void delete(Usuario usuario);
}
