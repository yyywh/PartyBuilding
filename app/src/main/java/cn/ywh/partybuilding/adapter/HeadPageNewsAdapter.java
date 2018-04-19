package cn.ywh.partybuilding.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.ywh.partybuilding.R;
import cn.ywh.partybuilding.javaBean.HeadPageNewsBean;

/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function：
 * Company：四川复兴科技有限公司
 */

public class HeadPageNewsAdapter extends RecyclerView.Adapter<HeadPageNewsAdapter.ViewHolder> {

    private List<HeadPageNewsBean>newsData;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public HeadPageNewsAdapter(List<HeadPageNewsBean> newsData, Context mContext) {
        this.newsData = newsData;
        this.mContext = mContext;
        layoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder=new ViewHolder(layoutInflater.inflate(R.layout.adapter_headpagenews,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//         YyLogUtil.e("TAG","newsData的长度为："+newsData.size());
         Log.i("TAG","*******:"+newsData.get(position).newstxttype);
          holder.txt_newtype.setText(newsData.get(position).newstxttype);
          holder.txt_newtime.setText(newsData.get(position).newsTime);
          Glide.with(mContext).load(newsData.get(position).newsdetailimg).into(holder.img_detailnewimg);
          holder.txt_detailnewdesc.setText(newsData.get(position).newsdetaildesc);
    }

    @Override
    public int getItemCount() {
        return newsData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_newtype,txt_newtime,txt_detailnewdesc;
        ImageView img_detailnewimg;
        public ViewHolder(View itemView) {
            super(itemView);
            txt_newtype= (TextView) itemView.findViewById(R.id.txt_newtype);
            txt_newtime= (TextView) itemView.findViewById(R.id.txt_newtime);
            txt_detailnewdesc= (TextView) itemView.findViewById(R.id.txt_detailnewdesc);
            img_detailnewimg=(ImageView)itemView.findViewById(R.id.img_detailnewimg);
        }
    }
}
