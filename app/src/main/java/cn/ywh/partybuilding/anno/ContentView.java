package cn.ywh.partybuilding.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ywh on 2018/4/11.
 * Email：787875249@qq.com
 * Function：设置Activity布局
 * Company：四川复兴科技有限公司
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentView {

     int value();
}
