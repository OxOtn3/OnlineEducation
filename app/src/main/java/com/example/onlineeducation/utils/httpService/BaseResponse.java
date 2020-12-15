//package com.example.onlineeducation.utils.httpService;
//
//public class BaseResponse<T> {
//
//    public BaseResponse(String flag, T msg, String code) {
//        this.flag = flag;
//        this.msg = msg;
//        this.code = code;
//    }
//
//    // 是否成功：Y-是；N-否；
//    private String flag;
//
//    // 处理结果
//    private T msg;
//
//    private String code;
//
//    public String getFlag() {
//        return flag;
//    }
//
//    public void setFlag(String flag) {
//        this.flag = flag;
//    }
//
//    public T getMsg() {
//        return msg;
//    }
//
//    public void setMsg(T msg) {
//        this.msg = msg;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    @Override
//    public String toString() {
//        return "BaseResponse{" +
//                "flag='" + flag + '\'' +
//                ", msg=" + msg +
//                ", code='" + code + '\'' +
//                '}';
//    }
//}
//
