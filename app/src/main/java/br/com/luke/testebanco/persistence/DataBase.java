package br.com.luke.testebanco.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.com.luke.testebanco.dao.AlunoDao;
import br.com.luke.testebanco.dao.TurmaDao;
import br.com.luke.testebanco.dao.UsuarioDao;
import br.com.luke.testebanco.entity.Aluno;
import br.com.luke.testebanco.entity.Turma;
import br.com.luke.testebanco.entity.Usuario;

@Database(entities = {Usuario.class, Turma.class, Aluno.class}, version = 3)
public abstract class DataBase extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
    public abstract TurmaDao turmaDao();
    public abstract AlunoDao alunoDao();
}
