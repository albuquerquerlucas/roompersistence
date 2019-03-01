package br.com.luke.testebanco.services.buscar;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import br.com.luke.testebanco.delegate.BuscarTurmasDelegate;
import br.com.luke.testebanco.entity.Turma;
import br.com.luke.testebanco.persistence.DataBaseClient;

import static br.com.luke.testebanco.persistence.DataBaseClient.getInstance;

public class BuscarTurmasTask extends AsyncTask<String, Void, List<Turma>> {

    private Context context;
    private BuscarTurmasDelegate delegate;


    public BuscarTurmasTask(Context context, BuscarTurmasDelegate activity) {
        this.context = context;
        this.delegate = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Turma> doInBackground(String... params) {

        List<Turma> turmas = DataBaseClient.getInstance(context).getDataBase()
                .turmaDao()
                .getAll();

        return turmas;
    }

    @Override
    protected void onPostExecute(List<Turma> turmas) {
        super.onPostExecute(turmas);
        this.delegate.retornoTurmas(turmas);
    }
}
