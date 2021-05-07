package com.example.homework07;

import android.content.ContentValues;
import android.content.Context;
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
import androidx.room.Room;

import java.util.List;

public class Fragment5 extends Fragment {

    private Button btn_add1, btn_age1;
    private EditText et_name1, et_age1;
    private TextView contentTextView1;
    MyRoomDatabase db1;

    public Fragment5() {
        super(R.layout.fragment5);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_add1 = getView().findViewById(R.id.btn_add1);
        btn_age1 = getView().findViewById(R.id.btn_age1);
        et_name1 = getView().findViewById(R.id.et_name1);
        et_age1 = getView().findViewById(R.id.et_age1);
        contentTextView1 = getView().findViewById(R.id.contentTextView1);
        db1 = MyRoomDatabase.getInstance(getActivity());

        //查询所有内容
        showUsers(db1.userDao().getALL());

        //添加按钮
        btn_add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_name1.getText().toString();
                int age = Integer.parseInt(et_age1.getText().toString());
                Toast.makeText(getContext(), username + age, Toast.LENGTH_SHORT).show();
                User user = new User();
                user.username = username;
                user.age = age;
                db1.userDao().insert(user);
            }
        });

        //查询年龄小于18岁的按钮
        btn_age1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUsers(db1.userDao().searchUsersByAge(18));
            }
        });
    }

    //显示查询结果
    private void showUsers(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users) {
            stringBuilder.append("id：").append(user.id)
                    .append("    username：").append(user.username)
                    .append("    age：").append(user.age)
                    .append("\n");
        }
        contentTextView1.setText(stringBuilder.toString());
    }
}
