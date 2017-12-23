package com.example.sh_polak.udemyadapter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {
    private static HashMap<String, String> user = new HashMap<>();
    EditText mNameText, mPassword, mPasswoedConfirm;
    static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mNameText = (EditText) findViewById(R.id.nametext);
        mPassword = (EditText) findViewById(R.id.passwordtext);
        mPasswoedConfirm = (EditText) findViewById(R.id.confirm);
        prefs = getSharedPreferences("usersinfo", MODE_PRIVATE);

    }

    public static void setUser(HashMap<String, String> user) {
        SignupActivity.user = user;
    }

    public static HashMap<String, String> getUser() {
        return user;
    }

    public void registerd(View view) {
        if ((mNameText.getText().toString() != null) || (mPassword.getText().toString() != null) || (mPasswoedConfirm.getText().toString() != null)) {
            if (mPassword.getText().toString().equals(mPasswoedConfirm.getText().toString())) {
                if (!user.containsKey(mNameText.getText().toString())) {
                    user.put(mNameText.getText().toString(), mPassword.getText().toString());
                    addUserPref(mNameText.getText().toString(), mPassword.getText().toString());
                    Toast.makeText(this, "registerd completed", Toast.LENGTH_LONG).show();
                    System.out.println("registerd completed");
                    finish();
                } else Toast.makeText(this, "this name alrdy exist", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(this, "password are not match pls try again", Toast.LENGTH_LONG).show();

        } else Toast.makeText(this, "Invalid inputs try again", Toast.LENGTH_SHORT).show();
    }

    public void addUserPref(String name, String password) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("uName", name);
        editor.putString("uPassword", password);
        editor.apply();
    }

    public String getUserName() {
        return prefs.getString("uName", "");
    }

    public String getUserPassword() {
        return prefs.getString("uPassword", "");

    }

}
