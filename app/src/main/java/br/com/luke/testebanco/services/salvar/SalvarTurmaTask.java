package br.com.luke.testebanco.services.salvar;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.com.luke.testebanco.entity.Turma;
import br.com.luke.testebanco.persistence.DataBaseClient;

public class SalvarTurmaTask extends AsyncTask<String, Void, Void> {

    private Context context;

    public SalvarTurmaTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {

        Turma turma = new Turma();
        turma.setTurma(params[0]);

        DataBaseClient.getInstance(context).getDataBase()
                .turmaDao()
                .insert(turma);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(context, "Turma salva com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
