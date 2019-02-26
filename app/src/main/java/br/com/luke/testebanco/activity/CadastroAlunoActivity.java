package br.com.luke.testebanco.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.components.AlunoActHolder;
import br.com.luke.testebanco.delegate.BuscarTurmasDelegate;
import br.com.luke.testebanco.entity.Turma;
import br.com.luke.testebanco.services.salvar.SalvarTurmaTask;
import br.com.luke.testebanco.util.NavigationActivity;

public class CadastroAlunoActivity extends AppCompatActivity implements InitActivity, BuscarTurmasDelegate, View.OnClickListener {

    private AlunoActHolder ah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        this.ah = new AlunoActHolder(getWindow().getDecorView());
    }

    @Override
    protected void onResume() {
        super.onResume();
        initListeners();
    }

    @Override
    public void initListeners() {
        this.ah.getBtnSalvar().setOnClickListener(this);
        this.ah.getBtnVisualizarAlunos().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_salvar_aluno :
                salvarAluno();
            break;
            case R.id.btn_ver_alunos :
                Toast.makeText(this, "Teste OK", Toast.LENGTH_SHORT).show();
            break;
        }
    }

    private void salvarAluno(){

        String aluno = this.ah.getEdtAluno().getText().toString();
        String turma = this.ah.getSpTurma().getSelectedItem().toString();

        if (aluno.isEmpty()){
            Toast.makeText(this, "Informe o nome do aluno.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(turma.contains("Selecione")){
            Toast.makeText(this, "Selecione uma turma.", Toast.LENGTH_SHORT).show();
            return;
        }

        new SalvarTurmaTask(this).execute(aluno, turma);
    }

    @Override
    public void retornoTurmas(List<Turma> turmas) {
        if(turmas.size() > 0){
            carregarTurmas(turmas);
        }
    }

    private void carregarTurmas(List<Turma> turmas){

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new NavigationActivity(this).goToclass(MenuActivity.class);
    }
}
