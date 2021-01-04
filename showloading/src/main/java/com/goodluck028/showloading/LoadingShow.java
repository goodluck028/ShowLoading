package com.goodluck028.showloading;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.fragment.app.Fragment;

public class LoadingShow {

    /**
     * get the activity loading shower
     *
     * @param activity
     * @return
     */
    public static ViewManager with(AppCompatActivity activity) {
        ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup contentRoot = (ViewGroup) decor.getChildAt(0);
        ViewGroup bar = (ViewGroup) contentRoot.getChildAt(1);
        ActionBarOverlayLayout act = (ActionBarOverlayLayout) bar.getChildAt(0);
        View content = null;
        try {
            content = ((FrameLayout) Reflector.getValue(act, "mContent")).getChildAt(0);
        } catch (Exception ex) {
        }
        return new ViewManager(content);
    }

    /**
     * get the fragment loading shower
     *
     * @param fragment
     * @return
     */
    public static ViewManager with(Fragment fragment) {
        return new ViewManager(fragment.getView());
    }

    /**
     * get the view loading shower
     *
     * @param view
     * @return
     */
    public static ViewManager with(View view) {
        return new ViewManager(view);
    }
}
