package br.com.luke.testebanco.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.dto.AlunoDTO;
import br.com.luke.testebanco.entity.Aluno;

public class AlunosAdapter extends BaseAdapter {

    private Context context;
    private List<AlunoDTO> alunosList;
    private static LayoutInflater mInflater = null;

    public AlunosAdapter(Context context, List<AlunoDTO> alunosList) {
        this.context = context;
        this.alunosList = alunosList;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.alunosList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.alunosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();
        View rowView = convertView;

        rowView = mInflater.inflate(R.layout.item_lv_alunos, null);

        viewHolder.txtId = (TextView) rowView.findViewById(R.id.txt_item_id);
        viewHolder.txtNome = (TextView) rowView.findViewById(R.id.txt_item_aluno);
        viewHolder.txtTurma = (TextView) rowView.findViewById(R.id.txt_item_turma);

        viewHolder.txtId.setText(String.valueOf(alunosList.get(position).getId()));
        viewHolder.txtNome.setText(alunosList.get(position).getNm_aluno());
        viewHolder.txtTurma.setText(alunosList.get(position).getDs_turma());


        return rowView;
    }

    private  class ViewHolder{
        TextView txtId;
        TextView txtNome;
        TextView txtTurma;
    }
}
