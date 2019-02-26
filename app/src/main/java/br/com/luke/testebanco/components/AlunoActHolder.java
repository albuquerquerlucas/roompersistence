package br.com.luke.testebanco.components;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import br.com.luke.testebanco.R;

public class AlunoActHolder {

    private EditText edtAluno;
    private Spinner spTurma;
    private Button btnSalvar;
    private Button btnVisualizarAlunos;

    public AlunoActHolder(View view) {
        this.edtAluno = (EditText) view.findViewById(R.id.edt_aluno);
        this.spTurma = (Spinner) view.findViewById(R.id.sp_turmas);
        this.btnSalvar = (Button) view.findViewById(R.id.btn_salvar_aluno);
        this.btnVisualizarAlunos = (Button) view.findViewById(R.id.btn_ver_alunos);
    }

    public EditText getEdtAluno() {
        return edtAluno;
    }

    public Spinner getSpTurma() {
        return spTurma;
    }

    public Button getBtnSalvar() {
        return btnSalvar;
    }

    public Button getBtnVisualizarAlunos() {
        return btnVisualizarAlunos;
    }
}
