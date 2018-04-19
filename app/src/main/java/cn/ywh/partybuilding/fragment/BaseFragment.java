package cn.ywh.partybuilding.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import butterknife.ButterKnife;
import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.anno.CAnno;


/**
 * Created by Ywh on 2018/4/11.
 * Email：787875249@qq.com
 * Function：  fragment基类
 * Company：四川复兴科技有限公司
 */


public abstract class BaseFragment extends Fragment {
    protected LayoutInflater inflater;
    private View contentView;
    public Context mContext;
    protected ViewGroup container;
    public Activity mActivity;


    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
        mActivity = getActivity();

    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.inflater = inflater;
        this.container = container;
        CAnno.bind(this);
        initEventAndView(savedInstanceState);
        if (contentView == null)
            return super.onCreateView(inflater, container, savedInstanceState);
        return contentView;
    }

    protected abstract void initEventAndView(Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();
        contentView = null;
        container = null;
        inflater = null;
    }

    public Context getApplicationContext() {
        return mContext;
    }

    //供CAnno反射调用
    public void setContentView(int layoutId) {

        setContentView(inflater.inflate(layoutId, container, false));
    }

    public void setContentView(View view) {
        contentView = view;
        ButterKnife.bind(this, contentView);
    }

    public View getContentView() {
        return contentView;
    }

    public View findViewById(int id) {
        if (contentView != null)
            return contentView.findViewById(id);
        return null;
    }

    @Override
    public void onDestroyView() {
        contentView = null;
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            //利用反射，当前Fragment销毁时，移除FragmentManagerImpl
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 页面跳转公共方法
     * @param cls
     * @param bundle
     */
    protected void startActivity(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent(mActivity, cls);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);

    }



    /**
     * the toolbar of this Activity
     *
     * @return support.v7.widget.Toolbar.
     */
    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    /**
     * is show back icon,default is none。
     * you can override the function in subclass and return to true show the back icon
     *
     * @return
     */
    protected boolean isShowBacking() {
        return true;
    }
}
