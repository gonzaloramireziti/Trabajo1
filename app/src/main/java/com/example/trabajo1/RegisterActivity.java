package com.example.trabajo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText email, pass, rep_pass, nombreus;
    Button btnRegister, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass2);
        rep_pass = findViewById(R.id.rep_pass);
        btnRegister = findViewById(R.id.reg);
        nombreus = findViewById(R.id.nombreuser);
        btnVolver = findViewById(R.id.volver);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailR = email.getText().toString();
                String passR = pass.getText().toString();
                String rep_passR = rep_pass.getText().toString();
                String nombreUser = nombreus.getText().toString();


                if(emailR.isEmpty() || nombreUser.isEmpty() ){

                    Toast.makeText(RegisterActivity.this, "Los campos no deben estar vacios.", Toast.LENGTH_SHORT).show();


                }else{
                    if(rep_passR.length()<6){
                        Toast.makeText(RegisterActivity.this, "La contraseña debe tener al menos 6 caracteres.", Toast.LENGTH_SHORT).show();

                    }else{

                        if(rep_passR.equals(passR)){
                            Navigator.navegarTo(RegisterActivity.this,LoginActivity.class);
                        }else{
                            Toast.makeText(RegisterActivity.this, "Las contraseñas deben coincidir.", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigator.navegarTo(RegisterActivity.this,LoginActivity.class);

            }
        });


    }
}