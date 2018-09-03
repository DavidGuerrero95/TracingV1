package com.lenovoexample.tracingpractica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    private EditText eCorreo, eContraseña, eRepContraseña;
    private Button bButon;
    String correo, contraseña, repContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eCorreo = findViewById(R.id.eCorreo);
        eContraseña = findViewById(R.id.eContraseña);
        eRepContraseña = findViewById(R.id.eRepContraseña);
        bButon = findViewById(R.id.bButon);
        bButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo = eCorreo.getText().toString();
                contraseña = eContraseña.getText().toString();
                repContraseña = eRepContraseña.getText().toString();
                if(correo.equals("")||contraseña.equals("")||repContraseña.equals("")) {
                    Toast.makeText(getApplicationContext(), "Llene todos los espacios ", Toast.LENGTH_LONG).show();
                }else if(contraseña.equals(repContraseña)){
                    Intent intent = new Intent();
                    intent.putExtra("correo",correo);
                    intent.putExtra("contraseña",contraseña);
                    intent.putExtra("repContraseña",repContraseña);
                    setResult(RESULT_OK, intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Contraseña Incorrecta ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
