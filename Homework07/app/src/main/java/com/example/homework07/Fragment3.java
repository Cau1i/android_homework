package com.example.homework07;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework07.R;

import java.security.PrivateKey;

public class Fragment3 extends Fragment {
    public Fragment3() {
        super(R.layout.fragment3);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button loginButton = getView().findViewById(R.id.loginButton);
        EditText numEditText = getView().findViewById(R.id.numEditText);
        EditText passEditText = getView().findViewById(R.id.passEditText);

        //读取
        SharedPreferences settings = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        String id = settings.getString("ID", "");
        String password = settings.getString("PASSWORD", "");
        numEditText.setText(id);
        passEditText.setText(password);

        //登录按钮
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //写入
                SharedPreferences settings1 = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings1.edit();
                editor.putString("ID", numEditText.getText().toString());
                editor.putString("PASSWORD", passEditText.getText().toString());
                editor.commit();
                Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
