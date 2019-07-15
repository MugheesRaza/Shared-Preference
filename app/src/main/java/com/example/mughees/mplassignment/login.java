package com.example.mughees.mplassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {

    private EditText etEmail,etPassword;
    private Button btnLogin, btnRegister;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        actionListeners();
    }
    private void initialize() {
        etEmail = findViewById(R.id.etClassEightLoginUsername);
        etPassword = findViewById(R.id.etClassEightLoginPassword);
        btnRegister=  findViewById(R.id.btnClassEightRegisterRR);
        btnLogin = findViewById(R.id.btnClassEightLoginRR);
    }

    private void actionListeners() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(login.this,register.class);
                startActivity(intent);
            }

        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences= getSharedPreferences("com.example.mughees.mplassignment", Context.MODE_PRIVATE);
                String userEmail = etEmail.getText().toString();
                String userPassword = etPassword.getText().toString();



                String email = sharedPreferences.getString("email","");
                String password = sharedPreferences.getString("password","");

                if (userEmail.equals(email) & userPassword.equals(password)) {
                    Intent intent =  new Intent(login.this, MoviesList.class);
                    startActivity(intent);
                }
            }
        });
    }
}
