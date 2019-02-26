package br.com.luke.testebanco.services.salvar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.com.luke.testebanco.activity.MainActivity;
import br.com.luke.testebanco.entity.Usuario;
import br.com.luke.testebanco.persistence.DataBaseClient;

public class SalvarUsuarioTask extends AsyncTask<String, Void, Void> {

    @SuppressLint("StaticFieldLeak")
    private Context context;

    public SalvarUsuarioTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {

        Usuario usuario = new Usuario();
        usuario.setNome(params[0]);
        usuario.setLogin(params[1]);
        usuario.setSenha(params[2]);
        usuario.setTipo(Integer.parseInt(params[3]));

        DataBaseClient.getInstance(context).getDataBase()
                .usuarioDao()
                .insert(usuario);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(context, "Salvo com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
