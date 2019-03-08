package br.com.luke.testebanco.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.dto.TurmaDTO;
import br.com.luke.testebanco.entity.Turma;

public class TurmasAdapter extends BaseAdapter {

    private Context context;
    private List<TurmaDTO> turmasList;
    private LayoutInflater mInflater = null;
    //private StringBuilder sb = new StringBuilder();

    public TurmasAdapter(Context context, List<TurmaDTO> turmasList) {
        this.context = context;
        this.turmasList = turmasList;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.turmasList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.turmasList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();

        View rowView = convertView;

        rowView = mInflater.inflate(R.layout.item_lv_turmas, null);

        viewHolder.txtId = (TextView) rowView.findViewById(R.id.txt_item_id);
        viewHolder.txtTurma = (TextView) rowView.findViewById(R.id.txt_item_turma);
        viewHolder.txtAlunos = (TextView) rowView.findViewById(R.id.txt_item_alunos_turma);

        viewHolder.txtId.setText(String.valueOf(turmasList.get(position).getId()));
        viewHolder.txtTurma.setText(turmasList.get(position).getDs_turma());

        switch (turmasList.size()){
            case 1:
                StringBuilder sb1 = new StringBuilder();
                sb1.append(turmasList.get(position).getNm_aluno()).append("\n");
                viewHolder.txtAlunos.setText(String.valueOf(sb1));
            break;
            case 2:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(turmasList.get(position).getNm_aluno()).append("\n");
                viewHolder.txtAlunos.setText(String.valueOf(sb2));
                break;
            case 3:
                StringBuilder sb3 = new StringBuilder();
                sb3.append(turmasList.get(position).getNm_aluno()).append("\n");
                viewHolder.txtAlunos.setText(String.valueOf(sb3));
                break;
            case 4:
                StringBuilder sb4 = new StringBuilder();
                sb4.append(turmasList.get(position).getNm_aluno()).append("\n");
                viewHolder.txtAlunos.setText(String.valueOf(sb4));
                break;
        }

        return rowView;
    }

    private class ViewHolder{
        TextView txtId;
        TextView txtTurma;
        TextView txtAlunos;
    }
}
