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
在fragment的onCreateView方法中使用会无效，是由于fragment的加载机制引起的，后续版本想办法解决。

## License
MIT