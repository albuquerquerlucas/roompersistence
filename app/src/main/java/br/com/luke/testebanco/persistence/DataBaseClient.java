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
                    + " ADD COLUMN fl_tipo INTEGER");
        }
    };

    private DataBaseClient(Context ctx){
        this.context = ctx;
        dataBase = Room.databaseBuilder(this.context, DataBase.class, "app-store.db")
                //.addMigrations(MIGRATION_1_2) // Update...
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
