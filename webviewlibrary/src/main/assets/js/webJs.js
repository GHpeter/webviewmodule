var webJs = {};
webJs.os = {};
webJs.os.isIOS = /iOS|iPhone|iPad|iPod/i.test(navigator.userAgent);
webJs.os.isAndroid = !webJs.os.isIOS;
webJs.callbacks = {}

webJs.callback = function (callbackname, response) {
   var callbackobject = webJs.callbacks[callbackname];
   console.log("xxxx"+callbackname);
   if (callbackobject !== undefined){
       if(callbackobject.callback != undefined){
          console.log("xxxxxx"+response);
            var ret = callbackobject.callback(response);
           if(ret === false){
               return
           }
           delete webJs.callbacks[callbackname];
       }
   }
}

webJs.takeNativeAction = function(commandname, parameters){
    console.log("webJs takenativeaction")
    var request = {};
    request.name = commandname;
    request.param = parameters;
    if(window.webJs.os.isAndroid){
        console.log("android take native action" + JSON.stringify(request));
        window.MyWebView.takeNativeAction(JSON.stringify(request));
    } else {
        window.webkit.messageHandlers.MyWebView.postMessage(JSON.stringify(request))
    }
}

webJs.takeNativeActionWithCallback = function(commandname, parameters, callback) {
    var callbackname = "nativetojs_callback_" +  (new Date()).getTime() + "_" + Math.floor(Math.random() * 10000);
    webJs.callbacks[callbackname] = {callback:callback};

    var request = {};
    request.name = commandname;
    request.param = parameters;
    request.param.callbackname = callbackname;
    if(window.webJs.os.isAndroid){
        window.MyWebView.takeNativeAction(JSON.stringify(request));
    } else {
        window.webkit.messageHandlers.MyWebView.postMessage(JSON.stringify(request))
    }
}

window.webJs = webJs;
