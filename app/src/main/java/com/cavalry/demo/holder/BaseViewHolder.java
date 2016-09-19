package com.cavalry.demo.holder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import butterknife.OnClick;

/**
 * Created by Cavalry on 2016/8/6.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> views;
    public View convertView;
    public BaseViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
        this.convertView = itemView;
    }

    public <T extends View> T getView(int id){
        View view = views.get(id);
        if(view==null){
            view = convertView.findViewById(id);
            views.put(id,view);
        }
        return (T) view;
    }

    public View getConvertView(){
        return convertView;
    }

    public void setOnClickListener(int id, View.OnClickListener listener){
        getView(id).setOnClickListener(listener);
    }
}
