package com.example.trabajo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText user, pass;
    Button btnLogin,btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        user = findViewById(R.id.usuario);
        pass = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.sesion);
        btnRegister = findViewById(R.id.register);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getUs = user.getText().toString();
                String getPass = pass.getText().toString();

                if(getUs.equals("Juan Torres") && getPass.equals("1234utn")){

                    Navigator.navegarTo(LoginActivity.this,MainActivity.class);
                }else{

                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecto/s", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigator.navegarTo(LoginActivity.this,RegisterActivity.class);
            }
        });
    }



}