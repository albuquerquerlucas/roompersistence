package br.com.luke.testebanco.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.services.salvar.SalvarUsuarioTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Holder h = new Holder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.h.btnSalvar.setOnClickListener(this);
    }

    private void initUi(){
        this.h.edtNome = (EditText) findViewById(R.id.edt_nome);
        this.h.edtLogin = (EditText) findViewById(R.id.edt_login);
        this.h.edtSenha = (EditText) findViewById(R.id.edt_senha);
        this.h.spTipo = (Spinner) findViewById(R.id.sp_tipo);
        this.h.btnSalvar = (Button) findViewById(R.id.btn_salvar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_salvar :
                salvar();
            break;
        }
    }

    private void salvar(){
        String nome = this.h.edtNome.getText().toString().trim();
        String login = this.h.edtLogin.getText().toString().trim();
        String senha = this.h.edtSenha.getText().toString().trim();
        String tipo = this.h.spTipo.getSelectedItem().toString();

        if(tipo.contains("Selecione")){

            Toast.makeText(this, "Selecione o tipo", Toast.LENGTH_SHORT).show();
            return;
        }

        new SalvarUsuarioTask(this).execute(nome, login, senha, tipo);

        cleanInputs();
    }

    public void cleanInputs(){
        this.h.edtNome.setText("");
        this.h.edtLogin.setText("");
        this.h.edtSenha.setText("");

        this.h.edtNome.requestFocus();
    }

    private class Holder{
        EditText edtNome;
        EditText edtLogin;
        EditText edtSenha;
        Spinner spTipo;
        Button btnSalvar;
    }
}
