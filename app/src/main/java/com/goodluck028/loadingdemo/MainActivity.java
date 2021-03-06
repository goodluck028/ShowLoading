package com.goodluck028.loadingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.TextView;

import com.goodluck028.showloading.LoadingShow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //activity
        findViewById(R.id.btn_text_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadingShow.with(MainActivity.this).showLoading();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10000);
                        }catch (Exception ex){}
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LoadingShow.with(MainActivity.this)
                                        .setErrorText("oops! something wrong")
                                        .setRetryButtonText("retry")
                                        .setOnRetryClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                findViewById(R.id.btn_text_activity).performClick();
                                            }
                                        })
                                        .showError();
                            }
                        });
                    }
                }).start();
            }
        });
        //view
        final TextView testView = findViewById(R.id.tv_test_view);
        testView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadingShow.with(testView).showLoading();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10000);
                        }catch (Exception ex){}
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LoadingShow.with(testView).showError();
                            }
                        });
                    }
                }).start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.lyt_test,new TestFragment());
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }
}
