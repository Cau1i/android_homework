package com.example.homework02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_login extends AppCompatActivity {

    private Button button_logins;
    private EditText editText_phones;
    private EditText editText_numbers;
    private EditText editText_passwords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("main", "---onCreate");
        setContentView(R.layout.activity_login);

        button_logins = (Button)findViewById(R.id.button_login);
        editText_phones = (EditText)findViewById(R.id.editText_phone) ;
        editText_numbers = (EditText)findViewById(R.id.editText_number) ;
        editText_passwords = (EditText)findViewById(R.id.editText_password) ;

        button_logins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_login.this,activity_login_btn.class);
                intent.setAction("android.intent.action.MAIN");
                intent.putExtra("com.example.homework02.InputName1",editText_phones.getText().toString());
                intent.putExtra("com.example.homework02.InputName2",editText_numbers.getText().toString());
                intent.putExtra("com.example.homework02.InputName3",editText_passwords.getText().toString());
                startActivity(intent);
            }
        });
    }

    protected void onStart(){
        super.onStart();
        Log.d("main", "---onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d("main", "---onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d("main", "---onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d("main", "---onStop");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d("main", "---onRestart");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("main", "---onDestroy");
    }
}