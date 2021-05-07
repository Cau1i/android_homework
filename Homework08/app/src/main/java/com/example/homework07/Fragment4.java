package com.example.homework07;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Fragment4 extends Fragment {

    private Button btn_add, btn_age;
    private EditText et_name, et_age;
    private TextView contentTextView;
    SQLiteDatabase db;
    DbHelper dbHelper;

    public Fragment4() {
        super(R.layout.fragment4);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_add = getView().findViewById(R.id.btn_add);
        btn_age = getView().findViewById(R.id.btn_age);
        et_name = getView().findViewById(R.id.et_name);
        et_age = getView().findViewById(R.id.et_age);
        contentTextView = getView().findViewById(R.id.contentTextView);
        dbHelper = new DbHelper(getContext());

        //查询所有内容
        db = dbHelper.getReadableDatabase();
        StringBuilder stringBuilder = new StringBuilder();
        Cursor cursor = db.query("users", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex("id"));
            String username = cursor.getString(cursor.getColumnIndex("username"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            stringBuilder.append("id：").append(id)
                    .append("   username：").append(username)
                    .append("   age：").append(age).append("\n");
        }
        contentTextView.setText(stringBuilder.toString());

        //添加按钮
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_name.getText().toString();
                int age = Integer.parseInt(et_age.getText().toString());
                db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("username", username);
                values.put("age", age);
                //Toast.makeText(getContext(), username + age, Toast.LENGTH_SHORT).show();
                long ret = db.insert("users", null, values);
                String msg = ret == -1 ? "添加失败！" : "添加成功！";
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                db.close();
            }
        });

        //查询年龄小于18岁的按钮
        btn_age.setOnClickListener(new View.OnClickListener() {
            private String selection = "age<18";

            @Override
            public void onClick(View v) {
                db = dbHelper.getReadableDatabase();
                StringBuilder stringBuilder = new StringBuilder();
                Cursor cursor = db.query("users", null, selection, null, null, null, null);
                while (cursor.moveToNext()) {
                    long id = cursor.getLong(cursor.getColumnIndex("id"));
                    String username = cursor.getString(cursor.getColumnIndex("username"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    stringBuilder.append("id：").append(id)
                            .append("   username：").append(username)
                            .append("   age：").append(age).append("\n");
                }
                contentTextView.setText(stringBuilder.toString());
            }
        });
    }
}
