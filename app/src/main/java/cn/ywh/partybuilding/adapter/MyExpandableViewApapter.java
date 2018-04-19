package cn.ywh.partybuilding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.javaBean.MoreClassBean;
import cn.ywh.partybuilding.utils.ChildGridView;


/**
 * Created by Ywh on 2018/4/13.
 * Email：787875249@qq.com
 * Function：仿QQ折叠列表,显示更多分类
 * Company：四川复兴科技有限公司
 */

public class MyExpandableViewApapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<MoreClassBean> moreClassData;
    private LayoutInflater inflater;

    public MyExpandableViewApapter(Context mContext, List<MoreClassBean> moreClassData) {
        this.mContext = mContext;
        this.moreClassData = moreClassData;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getGroupCount() {
        return moreClassData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return moreClassData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return moreClassData.get(groupPosition).data.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (null==convertView){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.adapter_moreclass,parent,false);
            viewHolder.ll_group= (LinearLayout) convertView.findViewById(R.id.ll_group);
            viewHolder. ll_child=(LinearLayout)convertView.findViewById(R.id.ll_child);
            viewHolder.imageView=(ImageView)convertView.findViewById(R.id.img_moreclassleftbg);
            viewHolder.txt_classname=(TextView)convertView.findViewById(R.id.txt_classname);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.ll_child.setVisibility(View.GONE);
        viewHolder.imageView.setBackgroundColor(moreClassData.get(groupPosition).classMoreTypeLeftBg);
        viewHolder.txt_classname.setText(moreClassData.get(groupPosition).classMoreType);
        return convertView;

    }
    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (null==convertView){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.adapter_moreclass,parent,false);
             viewHolder.ll_group= (LinearLayout) convertView.findViewById(R.id.ll_group);
             viewHolder.ll_child=(LinearLayout)convertView.findViewById(R.id.ll_child);
             viewHolder.ll_group.setVisibility(View.GONE);
             viewHolder.gridView=(ChildGridView)convertView.findViewById(R.id.moreclassgridview);
            convertView.setTag(viewHolder);
        }else {
           viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.gridView.setAdapter(new HeadPageClassAdapter(mContext,moreClassData.get(groupPosition).data));
        viewHolder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "点击了第" + (groupPosition + 1) + "组，第" +
                        (position + 1) + "项", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    public class ViewHolder{
        LinearLayout ll_group;
        LinearLayout ll_child;
        ChildGridView gridView=null;
        ImageView imageView;
        TextView txt_classname;

    }
}
