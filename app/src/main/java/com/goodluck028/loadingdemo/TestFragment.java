package com.goodluck028.loadingdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.goodluck028.showloading.LoadingShow;

public class TestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test,container,false);
        view.findViewById(R.id.btn_text_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingShow.with(TestFragment.this).showLoading();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10000);
                        }catch (Exception ex){}
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LoadingShow.with(TestFragment.this).dismiss();
                            }
                        });
                    }
                }).start();
            }
        });
        return view;
    }

}
