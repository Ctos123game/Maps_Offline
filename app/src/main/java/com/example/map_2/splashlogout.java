package com.example.map_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashlogout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        // Show loading screen
        ProgressDialog progressDialog = new ProgressDialog(splashlogout.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.activity_splashactivity);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        // Simulate loading delay

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Dismiss loading screen
                startActivity(new Intent(splashlogout.this, Login.class));
            }
        }, 3000);
        // To dismiss the loading screen:
        // progressDialog.dismiss();

    }
}