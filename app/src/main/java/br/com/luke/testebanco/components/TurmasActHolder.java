package br.com.luke.testebanco.components;

import android.view.View;
import android.widget.ListView;

import br.com.luke.testebanco.R;

public class TurmasActHolder {

    private ListView lvTurmas;

    public TurmasActHolder(View view) {
        this.lvTurmas = (ListView) view.findViewById(R.id.lv_turmas);
    }

    public ListView getLvTurmas() {
        return lvTurmas;
    }
}
