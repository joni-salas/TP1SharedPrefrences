package com.example.tp1sharedprefrences.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tp1sharedprefrences.model.Usuario;

public class ApiClient {

    private static SharedPreferences sharedPreferences;
    private static ApiClient api=null;

    private static void getSharedPreferences(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences("datos", 0);
        }
    }

    public static void guardarUsuario(Context context, Usuario usuario){
        getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("dni", usuario.getDni());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("mail", usuario.getMail());
        editor.putString("password", usuario.getPassword());
        editor.commit();
    }

    public static Usuario login (Context context, String mail, String password){
        Usuario usuario = null;
        getSharedPreferences(context);
        String dni = sharedPreferences.getString("dni", "-1");
        String apellido = sharedPreferences.getString("apellido", "-1");
        String nombre = sharedPreferences.getString("nombre", "-1");
        String email = sharedPreferences.getString("mail", "-1");
        String clave = sharedPreferences.getString("password", "-1");

        if(mail.equals(email) && password.equals(clave)){
            usuario = new Usuario(dni, apellido, nombre, email, clave);
        }

        return usuario;
    }

    public static Usuario leer(Context context){
        getSharedPreferences(context);
        String dni = sharedPreferences.getString("dni", "-1");
        String apellido = sharedPreferences.getString("apellido", "-1");
        String nombre = sharedPreferences.getString("nombre", "-1");
        String email = sharedPreferences.getString("mail", "-1");
        String clave = sharedPreferences.getString("password", "-1");

        Usuario usuario = new Usuario(dni, apellido, nombre, email, clave);
        return usuario;
    }

}
