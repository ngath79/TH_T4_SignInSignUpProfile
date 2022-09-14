package com.google.signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SignUpActivity extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtPhone;
    private EditText edtAddress;
    private EditText adtPass;
    private Button btnLogin;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        addControls();
        addEvents();

    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = edtUserName.getText().toString().trim();
                final String phone = edtPhone.getText().toString();
                final String address = edtAddress.getText().toString();
                final String pass    = adtPass.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    edtUserName.setError("Username is Required.");
                    return;
                }

                if (TextUtils.isEmpty(phone)) {
                    edtPhone.setError("Phone is Required.");
                    return;
                }

                if (TextUtils.isEmpty(address)) {
                    edtAddress.setError("Address is Required");
                    return;
                }

                if (pass.length() < 6) {
                    adtPass.setError("Password Must be >= 6 Characters");
                    return;
                }


                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                
            }
        });
    }        

    private void addControls() {
        edtUserName = (EditText) findViewById(R.id.username);
        edtPhone = (EditText) findViewById(R.id.phone);
        edtAddress = (EditText) findViewById(R.id.Ad);
        adtPass = (EditText) findViewById(R.id.pass);
        btnLogin = (Button) findViewById(R.id.signup);
    }


}