package com.example.parcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsu, editTextPass;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsu = findViewById(R.id.editTextUsu);
        editTextPass = findViewById(R.id.editTextPass);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCredenciales();
            }
        });
    }

    private void validarCredenciales() {
        String usuario = editTextUsu.getText().toString().trim();
        String contra = editTextPass.getText().toString().trim();

        if (usuario.isEmpty() || contra.isEmpty()) {
            Toast.makeText(this, "Por favor llenar los campos", Toast.LENGTH_SHORT).show();
        } else if (usuario.equals("uac123") && contra.equals("12345678")) {
            Intent intent = new Intent(MainActivity.this, pantalla2.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
