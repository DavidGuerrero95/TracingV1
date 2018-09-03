package com.lenovoexample.tracingpractica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText eCorreo, eContraseña;
    private Button bRegistro;
    private TextView tRegistro;
    String correo = "", contraseña ="", repContraseña ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eCorreo = findViewById(R.id.eCorreo);
        eContraseña = findViewById(R.id.eContraseña);
        bRegistro = findViewById(R.id.bRegistro);
        tRegistro = findViewById(R.id.tRegistro);

        Bundle args = getIntent().getExtras();
        if(args !=null){
            correo = args.getString("correo");
            contraseña = args.getString("contraseña");
            repContraseña = args.getString("repContraseña");
        }
        tRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this,RegistroActivity.class);
            startActivityForResult(intent,1234);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == 1234 && resultCode == RESULT_OK){
            correo = data.getExtras().getString("correo");
            contraseña = data.getExtras().getString("contraseña");
            repContraseña = data.getExtras().getString("repContraseña");
        }
        if( requestCode == 1 && resultCode == RESULT_OK){
            correo = data.getExtras().getString("correo");
            contraseña = data.getExtras().getString("contraseña");
            repContraseña = data.getExtras().getString("repContraseña");
        }
    }

    public void enviardatos(View view) {
        String mail, pass;
        pass = eContraseña.getText().toString();
        mail = eCorreo.getText().toString();
        if(correo.equals("")||contraseña.equals("")) {
            Toast.makeText(this, "No hay datos registrados", Toast.LENGTH_SHORT).show();
        }else if(mail.equals(correo)){
            if(pass.equals(contraseña)){
                mail = "";
                pass = "";
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("correo",correo);
                intent.putExtra("contraseña",contraseña);
                intent.putExtra("repContraseña",repContraseña);
                startActivityForResult(intent,1);
            }else{
                Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Usuario invalido",Toast.LENGTH_SHORT).show();
        }
    }
}