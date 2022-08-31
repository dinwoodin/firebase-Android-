package com.example.ex02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
ArrayList<AddressVO> array=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Spinner spinner=findViewById(R.id.fruit);
        spinner.setVisibility(View.INVISIBLE);

        AddressVO vo = new AddressVO("홍길동","010-1111-2222","인천 서구 청라");
        array.add(vo);

        vo = new AddressVO("이순신","010-1111-3333","전라 도구 라라");
        array.add(vo);

        vo = new AddressVO("몽룡","010-1111-444","서울 서초 리라");
        array.add(vo);


        ListView list=findViewById(R.id.list);


        Adpter adpter=new Adpter();
        list.setAdapter(adpter);

        ImageView insert=findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LinearLayout layout=(LinearLayout) View.inflate(MainActivity4.this,R.layout.insert,null);

                AlertDialog.Builder box=new AlertDialog.Builder(MainActivity4.this);
                box.setTitle("주소등록");
                box.setView(layout);
                box.setPositiveButton("등록", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText name=layout.findViewById(R.id.name);
                        EditText tel=layout.findViewById(R.id.tel);
                        EditText add=layout.findViewById(R.id.add);
                        AddressVO vo = new AddressVO(
                                name.getText().toString(),
                                tel.getText().toString(),
                                add.getText().toString()
                        );
                        array.add(vo);
                        adpter.notifyDataSetChanged();
                    }
                });
                box.setNegativeButton("취소",null);
                box.show();
            }
        });
    }

    class Adpter extends BaseAdapter{

        @Override
        public int getCount() {
            return array.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView( final int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.item_address,viewGroup,false);

            AddressVO vo =array.get(i);
            TextView name=view.findViewById(R.id.name);
            name.setText(vo.getName());

            TextView tel=view.findViewById(R.id.tel);
            tel.setText(vo.getTel());

            TextView add=view.findViewById(R.id.add);
            add.setText(vo.getAdd());

            ImageView delete=view.findViewById(R.id.delete);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder box=new AlertDialog.Builder(MainActivity4.this);
                    box.setTitle("");

                    box.setMessage(i+"삭제하시겠습니까?");
                    box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int j) {
                            array.remove(i);
                            notifyDataSetChanged();
                        }
                    });
                    box.setNegativeButton("아니요",null);
                    box.show();
                }
            });
            return view;


        }
    }

}