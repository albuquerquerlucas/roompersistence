package br.com.luke.testebanco.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.luke.testebanco.R;
import br.com.luke.testebanco.entity.Turma;

public class SpinnerTurmasAdapter extends ArrayAdapter<String> {

    private final Context mContext;
    private final LayoutInflater mInflater;

    private final List<Turma> turmas;
    private final int mResource;

    public SpinnerTurmasAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, 0, objects);

        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mResource = resource;
        this.turmas = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        final View view = mInflater.inflate(mResource, parent, false);

        ViewHolder holder = new ViewHolder();

        holder.txtId = (TextView) view.findViewById(R.id.txt_id_turma);
        holder.txtDescricao = (TextView) view.findViewById(R.id.txt_desc_turma);

        Turma turma = turmas.get(position);

        holder.txtId.setText(String.valueOf(turma.getId()));
        holder.txtDescricao.setText(turma.getTurma());

        return view;
    }

    private class ViewHolder{
        TextView txtId;
        TextView txtDescricao;
    }
}
