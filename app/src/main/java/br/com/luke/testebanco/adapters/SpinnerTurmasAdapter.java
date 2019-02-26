package br.com.luke.testebanco.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

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

        TextView offTypeTv = (TextView) view.findViewById(R.id.offer_type_txt);
        TextView numOffersTv = (TextView) view.findViewById(R.id.num_offers_txt);
        TextView maxDiscTV = (TextView) view.findViewById(R.id.max_discount_txt);

        Offer offerData = items.get(position);

        offTypeTv.setText(offerData.getOfferType());
        numOffersTv.setText(offerData.getNumberOfCoupons());
        maxDiscTV.setText(offerData.getMaxDicount());

        return view;
    }
}
