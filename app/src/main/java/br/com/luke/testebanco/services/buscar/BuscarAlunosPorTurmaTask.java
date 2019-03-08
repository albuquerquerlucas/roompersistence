package br.com.luke.testebanco.services.buscar;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import br.com.luke.testebanco.delegate.BuscarAlunosPorTurmaDelegate;
import br.com.luke.testebanco.dto.TurmaDTO;
import br.com.luke.testebanco.entity.Aluno;
import br.com.luke.testebanco.persistence.DataBaseClient;

public class BuscarAlunosPorTurmaTask extends AsyncTask<Void, Void, List<TurmaDTO>> {

    private Context context;
    private BuscarAlunosPorTurmaDelegate delegate;

    public BuscarAlunosPorTurmaTask(Context context, BuscarAlunosPorTurmaDelegate delegate) {
        this.context = context;
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<TurmaDTO> doInBackground(Void... voids) {

        List<TurmaDTO> turmas = DataBaseClient.getInstance(context).getDataBase()
                .turmaDao()
                .getAlunosForTurma();

        return turmas;
    }

    @Override
    protected void onPostExecute(List<TurmaDTO> turmas) {
        super.onPostExecute(turmas);
        this.delegate.retornoAlunosPorTurma(turmas);
    }
}
