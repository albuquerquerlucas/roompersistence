package br.com.luke.testebanco.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.adapters.SpinnerTurmasAdapter;
import br.com.luke.testebanco.components.AlunoActHolder;
import br.com.luke.testebanco.delegate.BuscarTurmasDelegate;
import br.com.luke.testebanco.entity.Turma;
import br.com.luke.testebanco.services.buscar.BuscarTurmasTask;
import br.com.luke.testebanco.services.salvar.SalvarAlunoTask;
import br.com.luke.testebanco.util.NavigationActivity;

public class CadastroAlunoActivity extends AppCompatActivity implements InitActivity, BuscarTurmasDelegate, View.OnClickListener {

    private AlunoActHolder ah;
    private SpinnerTurmasAdapter adapter;

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

        new BuscarTurmasTask(this, CadastroAlunoActivity.this).execute();
    }

    @Override
    public void initListeners() {
        this.ah.getBtnSalvar().setOnClickListener(this);
        this.ah.getBtnVisualizarAlunos().setOnClickListener(this);

        /*this.ah.getSpTurma().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //idTurma = Long.parseLong(((TextView)view.findViewById(R.id.txt_id_turma)).getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_salvar_aluno :
                salvarAluno();
            break;
            case R.id.btn_ver_alunos :
                new NavigationActivity(this).goToclass(ExibirAlunosActivity.class);
            break;
        }
    }

    private void salvarAluno(){

        String aluno = this.ah.getEdtAluno().getText().toString();
        Turma turma = (Turma) this.ah.getSpTurma().getSelectedItem();

        if (aluno.isEmpty()){
            Toast.makeText(this, "Informe o nome do aluno.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(turma.getTurma().contains("Selecione")){
            Toast.makeText(this, "Selecione uma turma.", Toast.LENGTH_SHORT).show();
            return;
        }

        new SalvarAlunoTask(this).execute(aluno, String.valueOf(turma.getId()));
    }

    @Override
    public void retornoTurmas(List<Turma> turmas) {
        if(turmas.size() > 0){
            carregarTurmas(turmas);
        }
    }

    private void carregarTurmas(List<Turma> turmas){
        this.adapter = new SpinnerTurmasAdapter(this, R.layout.item_sp_turmas, turmas);
        this.ah.getSpTurma().setAdapter(this.adapter);
        cleanComponents();
    }

    @Override
    public void cleanComponents() {
        this.ah.getEdtAluno().setText("");
        this.ah.getEdtAluno().requestFocus();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new NavigationActivity(this).goToclass(MenuActivity.class);
    }
}
