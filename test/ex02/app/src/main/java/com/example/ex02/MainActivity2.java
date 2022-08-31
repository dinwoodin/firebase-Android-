package com.example.ex02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<MovieVO> array=new ArrayList<>();
    ListView list;
    MovieVO vo=new MovieVO();

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
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setTitle("연습2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//  데이터생성
        vo=new MovieVO();
        vo.setImage(R.drawable.n1);
        vo.setTitle("불릿 트레인");
        vo.setRi("브레드피트");
        array.add(vo);

        vo=new MovieVO();
        vo.setImage(R.drawable.n2);
        vo.setTitle("탑건");
        vo.setRi("톰크루즈");
        array.add(vo);

        vo=new MovieVO();
        vo.setImage(R.drawable.n3);
        vo.setTitle("육지오");
        vo.setRi("군인");
        array.add(vo);

        vo=new MovieVO();
        vo.setImage(R.drawable.n4);
        vo.setTitle("헌트");
        vo.setRi("이정재 , 정우성");
        array.add(vo);

        vo=new MovieVO();
        vo.setImage(R.drawable.n5);
        vo.setTitle("놉");
        vo.setRi("조나단");
        array.add(vo);

        vo=new MovieVO();
        vo.setImage(R.drawable.n1);
        vo.setTitle("불릿 트레인");
        vo.setRi("브레드피트");
        array.add(vo);

        vo=new MovieVO();
        vo.setImage(R.drawable.n2);
        vo.setTitle("탑건");
        vo.setRi("톰크루즈");
        array.add(vo);

        vo=new MovieVO();
        vo.setImage(R.drawable.n3);
        vo.setTitle("육지오");
        vo.setRi("군인");
        array.add(vo);

        vo=new MovieVO();
        vo.setImage(R.drawable.n4);
        vo.setTitle("헌트");
        vo.setRi("이정재 , 정우성");
        array.add(vo);

        vo=new MovieVO();
        vo.setImage(R.drawable.n5);
        vo.setTitle("놉");
        vo.setRi("조나단");
        array.add(vo);


        //리스트뷰 생성
        list = findViewById(R.id.list);
        //어댑터생
        MovieAdapter adapter=new MovieAdapter();
        list.setAdapter(adapter);

    }
    //어탭터 정의

    class MovieAdapter extends BaseAdapter{

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
        public View getView(int i, View view, ViewGroup viewGroup) {

            view=getLayoutInflater().inflate(R.layout.itme_movie,viewGroup,false);
            MovieVO vo= array.get(i);//데이터의 갯수 반복,
            ImageView image=view.findViewById(R.id.image);
            image.setImageResource(vo.getImage());

            TextView title=view.findViewById(R.id.title);
            title.setText(vo.getTitle());

            TextView ri=view.findViewById(R.id.ri);
            ri.setText(vo.getRi());



            return view;
        }


    }

}