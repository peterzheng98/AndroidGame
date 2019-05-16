package com.example.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class search extends AppCompatActivity {

    EditText searchcontent;
    Button bt_s;
    TextView searchresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchcontent = (EditText) findViewById(R.id.search_text);
        bt_s=(Button)findViewById(R.id.search);
        searchresult=(TextView)findViewById(R.id.search_result);
        bt_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            String con=searchcontent.getText().toString();
            boolean flag=con.equals("banana");
            if (flag) searchresult.setText("chuyutrash");
            }
        });
    }


}
