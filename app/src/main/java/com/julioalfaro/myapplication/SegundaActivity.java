package com.julioalfaro.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView nombreusuario;
    private Button btnLogout;
    private Spinner test;
    private SharedPreferences p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_layout);
        p = PreferenceManager.getDefaultSharedPreferences(this);
        nombreusuario = findViewById(R.id.txt_nombre_usuario);
        btnLogout = findViewById(R.id.btn_logout);
        test = findViewById(R.id.spn_test);
        nombreusuario.setText(p.getString("user",""));
        btnLogout.setOnClickListener(this);
        List<String> datos = new ArrayList<String>();
        datos.add("uno");
        datos.add("dos");
        datos.add("tres");
        test.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos));
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor edit = p.edit();
        edit.putString("user","");
        edit.commit();
        Toast.makeText(this, ((String) test.getSelectedItem()), Toast.LENGTH_LONG).show();
        finish();
    }
}
