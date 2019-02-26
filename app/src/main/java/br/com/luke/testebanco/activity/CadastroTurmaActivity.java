package br.com.luke.testebanco.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.components.TurmaActHolder;
import br.com.luke.testebanco.delegate.BuscarTurmasDelegate;
import br.com.luke.testebanco.entity.Turma;
import br.com.luke.testebanco.services.buscar.BuscarTurmaTask;
import br.com.luke.testebanco.services.salvar.SalvarTurmaTask;
import br.com.luke.testebanco.util.NavigationActivity;

public class CadastroTurmaActivity extends AppCompatActivity implements InitActivity, View.OnClickListener {

    private TurmaActHolder th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_turma);

        this.th = new TurmaActHolder(getWindow().getDecorView());
    }

    @Override
    protected void onResume() {
        super.onResume();
        initListeners();
    }

    @Override
    public void initListeners() {
        this.th.getBtnSalvar().setOnClickListener(this);
        this.th.getBtnVisualizarTurmas().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_salvar_turma :
                salvarTurma();
            break;
            case R.id.btn_ver_turmas :
                //new BuscarTurmaTask(this, CadastroTurmaActivity.this).execute("");
            break;
        }
    }

    private void salvarTurma(){
        String turma = this.th.getEdtTurma().getText().toString();

        if(turma.isEmpty()){
            Toast.makeText(this, "Informe a turma", Toast.LENGTH_SHORT).show();
            return;
        }

        new SalvarTurmaTask(this).execute(turma);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new NavigationActivity(this).goToclass(MenuActivity.class);
    }
}
