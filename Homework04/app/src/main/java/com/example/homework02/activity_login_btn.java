package com.example.homework02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_login_btn extends AppCompatActivity {

    private Button button1s;
    private Button button2s;
    private Button button3s;
    private TextView textView_phones;
    private TextView textView_numbers;
    private TextView textView_passwords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_btn);

        button1s = (Button) findViewById(R.id.button1);
        button2s = (Button) findViewById(R.id.button2);
        button3s = (Button) findViewById(R.id.button3);
        textView_phones = (TextView) findViewById(R.id.textView_phone);
        textView_numbers = (TextView) findViewById(R.id.textView_number);
        textView_passwords = (TextView) findViewById(R.id.textView_password);

        Intent intent0 = getIntent();
        String inputName1 = intent0.getStringExtra("com.example.homework02.InputName1");
        String inputName2 = intent0.getStringExtra("com.example.homework02.InputName2");
        String inputName3 = intent0.getStringExtra("com.example.homework02.InputName3");

        textView_phones.setText(inputName1);
        textView_numbers.setText(inputName2);
        textView_passwords.setText(inputName3);

        button1s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setAction("android.intent.action.VIEW");
                intent1.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent1);
            }
        });

        button2s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = getPackageManager().getLaunchIntentForPackage("tv.danmaku.bili");
                startActivity(intent2);
            }
        });

        button3s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = getPackageManager().getLaunchIntentForPackage("com.netease.cloudmusic");
                startActivity(intent3);
            }
        });
    }


}