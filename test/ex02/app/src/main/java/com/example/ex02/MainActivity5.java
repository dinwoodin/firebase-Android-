package com.example.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().setTitle("매뉴");
    }

    public void mClick(View v){
        Intent intent=new Intent();

        switch (v.getId()){
            case R.id.test1:
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.test2:
                intent=new Intent(this,MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.test3:
                intent=new Intent(this,MainActivity3.class);
                startActivity(intent);
                break;
            case R.id.test4:
                intent=new Intent(this,MainActivity4.class);
                startActivity(intent);
                break;
        }
    }
}