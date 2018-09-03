package com.lenovoexample.tracingpractica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {
    private TextView tDatos;
    String correo, contraseña, repContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        tDatos = findViewById(R.id.tDatos);

        Bundle args = getIntent().getExtras();
        if(args!=null){                 //validacion
            correo = args.getString("correo");
            contraseña = args.getString("contraseña");
            repContraseña = args.getString("repContraseña");
            tDatos.setText(correo);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == 1234 && resultCode == RESULT_OK){
            correo = data.getExtras().getString("correo");
            contraseña = data.getExtras().getString("contraseña");
            repContraseña = data.getExtras().getString("repContraseña");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //coloca menu
        getMenuInflater().inflate(R.menu.perfilmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        switch (id){
            case R.id.mPrincipal:
                intent = new Intent(PerfilActivity.this,MainActivity.class);
                intent.putExtra("contraseña",contraseña);
                intent.putExtra("correo",correo);
                intent.putExtra("repContraseña",repContraseña);
                setResult(RESULT_OK, intent);
                startActivity(intent);
                break;
            case R.id.mSesion:
                intent = new Intent(PerfilActivity.this,LoginActivity.class);
                intent.putExtra("contraseña",contraseña);
                intent.putExtra("correo",correo);
                intent.putExtra("repContraseña",repContraseña);
                startActivity(intent);
                break;
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
