// ICallbackFromMainprocessToWebViewProcessInterface.aidl
package com.cliff.webview;

interface ICallbackFromMainprocessToWebViewProcessInterface {
    void onResult(String callbackname, String response);
}
