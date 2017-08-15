package com.lcf.titlebar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

import com.gofar.titlebar.TitleBar;

/**
 * Author: lcf
 * Description:右边添加自定义view,menu也显示自定义view
 * Since: 1.0
 * Date: 2017/5/11 17:30
 */
public class AddRightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_view);

        TitleBar mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        setSupportActionBar(mTitleBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitleBar.setCenterTitle("Title");
        mTitleBar.setNavigationIcon(R.drawable.ic_action_back);
        mTitleBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        View view = LayoutInflater.from(this).inflate(R.layout.view_right, null);
        mTitleBar.addRightView(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_right, menu);
        return true;
    }

}
