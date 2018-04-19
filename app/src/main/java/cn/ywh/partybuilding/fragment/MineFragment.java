package cn.ywh.partybuilding.fragment;

import android.os.Bundle;
import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.activity.MainActivity;
import cn.ywh.partybuilding.anno.ContentView;
import cn.ywh.partybuilding.rx.RxBus;
import cn.ywh.partybuilding.rx.RxDataEvent;

/**
 * Created by Ywh on 2018/4/11.
 * Email：787875249@qq.com
 * Function：我的对应的Fragment
 * Company：四川复兴科技有限公司
 */

@ContentView(R.layout.activity_mine)
public class MineFragment extends BaseFragment {

    @Override
    protected void initEventAndView(Bundle savedInstanceState) {
//        setToolBarTitle("我的");
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            RxBus.getInstance().send(new RxDataEvent(MainActivity.Title,"我的"));
        }
    }

}
