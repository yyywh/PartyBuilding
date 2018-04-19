package cn.ywh.partybuilding.net;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.ywh.partybuilding.rx.RxBus;
import cn.ywh.partybuilding.rx.RxDataEvent;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function：网络辅助类NetHelper
 * Company：四川复兴科技有限公司
 */

public class BaseController {

    protected Iview iView;
    protected Context context;
    private Subscription rxSubscription;

    public NetHelper helper;

    public static final String CREATE_BUNDLE = "CREATE_BUNDLE";
    private boolean isRunning;  //生命标记

    public BaseController(final Context context, Iview iView) {
        this.context = context;
        this.iView = iView;
        helper = new NetHelper(context, iView);
        this.rxSubscription =
                RxBus.getInstance().toObservable(RxDataEvent.class)
                        .subscribe(new Action1<RxDataEvent>() {
                                       @Override
                                       public void call(RxDataEvent event) {
                                           if (event != null)
                                               onDataReceive(event.type, (BaseResponse) event.data);
                                       }
                                   }

                                ,
                                new Action1<Throwable>()

                                {
                                    @Override
                                    public void call(Throwable throwable) {


                                    }
                                }

                        );
    }


    /**
     * 当接收到数据
     *
     * @param resId    标志
     * @param response 数据
     */
    public void onDataReceive(int resId, final BaseResponse response) {
        iView.onUpdateView(resId, response);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    public void onCreate(Bundle bundle) {
        isRunning = true;
    }

    public void initView() {
        // iView.initView();
    }

    public void onDestroy() {
        this.rxSubscription.unsubscribe();
    }

    public void onNewIntent(Intent intent) {
    }

    public void onPause() {
        isRunning = false;
    }

    public void onResume() {
        isRunning = true;
    }

}
