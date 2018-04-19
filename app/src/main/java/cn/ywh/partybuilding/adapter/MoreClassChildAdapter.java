package cn.ywh.partybuilding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.javaBean.ClassNameBean;
import cn.ywh.partybuilding.javaBean.MoreClassBean;
import cn.ywh.partybuilding.utils.ChildGridView;
/**
 * Created by Ywh on 2018/4/13.
 * Email：787875249@qq.com
 * Function：更多分类
 * Company：四川复兴科技有限公司
 */

public class MoreClassChildAdapter extends BaseAdapter {
    private Context mContext;
    private List<MoreClassBean>moreClassData;
    private LayoutInflater inflater;
    private List<ClassNameBean>mClassData;

    public MoreClassChildAdapter(Context mContext, List<MoreClassBean> moreClassData,List<ClassNameBean>mClassData) {
        this.mContext = mContext;
        this.moreClassData = moreClassData;
        this.mClassData = mClassData;
        inflater=LayoutInflater.from(mContext);
    }




    @Override
    public int getCount() {
        return moreClassData.size();
    }

    @Override
    public Object getItem(int position) {
        return moreClassData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder(convertView);
            convertView=inflater.inflate(R.layout.adapter_moreclass,parent,false);
            viewHolder.img_moreclassleftbg= (ImageView) convertView.findViewById(R.id.img_moreclassleftbg);
            viewHolder.txt_classname=(TextView)convertView.findViewById(R.id.txt_classname);
            viewHolder.moreclassgridview= (ChildGridView) convertView.findViewById(R.id.moreclassgridview);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.img_moreclassleftbg.setBackgroundColor(moreClassData.get(position).classMoreTypeLeftBg);
        viewHolder.txt_classname.setText(moreClassData.get(position).classMoreType);

         List<ClassNameBean>mData=new ArrayList<>();
        for (int i=0;i<moreClassData.size();i++){
            for (int k=0;k<moreClassData.get(i).data.size();k++){
                mData.add(new ClassNameBean(moreClassData.get(i).data.get(k).getId(),moreClassData.get(i).data.get(k).getClassName()));
            }
        }
           viewHolder.adapter.setDataList(mData);
           viewHolder.adapter.notifyDataSetChanged();
//        viewHolder.moreclassgridview.setAdapter(new HeadPageClassAdapter(mContext,mData));
//        viewHolder.moreclassgridview.setAdapter(new HeadPageClassAdapter(mContext,classnameData,imgData));
        return convertView;
    }
    private class ViewHolder{
         ImageView img_moreclassleftbg;
         TextView txt_classname;
         ChildGridView moreclassgridview;
         HeadPageClassAdapter adapter;
        public ViewHolder(View view){
            moreclassgridview= (ChildGridView) view.findViewById(R.id.moreclassgridview);
            adapter=new HeadPageClassAdapter(mContext);
            view.setTag(this);
        }
    }
}
