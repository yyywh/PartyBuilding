package cn.ywh.partybuilding.net;

import com.google.gson.annotations.SerializedName;


/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function：数据响应基类
 * Company：四川复兴科技有限公司
 */

public class BaseResponse<T> {
    @SerializedName("rescode")
    public int rescode;
    @SerializedName("resmsg")
    public String resmsg;
    @SerializedName("totalrow")
    public int totalrow;
    @SerializedName("data")
    public T data;
}
