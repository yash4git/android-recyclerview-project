package com.practice.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView name;
    private TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        Bundle bundle = getIntent().getExtras();
        if(bundle!= null){
            String user_name = bundle.getString("name");
            String user_number = bundle.getString("number");
            name.setText(user_name);
            number.setText(user_number);

        }





    }
}