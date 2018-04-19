package cn.ywh.partybuilding.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;


/**
 * Created by Ywh on 2018/4/13.
 * Email：787875249@qq.com
 * Function：
 * Company：四川复兴科技有限公司
 */

public class ChildGridView extends GridView {
    public ChildGridView(Context context) {
        super(context);
    }

    public ChildGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
