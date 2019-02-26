package br.com.luke.testebanco.components;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.luke.testebanco.R;

public class MenuHolder {

    private TextView txtInfo;
    private Button btnCadastroAluno;
    private Button btnCadastroTurma;

    public MenuHolder(View view) {
        this.txtInfo = (TextView) view.findViewById(R.id.txt_info);
        this.btnCadastroAluno = (Button) view.findViewById(R.id.btn_cadastro_aluno);
        this.btnCadastroTurma = (Button) view.findViewById(R.id.btn_cadastro_turma);
    }

    public TextView getTxtInfo() {
        return txtInfo;
    }

    public Button getBtnCadastroAluno() {
        return btnCadastroAluno;
    }

    public Button getBtnCadastroTurma() {
        return btnCadastroTurma;
    }
}
