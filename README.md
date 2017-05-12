# TitleBar
自定义标题居中的ToolBar，也可以将自定义View添加到ToolBar的左边、中间、右边

## 使用
可以将TitleBar.java复制到自己的项目中

## Simple Code

在xml直接使用
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <com.lcf.titlebar.widget.TitleBar
        android:id="@+id/title_bar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        app:popupTheme="@style/AppTheme.PopupOverlay"
        app:theme="@style/ToolBarTheme" />

    <FrameLayout
        android:id="@+id/content"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```

在代码中应用
```java
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
    }
```
效果图


## 详细介绍