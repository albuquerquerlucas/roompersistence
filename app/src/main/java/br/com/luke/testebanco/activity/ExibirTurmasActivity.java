package br.com.luke.testebanco.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.adapters.TurmasAdapter;
import br.com.luke.testebanco.components.TurmasActHolder;
import br.com.luke.testebanco.delegate.BuscarAlunosPorTurmaDelegate;
import br.com.luke.testebanco.delegate.BuscarTurmasDelegate;
import br.com.luke.testebanco.dto.TurmaDTO;
import br.com.luke.testebanco.entity.Aluno;
import br.com.luke.testebanco.entity.Turma;
import br.com.luke.testebanco.services.buscar.BuscarAlunosPorTurmaTask;
import br.com.luke.testebanco.services.buscar.BuscarTurmasTask;

public class ExibirTurmasActivity extends AppCompatActivity implements BuscarAlunosPorTurmaDelegate {

    private TurmasActHolder tah;
    private TurmasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_turmas);

        this.tah = new TurmasActHolder(getWindow().getDecorView());
    }

    @Override
    protected void onResume() {
        super.onResume();
        new BuscarAlunosPorTurmaTask(this, ExibirTurmasActivity.this).execute();
    }

    @Override
    public void retornoAlunosPorTurma(List<TurmaDTO> turmas) {
        carregarTurmas(turmas);
    }

    private void carregarTurmas(List<TurmaDTO> turmas){
        this.adapter = new TurmasAdapter(this, turmas);
        this.tah.getLvTurmas().setAdapter(this.adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
