package cn.ywh.partybuilding.anno;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ywh on 2018/4/11.
 * Email：787875249@qq.com
 * Function：  注解绑定
 * Company：四川复兴科技有限公司
 */

public class CAnno {

    public static void bind(Activity activity) {
        if (activity == null)
            throw new NullPointerException("CAnno bind error: activity is null!");

        bindView(activity);

    }

    /**
     * 绑定Activity界面
     */
    private static void bindView(Activity activity) {
        Class<? extends Activity> cls = activity.getClass();
        //获取注解
        ContentView contentView = cls.getAnnotation(ContentView.class);
        if (contentView != null) {
            //获取setContentView方法
            try {
                Method setContentView = cls.getMethod("setContentView", int.class);
                setContentView.setAccessible(true);
                setContentView.invoke(activity, contentView.value());

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.getCause().printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 绑定Fragment界面
     */

    public static void bind(Fragment fragment) {
        if (fragment == null)
            throw new NullPointerException("CAnno bind error: fragment is null!");

        bindView(fragment);

    }

    private static void bindView(Fragment fragment) {
        Class<? extends Fragment> cls = fragment.getClass();
        //获取注解
        ContentView contentView = cls.getAnnotation(ContentView.class);
        if (contentView != null) {
            //获取setContentView方法
            try {
                Method setContentView = cls.getMethod("setContentView", int.class);
                setContentView.setAccessible(true);
                setContentView.invoke(fragment, contentView.value());

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.getCause().printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
