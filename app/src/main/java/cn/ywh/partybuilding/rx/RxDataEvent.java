package cn.ywh.partybuilding.rx;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function：
 * Company：四川复兴科技有限公司
 */
public class RxDataEvent {
    public int type;
    public Object data;

    public RxDataEvent(int _type, Object _data) {
        this.type = _type;
        this.data = _data;
    }

    public RxDataEvent() {
    }
}
