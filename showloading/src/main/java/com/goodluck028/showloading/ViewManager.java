package com.goodluck028.showloading;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewManager {
    private final int TAG = 95279527;

    private ViewWrapper mViewWrapper;
    private View mContentView;
    //
    private String mErrorText;
    private String mButtonText;
    private View.OnClickListener mOnClickListener;


    public ViewManager(View view) {
        if(view != null) {
            mContentView = view;
            Object object = ((View)view.getParent()).getTag(TAG);
            if(object == null){
                object = view.getTag(TAG);
            }
            //
            if(object == null){
                mViewWrapper = new ViewWrapper(view);
                ((View)view.getParent()).setTag(TAG,mViewWrapper);
            }else {
                mViewWrapper = (ViewWrapper)object;
            }
        }
    }

    public ViewManager setOnRetryClickListener(View.OnClickListener listener) {
        mOnClickListener = listener;
        return this;
    }

    public ViewManager setRetryButtonText(String text) {
        mButtonText = text;
        return this;
    }

    public ViewManager setErrorText(String text) {
        mErrorText = text;
        return this;
    }

    public void showLoading() {
        if(mContentView == null) return;
        //
        mViewWrapper.showMask(new LoadingView(mContentView.getContext()));
    }

    public void showError() {
        if(mContentView == null) return;
        //
        mViewWrapper.showMask(getErrorView(mContentView.getContext()));
    }

    private View getErrorView(Context context){
        View view =  View.inflate(context,R.layout.view_error_view,null);
        TextView tv = view.findViewById(R.id.tv_error);
        Button btn = view.findViewById(R.id.btn_retry);
        if(context.getResources().getConfiguration().locale.getLanguage().equals("zh")){
            tv.setText("出错拉！\n\n检查一下网络或服务器吧！");
            btn.setText("重试");
        }
        //
        if(mErrorText != null) {
            tv.setText(mErrorText);
        }
        if(mButtonText != null){
            btn.setText(mButtonText);
        }
        if(mOnClickListener != null){
            btn.setOnClickListener(mOnClickListener);
            btn.setVisibility(View.VISIBLE);
        }
        //
        return view;
    }

    public void dismiss() {
        if(mContentView == null) return;
        //
        mViewWrapper.showContent();
    }

    public void showView(View view) {
        if(mContentView == null) return;
        //
        mViewWrapper.showMask(view);
    }
}
