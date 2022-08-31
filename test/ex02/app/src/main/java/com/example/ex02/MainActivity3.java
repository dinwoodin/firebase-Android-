package com.example.ex02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    EditText edit;
    ListView list;
    Spinner fruit;
    ImageView insert,delete;
    ArrayList<String> array=new ArrayList<>();
    ArrayList<String> farray=new ArrayList<>();

    String strFruit="";

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setTitle("연습3");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //데이터 생성
        array.add("유비");
        array.add("관우");
        array.add("장비");
        array.add("조조");

        //리시트뷰생성
        list=findViewById(R.id.list);

        //어댑터생성
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(
        this, android.R.layout.simple_list_item_single_choice, array);

        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //입력버튼을 클릭한 경우

        insert=findViewById(R.id.insert);
        edit=findViewById(R.id.edit);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=edit.getText().toString();
                array.add(strFruit);
                adapter.notifyDataSetChanged();
                edit.setText("");

                Toast.makeText(MainActivity3.this,strFruit+"이추가됩니다.",Toast.LENGTH_SHORT).show();

            }
        });

        delete=findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder box=new AlertDialog.Builder(MainActivity3.this);
                final int position=list.getCheckedItemPosition();
                System.out.println("po"+position);
                if(position==-1){

                    box.setTitle("경고");
                    box.setMessage("아이템을 선택바랍니다.");
                    box.setPositiveButton("닫기",null);
                    box.show();

                }else {
                   box.setTitle("삭제");
                   box.setMessage("삭제하실래요?");
                   box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           Toast.makeText(MainActivity3.this,"삭제",Toast.LENGTH_SHORT).show();
                           array.remove(position);
                           adapter.notifyDataSetChanged();

                       }
                   });
                   box.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           Toast.makeText(MainActivity3.this,"삭제취소",Toast.LENGTH_SHORT).show();
                       }
                   });
                   box.show();


                }

            }
        });
        //데이터생성
        farray.add("망고");
        farray.add("애플망고");
        farray.add("바나나");
        farray.add("피치");

        //어탭터생성
        ArrayAdapter<String> fAdapter=new ArrayAdapter<String>(
        MainActivity3.this, android.R.layout.simple_list_item_1,farray);

        fruit=findViewById(R.id.fruit);
        fruit.setAdapter(fAdapter);
        fruit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strFruit=farray.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}