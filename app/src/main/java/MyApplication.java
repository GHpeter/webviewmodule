import com.kingja.loadsir.core.LoadSir;

import loadsir.CustomCallback;
import loadsir.EmptyCallback;
import loadsir.ErrorCallback;
import loadsir.LoadingCallback;
import loadsir.TimeoutCallback;


public class MyApplication extends BaseApplication {

    @Override
    public void onCreate(){
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
