package com.google.signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private Button button;

    EditText email, pass;
    Button btnLognin;
    CheckBox chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        btnLognin = findViewById(R.id.lognin);

        button = (Button) findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });
    }
    public void openSignUp() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


    public int isLogin(String u, String p) {
        if(u.equals("nga") && p.equals("123")) {
            return 1;
        }
        else {
            return 0;
        }
    }

    String strU, strP;
    public void checkLogin(View view) {
        strU = email.getText().toString();
        strP = pass.getText().toString();
        if(strU.isEmpty() || strP.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Username không được để trống",
                    Toast.LENGTH_LONG).show();
        }
        else {
            if(isLogin(strU, strP)>0) {
                Toast.makeText(getApplicationContext(),"Logn In thành công",
                        Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                    }
                },2000);
            }
            else {
                Toast.makeText(getApplicationContext(),"Sai Username, Password",
                        Toast.LENGTH_LONG).show();
            }
        }
    }



    }
