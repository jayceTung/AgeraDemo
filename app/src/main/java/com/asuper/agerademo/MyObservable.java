package com.asuper.agerademo;

import com.google.android.agera.BaseObservable;

/**
 * Created by Joker on 2016/8/2.
 */
public class MyObservable extends BaseObservable {
    private StringBuffer mContent = new StringBuffer();

    public StringBuffer getContent() {
        return mContent;
    }

    public void setContent(String str) {
        this.mContent.append(str);
        update();
    }

    private void update() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mContent.append("update");
                dispatchUpdate();
            }
        }).start();
    }
}
