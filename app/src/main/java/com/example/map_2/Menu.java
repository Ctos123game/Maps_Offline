package com.example.map_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
    TextView profile_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



    }

    public void navigateToModule1(View view) {
        Intent intent = new Intent(this, MapBox_map.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void navigateToModule2(View view) {
        Intent intent = new Intent(this, SMS_Page_1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void navigateToModule3(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void logout(View view) {
        // Perform logout actions here
        // For example, clearing user session, resetting preferences, etc.
        // After logout, navigate to the login screen
        Intent intent = new Intent(this, splashlogout.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        // Disable the back button functionality
        // Do nothing to prevent going back to the previous activity
    }
}
