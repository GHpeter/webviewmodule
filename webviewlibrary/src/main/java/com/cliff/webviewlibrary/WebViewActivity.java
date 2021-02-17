package com.cliff.webviewlibrary;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cliff.webviewlibrary.databinding.ActWebviewBinding;
import com.cliff.webviewlibrary.utils.Constants;

public class WebViewActivity extends AppCompatActivity {
    private ActWebviewBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.act_webview);

        mBinding.llShowActionBar.setVisibility(getIntent().getBooleanExtra(Constants.ISSHOWACTONBAR,true)?View.VISIBLE:View.GONE);
        mBinding.webview.getSettings().setJavaScriptEnabled(true);
        mBinding.webview.loadUrl(getIntent().getStringExtra(Constants.URL));
    }
}
