package com.canarabank2.nonofbusiness3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class LastActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_layout);
        ImageView loader = findViewById(R.id.loading);
        int id = getIntent().getIntExtra("id", -1);
        TextView loadTextView = findViewById(R.id.loadertext);
        loadTextView.setText("Request Id : "+ id);

        Glide.with(this)
                .asGif()
                .load(R.drawable.loader)
                .into(loader);
    }

}