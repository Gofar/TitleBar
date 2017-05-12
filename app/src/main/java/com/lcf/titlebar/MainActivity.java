package com.lcf.titlebar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Author: lcf
 * Description:
 * Since: 1.0
 * Date: 2017/5/11 17:14
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(this, CenterTitleActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, AddMenuActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, AddRightActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, AddLeftActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this, BadgeActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(this, NewMenuActivity.class));
                break;
        }
    }
}
