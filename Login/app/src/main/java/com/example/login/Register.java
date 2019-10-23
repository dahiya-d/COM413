package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DatabaseHelper db;
    EditText txtEmail, txtPassword, txtConfirmPassword;
    Button bregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        txtEmail = (EditText) findViewById(R.id.editemail);
        txtPassword = (EditText) findViewById(R.id.editpassword);
        txtConfirmPassword = (EditText) findViewById(R.id.editpassword2);

        bregister = (Button) findViewById(R.id.bregister);
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_S = txtEmail.getText().toString();
                String pass_S = txtPassword.getText().toString();
                String confirm_S = txtConfirmPassword.getText().toString();

                if (name_S.equals("") || pass_S.equals("") || confirm_S.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass_S.equals(confirm_S)) {
                        Boolean checkEmail = db.checkEmail(name_S);
                        if (checkEmail == true) {
                            Boolean insert = db.insert(name_S, pass_S);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Register Successful!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Account already Exists !", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Password fields do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
