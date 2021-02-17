package com.cliff.webviewlibrary;

import android.content.Context;
import android.content.Intent;

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
            intent.putExtra(Constants.ISSHOWACTONBAR,isShowActonBar);
            context.startActivity(intent);
        }
    }
}
