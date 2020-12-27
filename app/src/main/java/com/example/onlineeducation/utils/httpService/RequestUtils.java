//package com.example.onlineeducation.utils.httpService;
//
//import android.app.Activity;
//import android.util.Log;
//
//import com.anji.vlp.bean.CoordinateBean;
//import com.anji.vlp.bean.ErrorTaskBean;
//import com.anji.vlp.bean.GetByVinBean;
//import com.anji.vlp.bean.LoginBean;
//import com.anji.vlp.bean.LogoutBean;
//import com.anji.vlp.bean.StartTaskBean;
//import com.anji.vlp.bean.TaskFinishBean;
//import com.anji.vlp.bean.TaskInfo;
//import com.anji.vlp.bean.TaskList;
//import com.anji.vlp.bean.TaskListBean;
//import com.anji.vlp.bean.User;
//import com.anji.vlp.utils.SharedPreferencesUtil;
//import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
//
//import okhttp3.ResponseBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class RequestUtils {
//
//    /**
//     * 登入
//     */
//    public static void login(RxAppCompatActivity context, LoginBean loginBean, MyObserver<User> consumer) {
//        RetrofitWrapper.getServiceApi().login(loginBean).compose(RxHelper.observableIO2Main(context)).subscribe(consumer);
//    }
//
//    /**
//     * 登出
//     */
//    public static void logout(Activity context, LogoutBean logoutBean, MyObserver<String> consumer) {
//        RetrofitWrapper.getServiceApi().logout(logoutBean).compose(RxHelper.observableIO2Main(context)).subscribe(consumer);
//    }
//
//    /**
//     * 上传经纬度坐标
//     * 高频操作，不需要关心是否调用成功
//     */
//    public static void pushCoordinate(CoordinateBean coordinateBean) {
//
//        RetrofitWrapper.getServiceApi().pushCoordinate(coordinateBean).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.d("RequestUtils", String.valueOf(response.isSuccessful()));
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d("RequestUtils", t.toString());
//            }
//        });
//    }
//
//    /**
//     * 获取任务列表信息
//     */
//    public static void getTaskList(Activity context, MyObserver<TaskList> consumer) {
//        String userId = SharedPreferencesUtil.getUserId(context);
//        RetrofitWrapper.getServiceApi().getTaskList(userId).compose(RxHelper.observableIO2Main(context)).subscribe(consumer);
//    }
//
//    /**
//     * 任务异常提交
//     */
//
//    public static void taskError(RxAppCompatActivity context, ErrorTaskBean errorTaskBean, MyObserver<String> consumer) {
//        RetrofitWrapper.getServiceApi().postErrorTask(errorTaskBean).compose(RxHelper.observableIO2Main(context)).subscribe(consumer);
//    }
//
//    /**
//     * 扫VIN码开始任务
//     */
//
//    public static void taskStart(RxAppCompatActivity context, StartTaskBean startTaskBean, MyObserver<String> consumer) {
//        RetrofitWrapper.getServiceApi().startTask(startTaskBean).compose(RxHelper.observableIO2Main(context)).subscribe(consumer);
//    }
//
//    /**
//     * 扫VIN码查任务
//     */
//
//    public static void getTaskByVin(RxAppCompatActivity context, String VIN, double LNG, double LAT, MyObserver<TaskInfo> consumer) {
//        String userId = SharedPreferencesUtil.getUserId(context);
//        String ep = SharedPreferencesUtil.getDeviceId(context);
//        RetrofitWrapper.getServiceApi().getTaskByVin(userId, ep, VIN, LNG, LAT).compose(RxHelper.observableIO2Main(context)).subscribe(consumer);
//    }
//
//    /**
//     * 任务完成
//     */
//    public static void finishTask(RxAppCompatActivity context, TaskFinishBean taskFinishBean, MyObserver<String> consumer) {
//        RetrofitWrapper.getServiceApi().taskFinish(taskFinishBean).compose(RxHelper.observableIO2Main(context)).subscribe(consumer);
//    }
//}
