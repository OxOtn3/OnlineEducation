//package com.example.onlineeducation.utils.httpService;
//
//import android.util.Log;
//
//import com.anji.vlp.config.Config;
//
//import java.util.concurrent.TimeUnit;
//
//import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class RetrofitWrapper {
//
//    HttpLoggingInterceptor loggingInterceptor;
//    private static ServiceApi serviceApi;
//
//    private RetrofitWrapper() {
//    }
//
//    public static ServiceApi getServiceApi() {
//        if (null == serviceApi) {
//            synchronized (RetrofitWrapper.class) {
//                if (null == serviceApi) {
//                    serviceApi = new RetrofitWrapper().getRetrofit();
//                }
//            }
//        }
//        return serviceApi;
//    }
//
//    public ServiceApi getRetrofit() {
//        return initRetrofit().create(ServiceApi.class);
//    }
//
//    /**
//     * 初始化retrofit
//     */
//    private Retrofit initRetrofit() {
//        OkHttpClient okHttpClient = initOkHttp();
//        return new Retrofit.Builder()
//                .client(okHttpClient)
//                .baseUrl(Config.serverUrl)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//
//    /**
//     * 初始化OkHttp
//     */
//    private OkHttpClient initOkHttp() {
//        loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                Log.i("retrofitLog: ", message);
//            }
//        }).setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        return new OkHttpClient.Builder()
//                .readTimeout(20000, TimeUnit.SECONDS)// 设置读取超时时间
//                .connectTimeout(10000, TimeUnit.SECONDS)// 设置请求超时时间
//                .writeTimeout(20000, TimeUnit.SECONDS)// 设置写入超时时间
//                .addInterceptor(loggingInterceptor)// 添加打印拦截器
//                .retryOnConnectionFailure(false)// 设置出现错误进行重新连接
//                .build();
//    }
//}
