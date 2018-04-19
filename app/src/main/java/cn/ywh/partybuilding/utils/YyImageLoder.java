package cn.ywh.partybuilding.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function：自定义图片加载器
 * Company：四川复兴科技有限公司
 */

public class YyImageLoder extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        if (path instanceof String) {
//            GlideUtil.load(context, (String) path).into(imageView);
            Glide.with(context).load(path).into(imageView);
        }


    }
}
