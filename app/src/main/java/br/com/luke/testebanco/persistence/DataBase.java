package br.com.luke.testebanco.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.com.luke.testebanco.dao.UsuarioDao;
import br.com.luke.testebanco.entity.Usuario;

@Database(entities = {Usuario.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
}
