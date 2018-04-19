package cn.ywh.partybuilding.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.adapter.MoreClassChildAdapter;
import cn.ywh.partybuilding.adapter.MyExpandableViewApapter;
import cn.ywh.partybuilding.anno.ContentView;
import cn.ywh.partybuilding.javaBean.ClassNameBean;
import cn.ywh.partybuilding.javaBean.MoreClassBean;
import cn.ywh.partybuilding.utils.YyLogUtil;

/**
 * Created by Ywh on 2018/4/13.
 * Email：787875249@qq.com
 * Function：首页分类， 加载更多分类对应的页面
 * Company：四川复兴科技有限公司
 */

@ContentView(R.layout.activity_more)
public class MoreClassActivity extends BaseAcivity {

    @BindView(R.id.moreRecyclerView)
    ExpandableListView moreRecyclerView;

    private List<MoreClassBean>moreClassData;
    private List<ClassNameBean>classNameData1;
    private List<ClassNameBean>classNameData2;
    private List<ClassNameBean>classNameData3;
    private List<ClassNameBean>classNameData4;
    private List<ClassNameBean>classNameData5;
    private List<ClassNameBean>mClassData;

    @Override
    public void initView(Bundle savedInstanceState) {
        setToolBarTitle("更多");
        initMoreClassData();
//        moreRecyclerView.setAdapter(new MoreClassChildAdapter(mContext,moreClassData,mClassData));
//        moreRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        moreRecyclerView.setAdapter(new MyExpandableViewApapter(mContext,moreClassData));
        moreRecyclerView.setGroupIndicator(null);
        for (int k=0;k<moreClassData.size();k++){
            moreRecyclerView.expandGroup(k);
        }
    }

    private void initMoreClassData() {
        //组装更多分类数据
        moreClassData=new ArrayList<>();
        classNameData1=new ArrayList<>();
        classNameData2=new ArrayList<>();
        classNameData3=new ArrayList<>();
        classNameData4=new ArrayList<>();
        classNameData5=new ArrayList<>();
        mClassData=new ArrayList<>();


        //第一个分类
        classNameData1.add(new ClassNameBean(R.drawable.images01,"党员档案"));
        classNameData1.add(new ClassNameBean(R.drawable.images02,"入党纪念"));
        classNameData1.add(new ClassNameBean(R.drawable.images03,"党建要闻"));
        classNameData1.add(new ClassNameBean(R.drawable.images04,"领袖诞辰"));
        classNameData1.add(new ClassNameBean(R.drawable.images05,"在线考试"));
        classNameData1.add(new ClassNameBean(R.drawable.images06,"我的积分"));
        classNameData1.add(new ClassNameBean(R.drawable.images07,"党员缴费"));
        moreClassData.add(new MoreClassBean("首页应用",Color.GREEN,classNameData1));
//        YyLogUtil.e("TAG","第一个分类:"+new Gson().toJson(moreClassData));
//        classNameData.clear();
        //第二个分类
        classNameData2.add(new ClassNameBean(R.drawable.images08,"党员档案"));
        classNameData2.add(new ClassNameBean(R.drawable.images07,"入党纪念"));
        classNameData2.add(new ClassNameBean(R.drawable.images06,"活动报名"));
        classNameData2.add(new ClassNameBean(R.drawable.images05,"活动相册"));
        classNameData2.add(new ClassNameBean(R.drawable.images04,"快捷签到"));
        classNameData2.add(new ClassNameBean(R.drawable.images03,"投票调研"));
        classNameData2.add(new ClassNameBean(R.drawable.images02,"党员论坛"));
        classNameData2.add(new ClassNameBean(R.drawable.images08,"任务管理"));
        moreClassData.add(new MoreClassBean("组织", Color.BLUE,classNameData2));
//        YyLogUtil.e("TAG","第一、第二个分类:"+new Gson().toJson(moreClassData));
//        classNameData.clear();
        //第三个分类
        classNameData3.add(new ClassNameBean(R.drawable.images08,"党员档案"));
        classNameData3.add(new ClassNameBean(R.drawable.images07,"通知公告"));
        classNameData3.add(new ClassNameBean(R.drawable.images06,"党内公示"));
        classNameData3.add(new ClassNameBean(R.drawable.images05,"领袖诞辰"));
        moreClassData.add(new MoreClassBean("新闻",Color.RED,classNameData3));
//        YyLogUtil.e("TAG","第一、第二、第三个分类:"+new Gson().toJson(moreClassData));
//        classNameData.clear();

        //第四个分类
        classNameData4.add(new ClassNameBean(R.drawable.images02,"专题教育"));
        classNameData4.add(new ClassNameBean(R.drawable.images08,"反腐倡廉"));
        classNameData4.add(new ClassNameBean(R.drawable.images06,"政策法规"));
        classNameData4.add(new ClassNameBean(R.drawable.images01,"在线考试"));
        classNameData4.add(new ClassNameBean(R.drawable.images06,"三会一课"));
        moreClassData.add(new MoreClassBean("党校",Color.GREEN,classNameData4));

//        YyLogUtil.e("TAG","第一、第二、第三、第四个分类:"+new Gson().toJson(moreClassData));
//        classNameData.clear();
        //第五个分类
        classNameData5.add(new ClassNameBean(R.drawable.images05,"我的收藏"));
        classNameData5.add(new ClassNameBean(R.drawable.images04,"党费缴纳"));
        classNameData5.add(new ClassNameBean(R.drawable.images03,"我的积分"));
        classNameData5.add(new ClassNameBean(R.drawable.images06,"我要反馈"));
        classNameData5.add(new ClassNameBean(R.drawable.images07,"入党申请"));
        moreClassData.add(new MoreClassBean("个人",Color.BLACK,classNameData5));
        YyLogUtil.e("TAG","第一、第二、第三、第四、第五个分类:"+new Gson().toJson(moreClassData));
        YyLogUtil.i("TAG","moreClassData的长度为："+moreClassData.size());

        mClassData.addAll(classNameData1);
        mClassData.addAll(classNameData2);
        mClassData.addAll(classNameData3);
        mClassData.addAll(classNameData4);
        mClassData.addAll(classNameData5);
    }

    @Override
    public void setToolBarTitle(CharSequence title) {
        super.setToolBarTitle(title);
    }
    //显示左上角回退键
    @Override
    protected boolean isShowBacking() {
        return true;
    }

}
