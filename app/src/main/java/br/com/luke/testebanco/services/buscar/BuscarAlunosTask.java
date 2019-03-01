package br.com.luke.testebanco.services.buscar;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import br.com.luke.testebanco.delegate.BuscarAlunosDelegate;
import br.com.luke.testebanco.dto.AlunoDTO;
import br.com.luke.testebanco.entity.Aluno;
import br.com.luke.testebanco.persistence.DataBaseClient;

public class BuscarAlunosTask extends AsyncTask<Void, Void, List<AlunoDTO>> {

    private Context context;
    private BuscarAlunosDelegate delegate;

    public BuscarAlunosTask(Context context, BuscarAlunosDelegate activity) {
        this.context = context;
        this.delegate = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<AlunoDTO> doInBackground(Void... voids) {

        List<AlunoDTO> alunos = DataBaseClient.getInstance(context).getDataBase()
                .alunoDao()
                .getAlunos();;


        return alunos;
    }

    @Override
    protected void onPostExecute(List<AlunoDTO> alunos) {
        super.onPostExecute(alunos);
        this.delegate.retornoAlunos(alunos);
    }
}
