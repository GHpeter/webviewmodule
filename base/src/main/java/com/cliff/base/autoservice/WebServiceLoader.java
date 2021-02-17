package com.cliff.base.autoservice;

import java.util.ServiceLoader;

public final class WebServiceLoader {
    private  WebServiceLoader(){

    }
    public  static <S>  S load(Class<S> service){
        try{
            return ServiceLoader.load(service).iterator().next();
        }catch (Exception e){
            return  null;
        }
    }
}
