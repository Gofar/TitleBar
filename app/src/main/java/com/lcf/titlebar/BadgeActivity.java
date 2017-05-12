package com.lcf.titlebar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.lcf.titlebar.widget.BadgeView;
import com.lcf.titlebar.widget.TitleBar;

/**
 * Author: lcf
 * Description:右边添加自定义view，使用BadgeView显示红点
 * Since: 1.0
 * Date: 2017/5/11 17:55
 */
public class BadgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);
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

        View view = LayoutInflater.from(this).inflate(R.layout.view_image, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
        BadgeView badgeView2 = new BadgeView(this);
        badgeView2.setTargetView(imageView);
        badgeView2.setBadgeCount(1);
        badgeView2.setBadgeGravity(Gravity.RIGHT | Gravity.TOP);

        mTitleBar.addRightView(view);

    }
}
