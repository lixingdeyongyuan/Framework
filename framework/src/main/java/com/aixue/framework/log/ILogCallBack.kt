package com.aixue.framework.log

interface ILogCallBack {

    fun debug(tag: String?, msg: String)

    fun info(tag: String?, msg: String)

    fun error(tag: String?, msg: String)

}
