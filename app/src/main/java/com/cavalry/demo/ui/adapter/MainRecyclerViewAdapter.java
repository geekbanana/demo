package com.cavalry.demo.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cavalry.demo.R;
import com.cavalry.demo.entity.MainEntity;
import com.cavalry.demo.holder.BaseViewHolder;
import com.cavalry.demo.section.BaseSection;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Cavalry on 2016/7/31.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final int VIEW_TYPE_HEAD = 0x1;
    private final int VIEW_TYPE_CONTENT = 0x2;

    private final static String TAG = "MainRecyclerViewAdapter";
    private static List<BaseSection<MainEntity>> mData;

    private Context mContext;
    private final LayoutInflater mLayoutInflater;

    public MainRecyclerViewAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public MainRecyclerViewAdapter(Context context,List<BaseSection<MainEntity>> data){
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==VIEW_TYPE_HEAD){
            return new BaseViewHolder(mLayoutInflater.inflate(R.layout.item_section_head,parent,false));
        }else{
            return new BaseViewHolder(mLayoutInflater.inflate(R.layout.item_section_content,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        if(holder.getItemViewType()==VIEW_TYPE_HEAD){
            if(holder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
                StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
                layoutParams.setFullSpan(true);
            }
            TextView tvHead = holder.getView(R.id.tv_head);
            tvHead.setText(getItem(position).headText);
        }else{
            TextView tvContent = holder.getView(R.id.tv_content);
            tvContent.setText(getItem(position).content.name);
            holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,getItem(position).content.clazz);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mData==null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position).isHead){
            return VIEW_TYPE_HEAD;
        }else{
            return VIEW_TYPE_CONTENT;
        }
    }

    /**
        ====================================自定义内容区域===================================
     */

    public BaseSection<MainEntity> getItem(int position){
        if(mData!=null && mData.size()>position){
            return mData.get(position);
        }else{
            return null;
        }
    }

    public MainEntity getItemContent(int position){
       return getItem(position).content;
    }

}
