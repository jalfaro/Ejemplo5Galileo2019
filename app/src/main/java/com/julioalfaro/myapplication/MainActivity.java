package com.julioalfaro.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtUsuario, txtPassword;
    private Button btnLogin;
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario = findViewById(R.id.txt_usuario);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        edit = preferences.edit();
        if (!preferences.getString("user","").equals("")) {
            Intent intent = new Intent(this, SegundaActivity.class);
            startActivityForResult(intent, 101);
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            if (txtUsuario.getText().toString().equals("julio") && txtPassword.getText().toString().equals("alfaro")) {
                Intent intent = new Intent(this, SegundaActivity.class);
                startActivityForResult(intent, 101);
                edit.putString("user", "julio");
                edit.commit();
            } else {
                Toast.makeText(this, "Credenciales no validas", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (!preferences.getString("user", "").equals("")) {
                finish();
            }
        }
    }
}
