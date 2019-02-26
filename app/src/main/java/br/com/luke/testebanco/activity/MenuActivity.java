package br.com.luke.testebanco.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.components.MenuHolder;
import br.com.luke.testebanco.util.NavigationActivity;

public class MenuActivity extends AppCompatActivity implements InitActivity, View.OnClickListener {

    private MenuHolder mh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mh = new MenuHolder(getWindow().getDecorView());
    }

    @Override
    protected void onResume() {
        super.onResume();
        initListeners();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cadastro_aluno :
                new NavigationActivity(this).goToclass(CadastroAlunoActivity.class);
            break;
            case R.id.btn_cadastro_turma :
                new NavigationActivity(this).goToclass(CadastroTurmaActivity.class);
            break;
        }
    }

    @Override
    public void initListeners() {
        this.mh.getBtnCadastroAluno().setOnClickListener(this);
        this.mh.getBtnCadastroTurma().setOnClickListener(this);
    }
}
