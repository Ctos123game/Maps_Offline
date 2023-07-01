package com.example.map_2;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AppCompatActivity {

    EditText username, password, repassword, email, phone;
    Button signup;
    TextView Account;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        signup = findViewById(R.id.btnsignup);
        Account = findViewById(R.id.account);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String userEmail = email.getText().toString();
                String userPhone = phone.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("") || userEmail.equals("") || userPhone.equals("")) {
                    Toast.makeText(Signin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkUsername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass,userEmail,userPhone);
                            if (insert == true) {
                                Toast.makeText(Signin.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getBaseContext(), MapBox_map.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            } else {
                                Toast.makeText(Signin.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Signin.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Signin.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // Add the fade animation
            }
        });

    }
    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // Add the fade animation
    }
}
