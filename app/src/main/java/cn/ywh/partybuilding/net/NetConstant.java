package cn.ywh.partybuilding.net;

/**
 * Created by ct on 2017/1/18.
 * ======================================
 * 网络常量类
 * ======================================
 * 网络返回值
 * 网络数据地址
 */

public class NetConstant {
    public static final int NO_NET_NO_CACHE = -100;//没网络没缓存
    public static final int NET_CREATE_ERROR = -200; //网络创建异常
    public static final int RES_UNKNOWN = -300; //未知错误
    public static final int RES_NULL = 0;//返回数据为空
    public static final int REQ_SUCCESS = 1;//请求成功
    public static final int ERROR_SYS = 10;//系统异常
    public static final int ERROR_TOKEN = 11;//口令失效
    public static final int ERROR_LOGING = 12;//帐号密码错误
    public static final int ERROR_PERMISSION = 13;//无权限
    public static final int ERROR_ORDER = 14;  //预约失败
    public static final int ERROR_ORDER_CANCEL = 15;//退号失败
    public static final int ERROR_NO_MONEY = 16; //余额不足
    public static long ConnectionTime = 15000;
    public static final String HOST = "http://192.168.31.250:8880/";

}
