package com.example.map_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView phoneNumberRecyclerView;
    private PhoneNumberAdapter phoneNumberAdapter;

    private List<PhoneNumber> phoneNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        phoneNumbers = new ArrayList<>();
        phoneNumbers.add(new PhoneNumber("Emergency", "117"));
        phoneNumbers.add(new PhoneNumber("Red Cross", "143"));
        phoneNumbers.add(new PhoneNumber("Police", "(02)5270000"));
        phoneNumbers.add(new PhoneNumber("Fire Department", "136"));

        // Add more phone numbers as needed

        phoneNumberRecyclerView = findViewById(R.id.phone_number_recycler_view);
        phoneNumberRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        phoneNumberAdapter = new PhoneNumberAdapter(phoneNumbers, MainActivity.this);
        phoneNumberRecyclerView.setAdapter(phoneNumberAdapter);
    }
}
