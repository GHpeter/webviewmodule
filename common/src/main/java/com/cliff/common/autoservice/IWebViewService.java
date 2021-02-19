package com.cliff.common.autoservice;

import android.content.Context;

import androidx.fragment.app.Fragment;

public interface IWebViewService {
    void  startWebViewActivity(Context context,String url, String title,boolean isShowActonBar);
     Fragment getWebviewFragment(String url,boolean canNativeRefresh);

    void startDemoHtml(Context context);

}
