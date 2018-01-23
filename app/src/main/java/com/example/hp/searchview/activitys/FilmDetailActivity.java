package com.example.hp.searchview.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.searchview.R;
import com.example.hp.searchview.controllers.Common;
import com.example.hp.searchview.models.Film;
import com.squareup.picasso.Picasso;

public class FilmDetailActivity extends AppCompatActivity {
    private TextView tv_detail_name;
    private ImageView iv_detail_iamge;
    private TextView tv_detail_info;
    private TextView tv_detail_stars;
    private TextView tv_detail_creator;
    private ImageView iv_back;
    private ImageView iv_share;
    private int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);


        tv_detail_name = findViewById(R.id.tv_detail_name);
        iv_detail_iamge = findViewById(R.id.iv_detail_image);
        tv_detail_info = findViewById(R.id.tv_detail_info);
        tv_detail_stars = findViewById(R.id.tv_detail_stars);
        tv_detail_creator = findViewById(R.id.tv_detail_creator);
        iv_back = findViewById(R.id.iv_back);
        iv_share = findViewById(R.id.iv_share);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (getIntent() != null) {
            key = getIntent().getExtras().getInt("key", -1);
            if (key != -1) {
                loadData(key);
            }

        }

    }

    private void loadData(int key) {
        Film film = Common.filmList.get(key);
        tv_detail_name.setText(film.getName());
        tv_detail_info.setText(film.getInfo());
        tv_detail_stars.setText(film.getStars());
        tv_detail_creator.setText(film.getCreators());
        Picasso.with(getApplicationContext()).load(film.getFoto()).into(iv_detail_iamge);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
