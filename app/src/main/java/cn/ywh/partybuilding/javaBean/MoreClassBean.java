package cn.ywh.partybuilding.javaBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ywh on 2018/4/13.
 * Email：787875249@qq.com
 * Function：更多分类数据
 * Company：四川复兴科技有限公司
 */

public class MoreClassBean implements Serializable {
    public String classMoreType;
    public Integer classMoreTypeLeftBg;
    public List<ClassNameBean>data;
    public MoreClassBean(String classMoreType, Integer classMoreTypeLeftBg, List<ClassNameBean> data) {
        this.classMoreType = classMoreType;
        this.classMoreTypeLeftBg = classMoreTypeLeftBg;
        this.data = data;
    }

}
