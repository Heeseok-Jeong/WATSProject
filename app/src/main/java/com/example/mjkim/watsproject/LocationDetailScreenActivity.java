package com.example.mjkim.watsproject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mjkim.watsproject.Naver.NaverBlogAdapter;
import com.example.mjkim.watsproject.Naver.NaverBlogList;
import com.example.mjkim.watsproject.Naver.NaverBlogSearch;

import java.util.ArrayList;

public class LocationDetailScreenActivity extends AppCompatActivity {

    Dialog myDialog;
    private String blogName;
    public static ArrayList<NaverBlogList> blogList;
    private NaverBlogSearch naverBlogSearch;
    private NaverBlogAdapter naverBlogAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_detail_screen);

        myDialog = new Dialog(this); //회원가입 팝업 변수 선언
        Intent intent = getIntent();
        blogList = new ArrayList<NaverBlogList>();
        naverBlogSearch = new NaverBlogSearch();

        TextView locationName = (TextView)findViewById(R.id.location_name); //장소 이름
        TextView locationCategory = (TextView)findViewById(R.id.location_category); //장소 분류
        TextView locationAddress = (TextView)findViewById(R.id.location_address); //장소 주소
        TextView locationNumber = (TextView)findViewById(R.id.phone_number); //장소 번호

        ImageView tag1 = (ImageView)findViewById(R.id.tag_done_1); //태그 이미지 선언
        ImageView tag2 = (ImageView)findViewById(R.id.tag_done_2);
        ImageView tag3 = (ImageView)findViewById(R.id.tag_done_3);
        ImageView tag4 = (ImageView)findViewById(R.id.tag_done_4);
        ImageView tag5 = (ImageView)findViewById(R.id.tag_done_5);
        ImageView tag6 = (ImageView)findViewById(R.id.tag_done_6);

        tag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //태그1 눌렀을때 정보 팝업창 띄우기

                myDialog.setContentView(R.layout.tag_restroom_popup);
                Button closeButton = (Button) myDialog.findViewById(R.id.ok_button);

                //닫기 버튼을 눌렀을때
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { myDialog.dismiss(); }});

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                myDialog.show();
            }
        });

        tag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //태그2 눌렀을때 정보 팝업창 띄우기

                myDialog.setContentView(R.layout.tag_parking_popup);
                Button closeButton = (Button) myDialog.findViewById(R.id.ok_button);

                //닫기 버튼을 눌렀을때
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { myDialog.dismiss(); }});

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                myDialog.show();
            }
        });

        tag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //태그3 눌렀을때 정보 팝업창 띄우기

                myDialog.setContentView(R.layout.tag_elevator_popup);
                Button closeButton = (Button) myDialog.findViewById(R.id.ok_button);

                //닫기 버튼을 눌렀을때
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { myDialog.dismiss(); }});

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                myDialog.show();
            }
        });

        tag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDialog.setContentView(R.layout.tag_slope_popup);
                Button closeButton = (Button) myDialog.findViewById(R.id.ok_button);

                //닫기 버튼을 눌렀을때
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { myDialog.dismiss(); }});

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                myDialog.show();
            }
        });

        tag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //태그5 눌렀을때 정보 팝업창 띄우기

                myDialog.setContentView(R.layout.tag_table_popup);
                Button closeButton = (Button) myDialog.findViewById(R.id.ok_button);

                //닫기 버튼을 눌렀을때
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { myDialog.dismiss(); }});

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                myDialog.show();
            }
        });

        tag6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //태그6 눌렀을때 정보 팝업창 띄우기

                myDialog.setContentView(R.layout.tag_assistant_popup);
                Button closeButton = (Button) myDialog.findViewById(R.id.ok_button);

                //닫기 버튼을 눌렀을때
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { myDialog.dismiss(); }});

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                myDialog.show();
            }
        });





        //장소 정보 화면 출력
        final String location_name, location_category, location_addess, location_number;
        final Integer location_x, location_y;

        location_name = getIntent().getExtras().getString("NAME");
        location_category = getIntent().getExtras().getString("CATEGORY");
        location_addess = getIntent().getExtras().getString("ADDRESS");
        location_number = getIntent().getExtras().getString("TELEPHONE");
        location_x = getIntent().getExtras().getInt("MAPX");
        location_y = getIntent().getExtras().getInt("MAPY");

        locationName.setText(location_name);
        locationCategory.setText(location_category);
        locationAddress.setText(location_addess);
        locationNumber.setText(location_number);

        //전화번호 눌렀을때 통화 기능
        locationNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getIntent().getExtras().getString("TELEPHONE")));
                startActivity(intent1);
            }
        });



        Button backButton = (Button)findViewById(R.id.back_button);
        Button createReviewButton = (Button)findViewById(R.id.c_review_button);

        //돌아가기 버튼 눌렀을때 전 화면을 돌아간다
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //후기 작성하기 버튼을 눌렀을때 후기 작성 페이지로 이동
        createReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LocationDetailScreenActivity.this,CreateReviewScreenActivity.class);
                intent.putExtra("NAME", location_name);
                intent.putExtra("CATEGORY", location_category);
                intent.putExtra("ADDRESS", location_addess);
                intent.putExtra("TELEPHONE", location_number);
                intent.putExtra("MAPX", location_x);
                intent.putExtra("MAPY", location_y);
                startActivity(intent);
            }
        });


        //블로그 리스트 출력
        try {
            blogList = naverBlogSearch.execute(intent.getExtras().getString("NAME")).get();
        }catch (Exception e){
            e.printStackTrace();
        }

        NaverBlogAdapter.select = 1;

        ListView blogListView = (ListView) findViewById(R.id.blog_list);


        // 동적으로 리스트뷰 높이 할당
        if(blogList.size() == 0) {
            blogListView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50));
        }
        else if(blogList.size() == 1) {
            blogListView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 250));
        }
        else if(blogList.size() == 2) {
            blogListView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 500));
        }

        naverBlogAdapter = new NaverBlogAdapter(LocationDetailScreenActivity.this, blogList);
        blogListView.setAdapter(naverBlogAdapter);


        //블로그 전체보기 버튼
        Button more_blog = (Button)findViewById(R.id.see_more_blog);
        more_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openBlogTab();}

        });


    }


    //블로 전체보기 버튼 기능
    public void openBlogTab(){
        Intent intent = new Intent(this, MoreBlogScreenActivity.class);
        startActivity(intent);
    }
}