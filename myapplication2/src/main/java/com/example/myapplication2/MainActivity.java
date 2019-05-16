package com.example.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.String;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Ev1_pwd, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置内容UI，把页面加载出来
        setContentView(R.layout.activity_main);
        //找到界面上的按钮
        Ev1_pwd = (EditText) findViewById(R.id.pswdtext);
        name = (EditText) findViewById(R.id.nametext);
        String pswd = "123";
        Button bt_click = (Button) findViewById(R.id.button_1);
        bt_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("click", "login!");
//                Log.e("")
                boolean flag = true;
                //boolean flag = Data.db.checkUser(name.getText().toString(), Ev1_pwd.getText().toString());
                if (flag) {
                    String nameStr = name.getText().toString();
                    Data.username = nameStr;
                    Data.pwd = Ev1_pwd.getText().toString();
                    startActivity(new Intent(MainActivity.this,mainpage.class));
                    //Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Password Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}

