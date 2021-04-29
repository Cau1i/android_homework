package com.example.homework07;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework07.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fragment2 extends Fragment {

    public Fragment2() {
        super(R.layout.fragment2);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //写入外部存储
        Button writeExternalButton = getView().findViewById(R.id.writeExternalButton);
        writeExternalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File externalPath = getActivity().getExternalFilesDir(null);
                File file = new File(externalPath, "写入外部存储");
                try {
                    FileOutputStream os = new FileOutputStream(file);
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
                    writer.write("Tom");
                    writer.close();
                    Toast.makeText(getActivity(), "写入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //读取外部存储
        Button readExternalButton = getView().findViewById(R.id.readExternalButton);
        readExternalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File externalPath = getActivity().getExternalFilesDir(null);
                File file = new File(externalPath, "读取外部存储");
                try {
                    FileInputStream is = new FileInputStream(file);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line = reader.readLine();
                    Toast.makeText(getActivity(), line, Toast.LENGTH_SHORT).show();
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
