package br.com.luke.testebanco.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.adapters.AlunosAdapter;
import br.com.luke.testebanco.components.AlunosActHolder;
import br.com.luke.testebanco.delegate.BuscarAlunosDelegate;
import br.com.luke.testebanco.dto.AlunoDTO;
import br.com.luke.testebanco.entity.Aluno;
import br.com.luke.testebanco.services.buscar.BuscarAlunosTask;

public class ExibirAlunosActivity extends AppCompatActivity implements BuscarAlunosDelegate {

    private AlunosActHolder ash;
    private AlunosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_alunos);

        this.ash = new AlunosActHolder(getWindow().getDecorView());
    }

    @Override
    protected void onResume() {
        super.onResume();
        new BuscarAlunosTask(this, ExibirAlunosActivity.this).execute();
    }

    @Override
    public void retornoAlunos(List<AlunoDTO> alunos) {
        if(alunos.size() > 0){
            carregarAlunos(alunos);
        }
    }

    private void carregarAlunos(List<AlunoDTO> alunos){
        this.adapter = new AlunosAdapter(this, alunos);
        this.ash.getLvAlunos().setAdapter(this.adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
