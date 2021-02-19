package com.cliff.webviewlibrary.webviewprocess;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;


import androidx.annotation.RequiresApi;

import com.cliff.webviewlibrary.WebViewCallBack;
import com.cliff.webviewlibrary.webviewprocess.bean.JsParam;
import com.cliff.webviewlibrary.webviewprocess.setting.WebViewDefaultSettings;
import com.cliff.webviewlibrary.webviewprocess.webchromeclient.MyWebChromeClient;
import com.cliff.webviewlibrary.webviewprocess.webviewClient.MyWebViewClient;
import com.google.gson.Gson;

public class BaseWebView extends WebView {
    public static final String TAG = "BaseWebView";

    public BaseWebView(Context context) {
        super(context);
        init();
    }

    public BaseWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {

        WebViewDefaultSettings.getInstance().setSettings(this);
        addJavascriptInterface(this, "MyWebView");
    }

    public void registerWebViewCallBack(WebViewCallBack webViewCallBack) {
        setWebViewClient(new MyWebViewClient(webViewCallBack));
        setWebChromeClient(new MyWebChromeClient(webViewCallBack));
    }

    @JavascriptInterface
    public void takeNativeAction(final String jsParam) {
        Log.i(TAG, jsParam);
        if (!TextUtils.isEmpty(jsParam)) {
            final JsParam jsParamObject = new Gson().fromJson(jsParam, JsParam.class);
            if (jsParamObject != null) {
                WebViewProcessCommandDispatcher.getInstance().executeCommand(jsParamObject.name, new Gson().toJson(jsParamObject.param), this);
            }
        }
    }

    public void handleCallback(final String callbackname, final String response){

    }
}