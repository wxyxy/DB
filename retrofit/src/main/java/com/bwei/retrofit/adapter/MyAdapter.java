package com.bwei.retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.retrofit.R;
import com.bwei.retrofit.Bean;
import com.bwei.retrofit.NewslistBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/12/1.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<NewslistBean> list;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void addData(Bean bean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(bean.getNewslist());
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rv_item, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder) holder).item_title.setText(list.get(position).getTitle());
        ((MyViewHolder) holder).item_date.setText(list.get(position).getCtime());
        ((MyViewHolder) holder).simple.setImageURI(list.get(position).getPicUrl());

        ((MyViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.click(view, position);
                String s = list.get(position).getTitle();
                EventBus.getDefault().postSticky(s);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simple;
        TextView item_title, item_date;

        public MyViewHolder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple);
            item_title = itemView.findViewById(R.id.item_title);
            item_date = itemView.findViewById(R.id.item_date);
        }
    }

    private onClickListener listener;

    public void setClickListener(onClickListener listener) {
        this.listener = listener;
    }

    public interface onClickListener {
        void click(View view, int postion);
    }
}
