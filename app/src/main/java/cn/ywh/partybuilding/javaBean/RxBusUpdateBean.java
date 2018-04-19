package cn.ywh.partybuilding.javaBean;

import java.io.Serializable;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function：公共的BusBean
 * Company：四川复兴科技有限公司
 */

public class RxBusUpdateBean implements Serializable {

    public int tag;
    public Object data;

    public RxBusUpdateBean(int tag, Object data) {
        this.tag = tag;
        this.data = data;
    }
}
