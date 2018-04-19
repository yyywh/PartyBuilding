package cn.ywh.partybuilding.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.activity.MainActivity;
import cn.ywh.partybuilding.activity.MoreClassActivity;
import cn.ywh.partybuilding.activity.TestTabLayoutActivity;
import cn.ywh.partybuilding.adapter.HeadPageClassAdapter;
import cn.ywh.partybuilding.adapter.HeadPageNewsAdapter;
import cn.ywh.partybuilding.anno.ContentView;
import cn.ywh.partybuilding.javaBean.ClassNameBean;
import cn.ywh.partybuilding.javaBean.HeadPageNewsBean;
import cn.ywh.partybuilding.rx.RxBus;
import cn.ywh.partybuilding.rx.RxDataEvent;
import cn.ywh.partybuilding.utils.YyImageLoder;

/**
 * Created by Ywh on 2018/4/11.
 * Email：787875249@qq.com
 * Function：  主页对应的Fragment
 * Company：四川复兴科技有限公司
 */

@ContentView(R.layout.activity_headpage)
public class HeadpageFragment extends BaseFragment {

    @BindView(R.id.headpagebanner)
    Banner headpagebanner;
    @BindView(R.id.headpageclassGridview)
    GridView headpageclassGridview;
    @BindView(R.id.headpagerecyclerView)
    RecyclerView headpagerecyclerView;
    private List<String> bannerData;
//    private List<String> classNameData;
//    private List<Integer> imgData;
    private List<ClassNameBean>classNameData;
    private List<HeadPageNewsBean> newsData;
    @Override
    protected void initEventAndView(Bundle savedInstanceState) {
        //initBanner 首页Banner轮播图
        initBanner();
        //初始化中间分类
        initClassName();
        //为中部分类设置适配器
        headpageclassGridview.setAdapter(new HeadPageClassAdapter(mContext, classNameData));
        //初始化底部新闻信息
        initNewsData();
        headpagerecyclerView.setAdapter(new HeadPageNewsAdapter(newsData,mContext));
        headpagerecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        headpagerecyclerView.setItemAnimator(new DefaultItemAnimator());
//        FullyLinearLayoutManager layoutManager=new FullyLinearLayoutManager(mContext);
//        headpagerecyclerView.setNestedScrollingEnabled(false);
//        headpagerecyclerView.setLayoutManager(layoutManager);
        //中间分类点击
        headpageclassGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==classNameData.size()-1){
                    startActivity(MoreClassActivity.class,null);
                }else if (position==0){
                    startActivity(TestTabLayoutActivity.class,null);
                }
            }
        });
    }
    private void initNewsData() {
        newsData = new ArrayList<>();
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-03 10:56", "http://01.imgmini.eastday.com/mobile/20180412/20180412154307_a285b908db6cbd3d8e650ab6be000da6_8_mwpm_03200403.jpg", "习近平将出席亚洲论坛2018开幕式,习近平将出席亚洲论坛2018开幕式"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-06 18:56", "http://03.imgmini.eastday.com/mobile/20180412/20180412152408_b813c6c423200b4468631be14e38ab82_2_mwpm_03200403.jpg", "一网通办的智慧政府，将为我们带来怎样的福利,一网通办的智慧政府，将为我们带来怎样的福利"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-09 10:21", "http://08.imgmini.eastday.com/mobile/20180412/20180412151624_4206ef99164f5c3037681fdf3c04879d_1_mwpm_03200403.jpg", "新时代如何实现更高质量和更充分就业,新时代如何实现更高质量和更充分就业"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-03 10:56", "http://01.imgmini.eastday.com/mobile/20180412/20180412154307_a285b908db6cbd3d8e650ab6be000da6_8_mwpm_03200403.jpg", "习近平将出席亚洲论坛2018开幕式,习近平将出席亚洲论坛2018开幕式"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-06 18:56", "http://03.imgmini.eastday.com/mobile/20180412/20180412152408_b813c6c423200b4468631be14e38ab82_2_mwpm_03200403.jpg", "一网通办的智慧政府，将为我们带来怎样的福利,一网通办的智慧政府，将为我们带来怎样的福利"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-09 10:21", "http://08.imgmini.eastday.com/mobile/20180412/20180412151624_4206ef99164f5c3037681fdf3c04879d_1_mwpm_03200403.jpg", "新时代如何实现更高质量和更充分就业,新时代如何实现更高质量和更充分就业"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-03 10:56", "http://01.imgmini.eastday.com/mobile/20180412/20180412154307_a285b908db6cbd3d8e650ab6be000da6_8_mwpm_03200403.jpg", "习近平将出席亚洲论坛2018开幕式,习近平将出席亚洲论坛2018开幕式"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-06 18:56", "http://03.imgmini.eastday.com/mobile/20180412/20180412152408_b813c6c423200b4468631be14e38ab82_2_mwpm_03200403.jpg", "一网通办的智慧政府，将为我们带来怎样的福利,一网通办的智慧政府，将为我们带来怎样的福利"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-09 10:21", "http://08.imgmini.eastday.com/mobile/20180412/20180412151624_4206ef99164f5c3037681fdf3c04879d_1_mwpm_03200403.jpg", "新时代如何实现更高质量和更充分就业,新时代如何实现更高质量和更充分就业"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-03 10:56", "http://01.imgmini.eastday.com/mobile/20180412/20180412154307_a285b908db6cbd3d8e650ab6be000da6_8_mwpm_03200403.jpg", "习近平将出席亚洲论坛2018开幕式,新时代如何实现更高质量和更充分就业"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-06 18:56", "http://03.imgmini.eastday.com/mobile/20180412/20180412152408_b813c6c423200b4468631be14e38ab82_2_mwpm_03200403.jpg", "一网通办的智慧政府，将为我们带来怎样的福利,新时代如何实现更高质量和更充分就业"));
        newsData.add(new HeadPageNewsBean("党建新闻", "2018-04-09 10:21", "http://08.imgmini.eastday.com/mobile/20180412/20180412151624_4206ef99164f5c3037681fdf3c04879d_1_mwpm_03200403.jpg", "新时代如何实现更高质量和更充分就业,新时代如何实现更高质量和更充分就业"));
    }

    private void initClassName() {
        classNameData=new ArrayList<>();
        classNameData.add(new ClassNameBean(R.drawable.images01,"政策法规"));
        classNameData.add(new ClassNameBean(R.drawable.images02,"党建地图"));
        classNameData.add(new ClassNameBean(R.drawable.images03,"任务通知"));
        classNameData.add(new ClassNameBean(R.drawable.images04,"党员管理"));
        classNameData.add(new ClassNameBean(R.drawable.images05,"组织建设"));
        classNameData.add(new ClassNameBean(R.drawable.images06,"干部管理"));
        classNameData.add(new ClassNameBean(R.drawable.images07,"学习教育"));
        classNameData.add(new ClassNameBean(R.drawable.images08,"更多"));
    }

    private void initBanner() {
        bannerData = new ArrayList<>();
//        bannerData.add("http://118.25.20.107/images/lunbo1.png");
//        bannerData.add("http://118.25.20.107/images/lunbo2.png");
//        bannerData.add("http://118.25.20.107/images/lunbo3.png");
//        bannerData.add("http://118.25.20.107/images/lunbo4.png");
//        bannerData.add("http://img.zcool.cn/community/01c8dc56e1428e6ac72531cbaa5f2c.jpg");
        bannerData.add("http://a1.qpic.cn/psb?/V13ehV152kH0Jk/gQ0SpZRy*lfUZbRm0juaP1fdeFhS8qbs5VZzsPv1ysE!/b/dDABAAAAAAAA&ek=1&kp=1&pt=0&bo=2gTLAdoEywEBACc!&tm=1523847600&sce=0-12-12&rf=viewer_311");
        bannerData.add("http://a3.qpic.cn/psb?/V13ehV152kH0Jk/a169PAHxVF75xQ*Ae9V6tY8X5Wo6nmw3H4yAZPZPDS0!/b/dFYBAAAAAAAA&ek=1&kp=1&pt=0&bo=2gTCAdoEwgEBACc!&tm=1523847600&sce=0-12-12&rf=viewer_311");
        bannerData.add("http://a2.qpic.cn/psb?/V13ehV152kH0Jk/17GvkfCXw9qvALVA1vnNMx094diQ85mOHhC49Hn4XoU!/b/dJUAAAAAAAAA&ek=1&kp=1&pt=0&bo=2gTdAdoE3QEBACc!&tm=1523847600&sce=0-12-12&rf=viewer_311");
//      "R.drawable.banner2","R.drawable.banner3"
//        bannerData.add();
//        bannerData.add();
        headpagebanner.setImages(bannerData);
        // 设置Banner动画效果
        headpagebanner.setBannerAnimation(Transformer.Accordion);
        //设置图片加载器
        headpagebanner.setImageLoader(new YyImageLoder());
        //设置banner对应的标题
//      headpagebanner.setBannerTitles(titleData);
        //设置自动播放
        headpagebanner.isAutoPlay(true);
        //设置轮播时间
        headpagebanner.setDelayTime(1500);
        //设置指示器位置
        headpagebanner.setIndicatorGravity(BannerConfig.RIGHT);
        headpagebanner.start();
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            RxBus.getInstance().send(new RxDataEvent(MainActivity.Title, "首页"));
        }
    }

}
