package com.dl3213.sibyl.application.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ResponseUtil
 * @Description TODO
 * @Date 2021/7/27 20:47
 * @Created by dyingleaf3213
 */
public class ResponseUtil extends HashMap<String, Object> {

    public ResponseUtil() {
        put("code", 200);
        put("msg", "操作成功");
        put("rows", "");
    }

    public static ResponseUtil success() {
        return new ResponseUtil();
    }

    public static ResponseUtil success(String msg) {
        ResponseUtil r = new ResponseUtil();
        r.put("msg", msg);
        return r;
    }

    public static ResponseUtil success(int code, String msg) {
        ResponseUtil r = new ResponseUtil();
        r.put("msg", msg);
        r.put("code", code);
        return r;
    }

    public static ResponseUtil success(String msg, Object data) {
        ResponseUtil r = new ResponseUtil();
        r.put("msg", msg);
        r.put("rows", data);
        return r;
    }

    public static ResponseUtil success(Integer code, Object data) {
        ResponseUtil r = new ResponseUtil();
        r.put("code", 200);
        r.put("msg", "操作成功");
        r.put("rows", data);
        return r;
    }

    public static ResponseUtil success(Map<String, Object> map) {
        ResponseUtil r = new ResponseUtil();
        r.putAll(map);
        return r;
    }

    public static ResponseUtil success(Object data) {
        ResponseUtil r = new ResponseUtil();
        r.put("rows", data);
        return r;
    }


    public static ResponseUtil error() {
        ResponseUtil r = new ResponseUtil();
        r.put("code", 404);
        r.put("msg", "系统繁忙，请稍后再试!");
        return r;
    }

    public static ResponseUtil error(String msg) {
        ResponseUtil r = new ResponseUtil();
        r.put("code", 404);
        r.put("msg", msg);
        return r;
    }
}