package br.com.luke.testebanco.services.salvar;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.com.luke.testebanco.entity.Aluno;
import br.com.luke.testebanco.persistence.DataBaseClient;

public class SalvarAlunoTask extends AsyncTask<String, Void, Void> {

    private Context context;

    public SalvarAlunoTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {

        Aluno aluno = new Aluno();
        aluno.setNome(params[0]);
        aluno.setIdTurma(Long.parseLong(params[1]));

        DataBaseClient.getInstance(context).getDataBase()
                .alunoDao()
                .insert(aluno);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(context, "Aluno salvo com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
