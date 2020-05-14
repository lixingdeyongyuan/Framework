package com.aixue.framework;


import com.aixue.framework.log.ILogCallBack;
import com.aixue.framework.log.LogProxy;

public class FrameworkBuilder {

    public static class SingletonHolder {
        private static FrameworkBuilder sFrameworkBuilder = new FrameworkBuilder();
    }

    public static FrameworkBuilder getInstance() {
        return FrameworkBuilder.SingletonHolder.sFrameworkBuilder;
    }

    public FrameworkBuilder init(ILogCallBack iLogCallBack) {
        LogProxy.getInstance().setILogCallBack(iLogCallBack);
        return this;
    }
}
