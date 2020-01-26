package com.example.user.chaishack;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;

public class Signup_Form extends AppCompatActivity {
    EditText Email;
    EditText Password;
    EditText ConfirmPassword;
    private CheckedTextView cb;
    boolean fasle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_signup__form);
      getSupportActionBar().setTitle("Signup Form");


    }

    public void btn_Home(View view) {

        startActivity(new Intent(getApplicationContext(),Home.class));



        String Em = Email.getText().toString();
        String pss = Password.getText().toString();
        String pc = ConfirmPassword.getText().toString();
        boolean IsError = fasle;

        if (Em != null && Em.equalsIgnoreCase("")) {

            Email.setError("Please Enter Valid Email Address");
            IsError = true;

        }

        if (pss.equalsIgnoreCase("")) {

            Password.setError("Please Enter the correct password ");
            IsError = true;

        }
        if (pc != null && pc.equalsIgnoreCase("")) {

            Email.setError("Password is not match ");
            IsError = true;

        }

        if (!cb.isChecked()) {
            cb.setTextColor(Color.RED);
            IsError = true;
        }


    }



}
