package cn.ywh.partybuilding.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.anno.CAnno;
import cn.ywh.partybuilding.utils.YyLogUtil;

/**
 * Created by Ywh on 2018/4/11.
 * Email：787875249@qq.com
 * Function：
 * Company：四川复兴科技有限公司
 */
public abstract class BaseAcivity extends AppCompatActivity {


    private TextView tvRight;
    private TextView tvTitle;
    protected Toolbar toolbar;
    private ImageView imgLeft;
    private LinearLayout parentLinearLayout;
    private View view;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(R.layout.activity_baseactivity);
        mContext=this.getApplicationContext();
        imgLeft= (ImageView) findViewById(R.id.img_left);
        tvTitle= (TextView) findViewById(R.id.tv_title);
        tvRight= (TextView) findViewById(R.id.tv_right);
//        toolbar= (Toolbar) findViewById(R.id.toolbar);
        view=findViewById(R.id.view_base);
        CAnno.bind(this);
        initView(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int flags = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        //判断是否显示回退按钮
        setBackIcon();
    }
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
        ButterKnife.bind(this);
//        super.setContentView(layoutResID);
        //将公有的Toolbar提取出来
        if (getToolbar() != null) {
            setSupportActionBar(getToolbar());
            //不显示actionBar默认的标题以及左上角返回图标，使用自定义的toolbar
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            //设置添加状态栏的高度
            if (view != null) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
                params.height = getStatusBarHeight(this);
                view.setLayoutParams(params);
                //状态栏的高度+toolbar的高度
            }
        }
    }

    public abstract void initView(Bundle savedInstanceState);

    /**
     * 可以通过 findViewById(android.R.id.content)拿到window的ViewGroup然后将刚才声明的LinearLayout添加到这个ViewGroup中，
     * 这样就可以在子Activity中显示出BaseActivity中的Toolbar了
     *
     * @param layoutResID
     * 通过initContentView()方法将BaseActivity中的布局文件添加到了声明的parentLinearLayout中，
     *通过setContentView()方法将子Activity的布局也添加到了parentLinearLayout中，
     *然后又将parentLinearLayout添加到了viewGroup中实现了Activity与布局文件的关联。
     */
    private void initContentView(@LayoutRes int layoutResID) {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        parentLinearLayout = new LinearLayout(this);
        parentLinearLayout.setOrientation(LinearLayout.VERTICAL);
        //  add parentLinearLayout in viewGroup
        viewGroup.addView(parentLinearLayout);
        //  add the layout of BaseActivity in parentLinearLayout
        LayoutInflater.from(this).inflate(layoutResID, parentLinearLayout, true);
    }

    /**
     * 设置back图标
     */
    private void setBackIcon() {
        if (null != getToolbar() && isShowBacking()) {
            imgLeft.setImageResource(R.mipmap.back);
            imgLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
    /**
     * 获取状态栏的高度
     */
    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        YyLogUtil.i("TAG","状态栏的高度为："+result);
        return result;
    }
    /**
     * set Title
     * @param title
     */
    public void setToolBarTitle(CharSequence title) {
        if (tvTitle != null) {
//            Toolbar toolbar=getToolbar();
//            toolbar.setTitle("");
//            toolbar.setNavigationIcon(null);
            tvTitle.setText(title);
        }
        else {
            getToolbar().setTitle(title);
            setSupportActionBar(getToolbar());
        }
    }

    public Toolbar getToolbar() {
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        return toolbar;
    }

    protected boolean isShowBacking() {
        return true;
    }
}
