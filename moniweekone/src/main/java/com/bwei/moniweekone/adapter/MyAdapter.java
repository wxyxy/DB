package com.bwei.moniweekone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.moniweekone.R;
import com.bwei.moniweekone.bean.Bean;
import com.bwei.moniweekone.bean.NewslistBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/12/2.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<NewslistBean> list;

    public MyAdapter(Context context) {
        this.context = context;
    }
    //网络获取的值
    public void addData(Bean bean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(bean.getNewslist());
        notifyDataSetChanged();
    }
    //数据库内的值
    public void addList(List bean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(bean);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.list_item, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).item_title.setText(list.get(position).getTitle());
        ((MyViewHolder) holder).item_nr.setText(list.get(position).getCtime());
        ((MyViewHolder) holder).simple.setImageURI(list.get(position).getPicUrl());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simple;
        TextView item_title, item_nr;

        public MyViewHolder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple);
            item_title = itemView.findViewById(R.id.item_title);
            item_nr = itemView.findViewById(R.id.item_nr);
        }
    }
}
