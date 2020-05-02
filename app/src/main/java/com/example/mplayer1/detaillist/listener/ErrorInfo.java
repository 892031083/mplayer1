package com.example.mplayer1.detaillist.listener;

import com.google.gson.annotations.Expose;

public class ErrorInfo {
    public static final int ERROR_TYPE_HTTP=1;
    public static final int ERROR_TYPE_URL=2;
    public static final int ERROR_TYPE_FATAL=3;

    @Expose //区分实体中不想序列化的属性,自身包含序列反序列
    int type;//错误类型
    @Expose
    int tag;

    @Expose
    String functionName;
    @Expose
    String className;
    @Expose
    String Reson;//错误原因
    @Expose
    String exceptionString;

    public static int getErrorTypeHttp() {
        return ERROR_TYPE_HTTP;
    }

    public static int getErrorTypeUrl() {
        return ERROR_TYPE_URL;
    }

    public static int getErrorTypeFatal() {
        return ERROR_TYPE_FATAL;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getReson() {
        return Reson;
    }

    public void setReson(String reson) {
        Reson = reson;
    }

    public String getExceptionString() {
        return exceptionString;
    }

    public void setExceptionString(String exceptionString) {
        this.exceptionString = exceptionString;
    }
}
