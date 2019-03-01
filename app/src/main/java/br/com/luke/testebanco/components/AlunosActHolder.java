package br.com.luke.testebanco.components;

import android.view.View;
import android.widget.ListView;

import br.com.luke.testebanco.R;

public class AlunosActHolder {

    private ListView lvAlunos;

    public AlunosActHolder(View view) {
        this.lvAlunos = (ListView) view.findViewById(R.id.lv_alunos);
    }

    public ListView getLvAlunos() {
        return lvAlunos;
    }
}
