package br.com.luke.testebanco.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.entity.Turma;

public class TurmasAdapter extends BaseAdapter {

    private Context context;
    private List<Turma> turmasList;
    private LayoutInflater mInflater = null;

    public TurmasAdapter(Context context, List<Turma> turmasList) {
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
        viewHolder.txtTurma.setText(turmasList.get(position).getTurma());

        return rowView;
    }

    private class ViewHolder{
        TextView txtId;
        TextView txtTurma;
        TextView txtAlunos;
    }
}
