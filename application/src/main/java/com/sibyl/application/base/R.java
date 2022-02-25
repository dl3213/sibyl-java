package com.sibyl.application.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ResponseUtil
 * @Description TODO
 * @Date 2021/7/27 20:47
 * @Created by dyingleaf3213
 */
public class R extends HashMap<String, Object> {
    
    private static String DATA_NAME = "data";
    private static String CODE_NAME = "code";
    private static String MSG_NAME = "msg";

    public R() {
        put(CODE_NAME, 200);
        put(MSG_NAME, "操作成功");
        put(DATA_NAME, "");
    }

    public static R success() {
        return new R();
    }

    public static R success(String msg) {
        R r = new R();
        r.put(MSG_NAME, msg);
        return r;
    }

    public static R success(int code, String msg) {
        R r = new R();
        r.put(MSG_NAME, msg);
        r.put(CODE_NAME, code);
        return r;
    }

    public static R success(String msg, Object data) {
        R r = new R();
        r.put(MSG_NAME, msg);
        r.put(DATA_NAME, data);
        return r;
    }

    public static R success(Integer code, Object data) {
        R r = new R();
        r.put(CODE_NAME, 200);
        r.put(MSG_NAME, "操作成功");
        r.put(DATA_NAME, data);
        return r;
    }

    public static R success(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R success(Object data) {
        R r = new R();
        r.put(DATA_NAME, data);
        return r;
    }


    public static R error() {
        R r = new R();
        r.put(CODE_NAME, 404);
        r.put(MSG_NAME, "系统繁忙，请稍后再试!");
        return r;
    }

    public static R error(String msg) {
        R r = new R();
        r.put(CODE_NAME, 404);
        r.put(MSG_NAME, msg);
        return r;
    }
}