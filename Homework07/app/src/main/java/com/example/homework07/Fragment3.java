package com.example.homework07;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
        if ((settings.getString("ID", "") != null) && (settings.getString("PASSWORD", "") != null)) {
            String id = settings.getString("ID", "");
            String password = settings.getString("PASSWORD", "");
            numEditText.setText(id);
            passEditText.setText(password);
        }

        //登录按钮
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //写入
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("ID", numEditText.getText().toString());
                String sha = null;
                try {
                    sha = computeHash(passEditText.getText().toString());
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                editor.putString("PASSWORD", sha);
                editor.commit();
                Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String computeHash(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();

        byte[] byteData = digest.digest(input.getBytes("UTF-8"));
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
