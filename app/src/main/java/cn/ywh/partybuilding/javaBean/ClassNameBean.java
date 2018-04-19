package cn.ywh.partybuilding.javaBean;

import java.io.Serializable;

/**
 * Created by Ywh on 2018/4/13.
 * Email：787875249@qq.com
 * Function： 中间分类对应的Bean
 * Company：四川复兴科技有限公司
 */

public class ClassNameBean implements Serializable {

    private int Id;
    private String className;

    public ClassNameBean(int id, String className) {
        Id = id;
        this.className = className;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
