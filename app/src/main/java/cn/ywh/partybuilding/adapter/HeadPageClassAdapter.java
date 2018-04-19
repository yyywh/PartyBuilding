package cn.ywh.partybuilding.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.javaBean.ClassNameBean;
import cn.ywh.partybuilding.utils.GlideCircleTransform;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function：首页中间8个分类适配器
 * Company：四川复兴科技有限公司
 */

public class HeadPageClassAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<ClassNameBean>classNameData;

    public HeadPageClassAdapter(Context mContext, List<ClassNameBean>classNameData) {
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
        this.classNameData = classNameData;

    }
    public HeadPageClassAdapter(Context mContext){
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    public void setDataList( List<ClassNameBean>mData){
        this.classNameData=mData;
    }

    @Override
    public int getCount() {
        return classNameData.size();
    }

    @Override
    public Object getItem(int position) {
        return classNameData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.adapter_item_headpageclass,parent,false);
            viewHolder.txt_classtext= (TextView) convertView.findViewById(R.id.txt_classtext);
            viewHolder.img_classimg=(ImageView)convertView.findViewById(R.id.img_classimg);
            convertView.setTag(viewHolder);
        }else {
          viewHolder= (ViewHolder) convertView.getTag();
        }
//        Glide.with(mContext).load(R.drawable.test).transform(new GlideCircleTransform(mContext)).into(viewHolder.img_classimg);
        Glide.with(mContext).load(classNameData.get(position).getId()).into(viewHolder.img_classimg);
        viewHolder.txt_classtext.setText(classNameData.get(position).getClassName());
        return convertView;
    }

    private class ViewHolder{
        private ImageView img_classimg;
        private TextView txt_classtext;
    }


}
