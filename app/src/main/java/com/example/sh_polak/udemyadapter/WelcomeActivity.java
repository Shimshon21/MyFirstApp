package com.example.sh_polak.udemyadapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class WelcomeActivity extends AppCompatActivity {
    EditText mName, mPassword;
    static Boolean checkbox=false;
   static SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mName = (EditText) findViewById(R.id.nametext);
        mPassword = (EditText) findViewById(R.id.passwordtext);
        preferences=getSharedPreferences("userName",MODE_PRIVATE);




    }

    @Override
    protected void onStart() {
        super.onStart();
        if(getCheckbox()){
            startActivity(new Intent(this,MainActivity.class));
        }

    }
    public void ActivitySignup(View view) {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }

    public void mainActivity(View view) {
        String name=mName.getText().toString();
        String password=mPassword.getText().toString();
        SignupActivity reg = new SignupActivity();
       // if(reg.getUserName().equals(name)&&reg.getUserPassword().equals(password)){
       if ((reg.getUser().containsKey(name))&& (reg.getUser().get(name).equals(password))) {
               if (checkbox ) {
                   setEdit(name,password,checkbox);
               }
               //&& (password.getText().toString().equals())))
               Toast.makeText(this, "welcome", Toast.LENGTH_LONG).show();
               startActivity(new Intent(this, MainActivity.class));

       }else {
            Toast.makeText(this,"wrong values",Toast.LENGTH_SHORT).show();
    }
    }

    public void setCheck(View view) {
        if(((CheckBox)view).isChecked()) {
            checkbox = true;
            Toast.makeText(this, "true", Toast.LENGTH_LONG).show();
        }  else{
            checkbox =false;
            Toast.makeText(this, "false", Toast.LENGTH_LONG).show();
        }
    }
    public static void setEdit(String name,String password,Boolean checkbox){
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("uName", name);
        edit.putString("uPass", password);
        edit.putBoolean("uRemambard", checkbox);
        edit.apply();
    }
    public Boolean getCheckbox(){
        return preferences.getBoolean("uRemambard",false);
    }
}
