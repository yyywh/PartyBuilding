package cn.ywh.partybuilding.net;

import android.content.Context;
import android.util.Log;

import cn.ywh.partybuilding.utils.DeviceUtils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function： 网络辅助类
 * Company：四川复兴科技有限公司
 */

public class NetHelper {
    private Context context;
    private Iview iView;

    public NetHelper(Context context, Iview iView) {
        this.context = context;
        this.iView = iView;

    }

    /**
     * 获取网络访问接口
     */
    public ServiceApi getServiceApi() {
        //判断网络是否可用
        if (!DeviceUtils.isNetworkConnected(context)) {
            iView.onUpdateView(NetConstant.NO_NET_NO_CACHE, null);
            return null;
        }
        try {
            return NetService.getApiService(context);
        } catch (Exception e) {
            iView.onUpdateView(NetConstant.NET_CREATE_ERROR, null);
            e.printStackTrace();
        }
        return null;
    }
    public void setObservable(Observable<? extends BaseResponse> observable, final int reqId) {
        setObservable(observable, "", reqId);
    }
    public void setObservable(Observable<? extends BaseResponse> observable, final String key, final int reqId) {

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseResponse>() {
                    @Override
                    public void call(BaseResponse response) {
                        Log.e("TAG","______________________");
                        if (response == null) {
                            iView.onUpdateView(NetConstant.RES_NULL, null);
                            return;
                        }


                        switch (response.rescode) {
                            case NetConstant.RES_NULL:
                                iView.onUpdateView(NetConstant.RES_NULL, response);
                                break;

                            case NetConstant.REQ_SUCCESS:
                                Log.e("TAG","################");
                                iView.onUpdateView(reqId, response);
                                break;
                            default:
                                iView.onUpdateView(NetConstant.RES_UNKNOWN, null);
                                break;
                        }


                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        iView.onUpdateView(NetConstant.NET_CREATE_ERROR, null);

                    }
                });
    }

}
