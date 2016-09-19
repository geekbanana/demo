package com.cavalry.demo.dropdownmenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cavalry.demo.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Cavalry on 2016/8/5.
 */
public class DropDownMenuAdapter extends RecyclerView.Adapter<DropDownMenuAdapter.DropDownMenuViewHolder> {


    private List<String> mData;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public DropDownMenuAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public DropDownMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DropDownMenuViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(DropDownMenuViewHolder holder, int position) {
        holder.tv.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public static class DropDownMenuViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv)
        TextView tv;

        public DropDownMenuViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
