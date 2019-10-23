package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        TextView textViewUserEmail = (TextView) findViewById(R.id.textViewprofile);
        textViewUserEmail.setText("Welcome: " + currentUser.getEmail());


    }
    public void logOut(View view){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(ProfileActivity.this, LoginActivity.class));

    }
}
