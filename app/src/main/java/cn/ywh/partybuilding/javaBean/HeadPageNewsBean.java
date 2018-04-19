package cn.ywh.partybuilding.javaBean;

import java.io.Serializable;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function： 首页底部新闻列表
 * Company：四川复兴科技有限公司
 */

public class HeadPageNewsBean implements Serializable {

    public Integer newsimgId;
    public String newstxttype;
    public String newsTime;
    public String newsdetailimg;
    public String newsdetaildesc;

    public HeadPageNewsBean(String newstxttype, String newsTime, String newsdetailimg, String newsdetaildesc) {
        this.newstxttype = newstxttype;
        this.newsTime = newsTime;
        this.newsdetailimg = newsdetailimg;
        this.newsdetaildesc = newsdetaildesc;
    }
}
