package cn.ywh.partybuilding.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.anno.ContentView;

/**
 * Created by Ywh on 2018/4/16.
 * Email：787875249@qq.com
 * Function：测试顶部选项卡 TabLayout   tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
 * 就可以实现和viewpager滑动实现联动效果，选项卡内容在viewpager的adapter的gettitle方法中设置（选项卡可以动也可以不动）。
 * Company：四川复兴科技有限公司
 */

@ContentView(R.layout.activity_tabayout)
public class TestTabLayoutActivity extends BaseAcivity {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.ll_sc_content)
    LinearLayout llScContent;

    private List<String>mData;
    @Override
    public void initView(Bundle savedInstanceState) {
        initTestData(1);
        initTabLayoutData();
        setScrollViewContent();
        setToolBarTitle("Tab切换");
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                initTestData(tab.getPosition()+1);
                setScrollViewContent();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void initTestData(int pager) {
        mData=new ArrayList<>();
        for (int i=1;i<50;i++){
            mData.add("page"+pager+" 第"+i+"个item");
        }
    }
    private void initTabLayoutData() {
        for (int i=1;i<20;i++){
            tabLayout.addTab(tabLayout.newTab().setText("TAB"+i));
        }
    }

    /**
     * 定义刷新ScrollView的内容
     */
    private void setScrollViewContent() {
        llScContent.removeAllViews();
        for (int i=0;i<mData.size();i++){
            View view=View.inflate(mContext,R.layout.item_tablayout,null);
            ((TextView)view.findViewById(R.id.txt_tablayoutitem)).setText(mData.get(i));
            llScContent.addView(view,i);
        }
    }

    @Override
    public void setToolBarTitle(CharSequence title) {
        super.setToolBarTitle(title);
    }
}
