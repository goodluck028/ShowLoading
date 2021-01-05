---
# ShowLoading
-------------

### 下载安装
Gradle:
```groovy
implementation 'com.github.goodluck028:ShowLoading:1.0.0'
```

### 使用方法
```java
//activity
LoadingShow.with(MainActivity.this).showLoading();
LoadingShow.with(MainActivity.this).dismiss();
//fragment
LoadingShow.with(TestFragment.this).showLoading();
LoadingShow.with(TestFragment.this).dismiss();
//view
TextView testView = findViewById(R.id.tv_test_view);
LoadingShow.with(testView).showLoading();
LoadingShow.with(testView).dismiss();
```

### 注意事项
在fragment的onCreateView()方法中使用会无效，是由于fragment的加载机制引起的，建议在onResume()方法中使用，后续版本想办法解决。

### 关于我
来自成都的苦逼程序员一枚，样样懂、门门瘟，喜欢金融、喜欢计算机。有bug加我QQ459057268。

## License
MIT