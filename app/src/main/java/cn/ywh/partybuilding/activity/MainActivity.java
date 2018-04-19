package cn.ywh.partybuilding.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.anno.ContentView;
import cn.ywh.partybuilding.fragment.HeadpageFragment;
import cn.ywh.partybuilding.fragment.MineFragment;
import cn.ywh.partybuilding.fragment.StudyFragment;
import cn.ywh.partybuilding.fragment.TaskFragment;
import cn.ywh.partybuilding.rx.RxBus;
import cn.ywh.partybuilding.rx.RxDataEvent;
import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by Ywh on 2018/4/11.
 * Email：787875249@qq.com
 * Function：MainActivity使用Viewpager+fragment实现切换
 * Company：四川复兴科技有限公司
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseAcivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.mainpageviewpager)
    ViewPager mainpageviewpager;
    @BindView(R.id.rdb_headpage)
    TextView rdbHeadpage;
    @BindView(R.id.rdb_study)
    TextView rdbStudy;
    @BindView(R.id.rdb_task)
    TextView rdbTask;
    @BindView(R.id.rdb_mine)
    TextView rdbMine;
    @BindView(R.id.mianpageRadiogroup)
    RadioGroup mianpageRadiogroup;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.img_headpage)
    ImageView imgHeadpage;
    @BindView(R.id.ll_headpage)
    LinearLayout llHeadpage;
    @BindView(R.id.img_study)
    ImageView imgStudy;
    @BindView(R.id.ll_study)
    LinearLayout llStudy;
    @BindView(R.id.img_task)
    ImageView imgTask;
    @BindView(R.id.ll_task)
    LinearLayout llTask;
    @BindView(R.id.img_mine)
    ImageView imgMine;
    @BindView(R.id.ll_mine)
    LinearLayout llMine;
    private List<Fragment> mData = null;
    public static final int Title = 0x110;
    private Subscription subscription;

    @Override
    public void initView(Bundle savedInstanceState) {
        //初始化view
        mData = new ArrayList<>();
        mData.add(new HeadpageFragment());
        mData.add(new StudyFragment());
        mData.add(new TaskFragment());
        mData.add(new MineFragment());
        mainpageviewpager.setAdapter(new FragmentPagerAdapter(this.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mData.get(position);
            }

            @Override
            public int getCount() {
                return mData.size();
            }
        });
        mainpageviewpager.addOnPageChangeListener(this);

        //设置标题栏的文字
        subscription = RxBus.getInstance().toObservable(RxDataEvent.class).subscribe(new Action1<RxDataEvent>() {
            @Override
            public void call(RxDataEvent rxDataEvent) {
                if (rxDataEvent.type == Title) {
                    setToolBarTitle((String) rxDataEvent.data);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        clearTextAndImgStyle();
        switch (position) {
            case 0:
                mianpageRadiogroup.check(R.id.rdb_headpage);
                rdbHeadpage.setTextColor(Color.parseColor("#dd5d40"));
                imgHeadpage.setImageResource(R.drawable.headpageselected);
                break;
            case 1:
                mianpageRadiogroup.check(R.id.rdb_study);
                rdbStudy.setTextColor(Color.parseColor("#dd5d40"));
                imgStudy.setImageResource(R.drawable.interactionselected);
                break;
            case 2:
                mianpageRadiogroup.check(R.id.rdb_task);
                rdbTask.setTextColor(Color.parseColor("#dd5d40"));
                imgTask.setImageResource(R.drawable.productselected);
                break;
            case 3:
                mianpageRadiogroup.check(R.id.rdb_mine);
                rdbMine.setTextColor(Color.parseColor("#dd5d40"));
                imgMine.setImageResource(R.drawable.mineselected);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 清除底部导航字体颜色，背景图片回复默认
     */
    protected void clearTextAndImgStyle() {
        rdbHeadpage.setTextColor(Color.parseColor("#676767"));
        rdbStudy.setTextColor(Color.parseColor("#676767"));
        rdbTask.setTextColor(Color.parseColor("#676767"));
        rdbMine.setTextColor(Color.parseColor("#676767"));
        imgHeadpage.setImageResource(R.drawable.headpage);
        imgStudy.setImageResource(R.drawable.interaction);
        imgTask.setImageResource(R.drawable.product);
        imgMine.setImageResource(R.drawable.mine);
    }
    /**
     * 是否显示回退
     *
     * @return
     */
    @Override
    protected boolean isShowBacking() {
        return false;
    }

    @Override
    public void setToolBarTitle(CharSequence title) {
        super.setToolBarTitle(title);
    }


    @OnClick({R.id.ll_headpage, R.id.ll_study, R.id.ll_task, R.id.ll_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_headpage:
                mainpageviewpager.setCurrentItem(0);
                imgHeadpage.setImageResource(R.drawable.headpageselected);
                break;
            case R.id.ll_study:
                mainpageviewpager.setCurrentItem(1);
                imgStudy.setImageResource(R.drawable.interactionselected);
                break;
            case R.id.ll_task:
                mainpageviewpager.setCurrentItem(2);
                imgTask.setImageResource(R.drawable.productselected);
                break;
            case R.id.ll_mine:
                mainpageviewpager.setCurrentItem(3);
                imgMine.setImageResource(R.drawable.mineselected);
                break;
        }
    }
}
