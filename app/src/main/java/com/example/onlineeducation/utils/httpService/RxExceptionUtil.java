//package com.example.onlineeducation.utils.httpService;
//
//import android.util.Log;
//import android.widget.Toast;
//
//import org.json.JSONException;
//
//import java.net.SocketTimeoutException;
//import java.net.UnknownHostException;
//import java.text.ParseException;
//
//import retrofit2.HttpException;
//
//public class RxExceptionUtil {
//
//    public static String exceptionHandler(Throwable e){
//        String errorMsg = "未知错误";
//        if (e instanceof UnknownHostException) {
//            errorMsg = "网络不可用";
//        } else if (e instanceof SocketTimeoutException) {
//            errorMsg = "请求网络超时";
//        } else if (e instanceof HttpException) {
//            HttpException httpException = (HttpException) e;
//            errorMsg = convertStatusCode(httpException);
//        } else if (e instanceof ParseException || e instanceof JSONException) {
//            errorMsg = "数据解析错误";
//        }
//        return errorMsg;
//    }
//
//    private static String convertStatusCode(HttpException httpException) {
//        String msg;
//        Log.d("服务器出错", String.valueOf(httpException.code()));
//        if (httpException.code() >= 500 && httpException.code() < 600) {
//            msg = "服务器处理请求出错";
//        } else if (httpException.code() >= 400 && httpException.code() < 500) {
//            msg = "服务器无法处理请求";
//        } else if (httpException.code() >= 300 && httpException.code() < 400) {
//            msg = "请求被重定向到其他页面";
//        } else {
//            msg = httpException.message();
//        }
//        return msg;
//    }
//
//    public static String checkCode(String code){
//        String result = "操作成功";
//        switch (code){
//            case "C1000":
//                break;
//            case "C1001":
//                result = "用户已在其他设备登录";
//                break;
//            case "C1002":
//                result = "账号密码错误";
//                break;
//            case "C1003":
//                result = "找不到该设备";
//                break;
//            case "C1004":
//                result = "没有该用户";
//                break;
//            case "C1005":
//                result = "定位不在目标库位中";
//                break;
//            case "C1006":
//                result = "任务已取消";
//                break;
//            case "C1007":
//                result = "未找到数据";
//                break;
//            case "C1008":
//                result = "任务已取消";
//                break;
//            case "C1009":
//                result = "该车存在异常任务";
//                break;
//            case "C2000":
//                result = "程序异常";
//                break;
//            case "C2001":
//                result = "数据异常";
//                break;
//            default:
//                result = "操作失败";
//                break;
//        }
//        return result;
//    }
//}
