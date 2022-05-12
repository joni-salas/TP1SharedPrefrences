package com.example.tp1sharedprefrences.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp1sharedprefrences.R;
import com.example.tp1sharedprefrences.model.Usuario;
import com.example.tp1sharedprefrences.request.ApiClient;

public class ViewModelRegistro extends AndroidViewModel {
    private Context context;
    private Usuario u;
    private MutableLiveData<Usuario> usuario;

    public LiveData<Usuario> getUsuario() {
        if (usuario == null) {
            usuario = new MutableLiveData<>();
        }
        return usuario;
    }

    public ViewModelRegistro(@NonNull Application application) {
        super(application);
        context = application.getBaseContext();

    }

    public void guardarDatos(Usuario u){
        ApiClient.guardarUsuario(context,u);
    }

    public void leerDatos(){
        usuario.setValue(ApiClient.leer(context));
    }

}
