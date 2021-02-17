package com.cliff.webviewmodule;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cliff.base.autoservice.WebServiceLoader;
import com.cliff.common.autoservice.IWebViewService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_webview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //迭代器
                IWebViewService iWebViewService = WebServiceLoader.load(IWebViewService.class);
                if (iWebViewService!=null){
                    iWebViewService.startWebViewActivity(MainActivity.this,"https://www.baidu.com","百度",false);
                }
            }
        });
    }
}