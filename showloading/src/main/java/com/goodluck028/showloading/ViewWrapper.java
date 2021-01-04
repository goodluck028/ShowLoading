package com.goodluck028.showloading;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class ViewWrapper {
    private FrameLayout mFrameLayout;
    private View mContentView;
    private View mMaskView;

    public ViewWrapper(View contentView) {
        mContentView = contentView;
        //替换framelayout
        mFrameLayout = new FrameLayout(mContentView.getContext());
        mFrameLayout.setLayoutParams(mContentView.getLayoutParams());
        ViewGroup parent = (ViewGroup) mContentView.getParent();
        for (int i = 0; i < parent.getChildCount(); i++) {
            if (parent.getChildAt(i) == contentView) {
                parent.removeView(mContentView);
                parent.addView(mFrameLayout, i);
                break;
            }
        }
        //注入用户view
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        mContentView.setLayoutParams(lp);
        mFrameLayout.addView(mContentView);
    }

    public void showMask(View view) {
        mContentView.setVisibility(View.INVISIBLE);
        //
        if (mMaskView != null) {
            mFrameLayout.removeView(mMaskView);
        }
        //
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(lp);
        mFrameLayout.addView(view);
        mMaskView = view;
    }

    public void showContent() {
        if (mMaskView != null) {
            mFrameLayout.removeView(mMaskView);
        }
        mContentView.setVisibility(View.VISIBLE);
    }
}
