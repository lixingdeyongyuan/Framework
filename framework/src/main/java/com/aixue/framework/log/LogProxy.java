package com.aixue.framework.log;

import android.text.TextUtils;

/**
 * 网络日志代理类
 */
public class LogProxy implements ILogCallBack {

    private static final String TAG = "framework_lib";

    private ILogCallBack mILogCallBack = null;

    @Override
    public void debug(String tag, String msg) {
        if (mILogCallBack == null) {
            return;
        }
        mILogCallBack.debug(TextUtils.isEmpty(tag) ? TAG : tag, msg);
    }

    @Override
    public void info(String tag, String msg) {
        if (mILogCallBack == null) {
            return;
        }
        mILogCallBack.info(TextUtils.isEmpty(tag) ? TAG : tag, msg);
    }

    @Override
    public void error(String tag, String msg) {
        if (mILogCallBack == null) {
            return;
        }
        mILogCallBack.error(TextUtils.isEmpty(tag) ? TAG : tag, msg);
    }

    public static class SingletonHolder {
        private static LogProxy sLogProxy = new LogProxy();
    }

    public static LogProxy getInstance() {
        return SingletonHolder.sLogProxy;
    }


    public void setILogCallBack(ILogCallBack iLogCallBack) {
        mILogCallBack = iLogCallBack;
    }

}
