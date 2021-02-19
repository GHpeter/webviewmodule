package com.cliff.webviewlibrary;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.cliff.common.autoservice.IWebViewService;
import com.cliff.webviewlibrary.utils.Constants;
import com.google.auto.service.AutoService;

@AutoService(IWebViewService.class)
public class WebViewServiceImpl implements  IWebViewService {
    @Override
    public void startWebViewActivity(Context context, String url, String title,boolean isShowActonBar) {
        if (context!=null){
            Intent intent=new Intent(context,WebViewActivity.class);
            intent.putExtra(Constants.TITLE,title);
            intent.putExtra(Constants.URL,url);
            intent.putExtra(Constants.IS_SHOW_ACTION_BAR,isShowActonBar);
            context.startActivity(intent);
        }
    }

    @Override
    public Fragment getWebviewFragment(String url,boolean canNativeRefresh) {
        return WebViewFragment.newInstance(url,canNativeRefresh);
    }

    @Override
    public void startDemoHtml(Context context) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(Constants.TITLE, "本地Demo测试页");
        intent.putExtra(Constants.URL, Constants.ANDROID_ASSET_URI + "demo.html");
        context.startActivity(intent);
    }
}
