//package com.example.onlineeducation.utils.httpService;
//
//import com.anji.vlp.bean.CoordinateBean;
//import com.anji.vlp.bean.ErrorTaskBean;
//import com.anji.vlp.bean.LoginBean;
//import com.anji.vlp.bean.LogoutBean;
//import com.anji.vlp.bean.StartTaskBean;
//import com.anji.vlp.bean.TaskFinishBean;
//import com.anji.vlp.bean.TaskInfo;
//import com.anji.vlp.bean.TaskList;
//import com.anji.vlp.bean.User;
//
//import io.reactivex.Observable;
//import okhttp3.ResponseBody;
//import retrofit2.Call;
//import retrofit2.http.Body;
//import retrofit2.http.GET;
//import retrofit2.http.POST;
//import retrofit2.http.Query;
//
//public interface ServiceApi {
//
//    /**
//     * 登录
//     *
//     * @param loginBean 用户信息(用户名、密码、设备号)
//     */
//    @POST("/api/App/AppLogin")
//    Observable<BaseResponse<User>> login(@Body LoginBean loginBean);
//
//    /**
//     * 注销
//     *
//     * @param logoutBean 用户名、设备号
//     */
//    @POST("/api/App/AppLogout")
//    Observable<BaseResponse<String>> logout(@Body LogoutBean logoutBean);
//
//    /**
//     * 查询任务
//     *
//     * @param userId 用户ID
//     */
//    @GET("/api/App/GetTaskList")
//    Observable<BaseResponse<TaskList>> getTaskList(@Query("LGN") String userId);
//
//    /**
//     * 上传经纬度
//     */
//    @POST("/api/App/VelocityCoordinate")
//    Call<ResponseBody> pushCoordinate(@Body CoordinateBean coordinateBean);
//
//    /**
//     * 未完成任务异常提交
//     */
//
//    @POST("/api/App/AbnormalTask")
//    Observable<BaseResponse<String>> postErrorTask(@Body ErrorTaskBean errorTaskBean);
//
//    /**
//     * 扫VIN码开始任务
//     */
//
//    @POST("/api/App/StartTaskByVin")
//    Observable<BaseResponse<String>> startTask(@Body StartTaskBean startTaskBean);
//
//    /**
//     * 扫VIN码查任务
//     */
//
//    @GET("/api/App/GetTaskByVin")
//    Observable<BaseResponse<TaskInfo>> getTaskByVin(@Query("LGN") String UserId, @Query("EQP") String DeviceId, @Query("VIN") String VinCode, @Query("LNG") double Longitude, @Query("LAT") double Latitude);
//
//    /**
//     * 完成任务/已开始任务异常提交
//     */
//    @POST("/api/App/AppTaskFinish")
//    Observable<BaseResponse<String>> taskFinish(@Body TaskFinishBean taskFinishBean);
//}
