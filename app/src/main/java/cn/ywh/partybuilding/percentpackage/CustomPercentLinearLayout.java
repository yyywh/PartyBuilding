package cn.ywh.partybuilding.percentpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.percent.PercentLayoutHelper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Ywh on 2018/4/17.
 * Email：787875249@qq.com
 * Function： 自定义线性百分比布局
 * Company：四川复兴科技有限公司
 */

public class CustomPercentLinearLayout extends LinearLayout {

    private PercentLayoutHelper  mPercentLayoutHelper;

    public CustomPercentLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPercentLayoutHelper = new PercentLayoutHelper (this);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mPercentLayoutHelper.adjustChildren(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mPercentLayoutHelper.handleMeasuredStateTooSmall()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mPercentLayoutHelper.restoreOriginalParams();
    }
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams
            implements PercentLayoutHelper.PercentLayoutParams {
        private PercentLayoutHelper.PercentLayoutInfo mPercentLayoutInfo;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            mPercentLayoutInfo = PercentLayoutHelper.getPercentLayoutInfo(c, attrs);
        }

        @Override
        public PercentLayoutHelper.PercentLayoutInfo getPercentLayoutInfo() {
            return mPercentLayoutInfo;
        }

        @Override
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
            PercentLayoutHelper.fetchWidthAndHeight(this, a, widthAttr, heightAttr);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }


        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

    }
}