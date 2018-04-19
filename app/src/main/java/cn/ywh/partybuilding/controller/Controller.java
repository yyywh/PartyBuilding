package cn.ywh.partybuilding.controller;

import android.content.Context;

import cn.ywh.partybuilding.net.BaseController;
import cn.ywh.partybuilding.net.Iview;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function： 网络请求
 * Company：四川复兴科技有限公司
 */

public class Controller extends BaseController {
    public Controller(Context context, Iview iView) {
        super(context, iView);
    }
    /**
     * 登录
     */
//    public void login(int reqId, long id, String password) {
//        ServiceApi serviceApi;
//        if ((serviceApi = helper.getServiceApi()) == null)
//            return;
//        helper.setObservable(serviceApi.login(id, password), reqId);
//    }
}
