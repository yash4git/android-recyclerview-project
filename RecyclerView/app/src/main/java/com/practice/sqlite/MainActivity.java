package com.practice.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.practice.sqlite.adapter.RecyclerViewAdapter;
import com.practice.sqlite.data.DatabaseHandler;
import com.practice.sqlite.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

public class MainActivity extends AppCompatActivity {
    //private ListView listView;
    private List<String> contactString;
    //private ArrayAdapter<String> arrayAdapter;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listView = findViewById(R.id.listview);

        DatabaseHandler dbHandler = new DatabaseHandler(MainActivity.this);

        //dbHandler.addContact(new Contact("Yash","8552985534"));
        //dbHandler.addContact(new Contact("Mummy Jio","7974084225"));
        //dbHandler.addContact(new Contact("Papa","9977448229"));
        //dbHandler.addContact(new Contact("Bony","9131778405"));
        //dbHandler.addContact(new Contact("Sonu Jio","7999854322"));
        //dbHandler.addContact(new Contact("Bel Tiwari","9876543210"));

        final List<Contact> contactList = dbHandler.getAllContacts();
        contactString = new ArrayList<>();

        for(Contact contact : contactList ){
            Log.d(TAG, "onCreate: "+contact.getName());
            contactString.add(contact.getName());
        }

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(this,contactList);
        recyclerView.setAdapter(recyclerViewAdapter);


    }
}