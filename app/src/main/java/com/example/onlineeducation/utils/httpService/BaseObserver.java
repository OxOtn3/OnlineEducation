//package com.example.onlineeducation.utils.httpService;
//
//import android.util.Log;
//
//import com.anji.vlp.bean.TaskList;
//
//import io.reactivex.Observer;
//import io.reactivex.disposables.Disposable;
//
//public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
//    @Override
//    public void onSubscribe(Disposable d) {
//
//    }
//
//    @Override
//    public void onNext(BaseResponse<T> response) {
//        if (response == null) {
//            Log.d("BaseObserver", "NULL");
//        } else {
//            if (response.getCode().equals("C1000")) {
//                onSuccess(response.getMsg());
//            } else {
//                onFailure(RxExceptionUtil.checkCode(response.getCode()));
//            }
//        }
//    }
//
//    @Override
//    public void onError(Throwable e) {
//        onFailure(RxExceptionUtil.exceptionHandler(e));
//    }
//
//    @Override
//    public void onComplete() {
//
//    }
//
//    public abstract void onSuccess(T result);
//
//    public abstract void onFailure(String errorMsg);
//}
