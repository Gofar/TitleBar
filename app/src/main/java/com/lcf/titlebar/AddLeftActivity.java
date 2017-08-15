package com.lcf.titlebar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.gofar.titlebar.TitleBar;

/**
 * Author: lcf
 * Description:往左边添加自定义View
 * Since: 1.0
 * Date: 2017/5/11 17:46
 */
public class AddLeftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        setSupportActionBar(mTitleBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitleBar.setCenterTitle("Title");

        View view = LayoutInflater.from(this).inflate(R.layout.view_text, null);
        mTitleBar.addLeftView(view);
    }
}
