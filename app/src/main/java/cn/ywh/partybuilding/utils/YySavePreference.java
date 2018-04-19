package cn.ywh.partybuilding.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Set;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function：
 * Company：四川复兴科技有限公司
 */

public class YySavePreference {

    private static Context context;
    private static SharedPreferences sharedPreferences;

    private YySavePreference() {
    }


    public static void init(Context context) {
        YySavePreference.context = context.getApplicationContext();

    }

    public static SharedPreferences get() {
        if (sharedPreferences == null)
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences;
    }

    /**
     * 保存String类型数据
     *
     * @param name  保存时的键值 不能为null
     * @param value 要保存的String数据
     */
    public static void putString(String name, String value) {
        get().edit().putString(name, value).apply();
    }

    /**
     * 获取保存的String类型数据
     *
     * @param name 保存时的键值 不能为null
     * @return String 返回值类型为String,默认为""
     */
    public static String getString(String name) {
        return get().getString(name, "");
    }

    /**
     * 获取保存的String类型数据
     *
     * @param name 保存时的键值 不能为null
     * @param def  如果没有时默认返回的值
     * @return String 返回值类型为String
     */
    public static String getString(String name, String def) {
        return get().getString(name, def);
    }

    /**
     * 保存Integer类型数据
     *
     * @param name  保存时的键值 不能为null
     * @param value 要保存的Integer数据
     */
    public static void putInteger(String name, int value) {
        get().edit().putInt(name, value).apply();
    }

    /**
     * 获取保存的Integer类型数据
     *
     * @param name 保存时的键值 不能为null
     * @return Integer 返回值类型为Integer,默认为0
     */
    public static int getInteger(String name) {
        return get().getInt(name, 0);
    }

    /**
     * 获取保存的Integer类型数据
     *
     * @param name 保存时的键值 不能为null
     * @param def  如果没有时默认返回的值
     * @return Integer 返回值类型为Integer,默认为def
     */
    public static int getInteger(String name, int def) {
        return get().getInt(name, def);
    }

    /**
     * 保存Boolean类型数据
     *
     * @param name  保存时的键值 不能为null
     * @param value 要保存的Boolean数据
     */
    public static void putBoolean(String name, boolean value) {
        get().edit().putBoolean(name, value).apply();
    }

    /**
     * 获取保存的Boolean类型数据
     *
     * @param name 保存时的键值 不能为null
     * @return boolean 返回值类型为Boolean,默认为false
     */
    public static boolean getBoolean(String name) {
        return get().getBoolean(name, false);
    }

    /**
     * 获取保存的boolean类型数据
     *
     * @param name 保存时的键值 不能为null
     * @param def  如果没有时默认返回的值
     * @return boolean 返回值类型为boolean,默认为def
     */
    public static boolean getBoolean(String name, boolean def) {
        return get().getBoolean(name, def);
    }

    /**
     * 保存float类型数据
     *
     * @param name  保存时的键值 不能为null
     * @param value 要保存的float数据
     */
    public static void putFloat(String name, float value) {
        get().edit().putFloat(name, value).apply();
    }

    /**
     * 获取保存的float类型数据
     *
     * @param name 保存时的键值 不能为null
     * @return float 返回值类型为float,默认为0.0f
     */
    public static float getFloat(String name) {
        return get().getFloat(name, 0.0f);
    }

    /**
     * 获取保存的float类型数据
     *
     * @param name 保存时的键值 不能为null
     * @param def  如果没有时默认返回的值
     * @return float 返回值类型为float,默认为def
     */
    public static float getFloat(String name, float def) {
        return get().getFloat(name, def);
    }

    /**
     * 保存long类型数据
     *
     * @param name  保存时的键值 不能为null
     * @param value 要保存的long数据
     */
    public static void putLong(String name, long value) {
        get().edit().putLong(name, value).apply();
    }

    /**
     * 获取保存的long类型数据
     *
     * @param name 保存时的键值 不能为null
     * @return long 返回值类型为long,默认为0L
     */
    public static long getLong(String name) {
        return get().getLong(name, 0L);
    }

    /**
     * 获取保存的long类型数据
     *
     * @param name 保存时的键值 不能为null
     * @param def  如果没有时默认返回的值
     * @return long 返回值类型为long,默认为def
     */
    public static long getLong(String name, long def) {
        return get().getLong(name, def);
    }

    /**
     * 保存Set<String>类型数据
     *
     * @param name  保存时的键值 不能为null
     * @param value 要保存的Set<String>数据
     */
    public static void putStringSet(String name, Set<String> value) {
        get().edit().putStringSet(name, value).apply();
    }

    /**
     * 获取保存的Set<String>类型数据
     *
     * @param name 保存时的键值 不能为null
     * @return Set<String> 返回值类型为Set<String>,默认为null
     */
    public static Set<String> getStringSet(String name) {
        return get().getStringSet(name, null);
    }

    /**
     * 获取保存的Set<String>类型数据
     *
     * @param name 保存时的键值 不能为null
     * @param def  如果没有时默认返回的值
     * @return Set<String> 返回值类型为Set<String>,默认为def
     */
    public static Set<String> getStringSet(String name, Set<String> def) {
        return get().getStringSet(name, def);
    }

}
