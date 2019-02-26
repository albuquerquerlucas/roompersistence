package br.com.luke.testebanco.components;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.luke.testebanco.R;

public class TurmaActHolder {

    private EditText edtTurma;
    private Button btnSalvar;
    private Button btnVisualizarTurmas;

    public TurmaActHolder(View view) {
        this.edtTurma = (EditText) view.findViewById(R.id.edt_turma);
        this.btnSalvar = (Button) view.findViewById(R.id.btn_salvar_turma);
        this.btnVisualizarTurmas = (Button) view.findViewById(R.id.btn_ver_turmas);
    }

    public EditText getEdtTurma() {
        return edtTurma;
    }

    public Button getBtnSalvar() {
        return btnSalvar;
    }

    public Button getBtnVisualizarTurmas() {
        return btnVisualizarTurmas;
    }
}
