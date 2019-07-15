package com.example.mughees.mplassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    private EditText etEmail,etPassword,etConfirmPassword;
    private Button btnLogin, btnRegister;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
        actionListeners();
    }
    public void initialize() {
        etEmail=findViewById(R.id.etClassEightRegisterUsername);
        etPassword = findViewById(R.id.etClassEightRegisterPassword);
        etConfirmPassword = findViewById(R.id.etClassEightRegisterConfirmPassword);
        btnLogin = findViewById(R.id.btnClassEightLogin);
        btnRegister = findViewById(R.id.btnClassEightRegister);
    }
    public void actionListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this,login.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputEmail = etEmail.getText().toString();
                String inputPassword = etPassword.getText().toString();
                String inputConfirmPassword = etConfirmPassword.getText().toString();

                if(isAllFieldsFilled(inputEmail,inputPassword,inputConfirmPassword)) {
                    if(isEmailValid(inputEmail)) {
                        if (isPasswordMatches(inputPassword,inputConfirmPassword)) {
                            sharedPreferences= getSharedPreferences("com.example.mughees.mplassignment", Context.MODE_PRIVATE);
                            sharedPreferences.edit().putString("email",inputEmail).apply();
                            sharedPreferences.edit().putString("password",inputPassword).apply();

                            Toast.makeText(register.this,"Data saved successfully",Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Please enter correct password",Toast.LENGTH_SHORT).show();
                        }

                    }

                    else {
                        Toast.makeText(getApplicationContext(),"Please enter correct email",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please enter all fields",Toast.LENGTH_SHORT).show();
                }



            }

            private boolean isPasswordMatches(String inputPassword, String inputConfirmPassword) {

                if (inputPassword.matches(inputConfirmPassword)) {
                    return true;
                }
                else {
                    return false;
                }

            }


            private boolean isEmailValid(String inputEmail) {
                if (Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()) {
                    return true;
                }

                else {
                    return false;
                }

            }



            private boolean isAllFieldsFilled(String inputEmail, String inputPassword, String inputConfirmPassword) {
                if (TextUtils.isEmpty(inputEmail) || TextUtils.isEmpty(inputPassword) || TextUtils.isEmpty(inputConfirmPassword)) {
                    return false;
                }
                else {
                    return true;
                }
            }
        });
    }
}
