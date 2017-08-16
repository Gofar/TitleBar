# TitleBar
自定义标题居中的ToolBar，也可以将自定义View添加到ToolBar的左边、中间、右边。

## 使用
可以将TitleBar.java复制到自己的项目中，或者直接在build.gradle中依赖：
```
compile 'com.gofar.titlebar:library:1.0.0'
```

## Simple Code

在xml直接使用：
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

在代码中应用：
```java
public class CenterTitleActivity extends AppCompatActivity {

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
}
```
## 效果图

![image](https://github.com/Gofar/TitleBar/blob/master/screenshots/device-2017-05-12-154136.png)
![image](https://github.com/Gofar/TitleBar/blob/master/screenshots/device-2017-05-12-161217.png)
![image](https://github.com/Gofar/TitleBar/blob/master/screenshots/device-2017-05-12-161249.png)
![image](https://github.com/Gofar/TitleBar/blob/master/screenshots/device-2017-05-12-161311.png)

## 详细介绍
详细情况看[博客](https://gofar.github.io/2017/08/09/Title-centered-ToolBar/)介绍。
## License
```
    Copyright (C) 2017 Gofar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```
