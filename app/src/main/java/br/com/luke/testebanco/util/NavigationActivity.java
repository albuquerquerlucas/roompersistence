package br.com.luke.testebanco.util;

import android.content.Context;
import android.content.Intent;

public class NavigationActivity {

    private Context mCtx;

    public NavigationActivity(Context mCtx) {
        this.mCtx = mCtx;
    }

    public void goToclass(Class toClass){
        mCtx.startActivity(new Intent(mCtx, toClass)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP)
        );
    }
}
