package br.com.luke.testebanco.persistence;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

public class DataBaseClient {

    private Context context;
    private static DataBaseClient mInstance;

    private DataBase dataBase;

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Fazer as alterações aqui...
            database.execSQL("ALTER TABLE tb_usuario "
                    + " ADD COLUMN teste text default ''");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Fazer as alterações aqui...
            database.execSQL("alter table tb_usuario rename to tb_usuario_temp;");
            database.execSQL("create table tb_usuario(" +
                    "id integer primary key autoincrement," +
                    "nm_nome text," +
                    "cp_login text," +
                    "k_senha text," +
                    "fl_tipo integer);");
            database.execSQL("insert into tb_usuario select id, nm_nome, cp_login, k_senha, fl_tipo from tb_usuario_temp;");
            database.execSQL("drop table tb_usuario_temp;");
        }
    };

    private DataBaseClient(Context ctx){
        this.context = ctx;
        dataBase = Room.databaseBuilder(this.context, DataBase.class, "app-store.db")
                //.addMigrations(MIGRATION_1_2, MIGRATION_2_3) // Update...
                .fallbackToDestructiveMigration() // Drop and re-create...
                .build();
    }

    public static synchronized DataBaseClient getInstance(Context context){
        if(mInstance == null){
            mInstance = new DataBaseClient(context);
        }
        return mInstance;
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
