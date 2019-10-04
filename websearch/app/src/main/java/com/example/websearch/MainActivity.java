package com.example.websearch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void webSearch(View view){
        String searchFor = ((EditText) findViewById(R.id.editText)) .getText().toString();
        Intent viewSearch = new Intent(Intent.ACTION_WEB_SEARCH);
        viewSearch.putExtra(SearchManager.QUERY, searchFor);
        startActivity(viewSearch);


    }
}
