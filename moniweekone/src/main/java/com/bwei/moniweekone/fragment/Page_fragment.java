package com.bwei.moniweekone.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.moniweekone.R;
import com.bwei.moniweekone.adapter.MyAdapter;
import com.bwei.moniweekone.bean.Bean;
import com.bwei.moniweekone.bean.NewslistBean;
import com.bwei.moniweekone.presenter.MainPresnter;
import com.bwei.moniweekone.utils.MyApp;
import com.bwei.moniweekone.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hp on 2017/12/2.
 */
public class Page_fragment extends Fragment implements MainView {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;

    MainPresnter presnter;
    MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.page_fragment, null);
        unbinder = ButterKnife.bind(this, view);

        presnter = new MainPresnter(this);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        adapter = new MyAdapter(getActivity());
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);

        List<NewslistBean> list1 = presnter.getdb();
        if(list1 == null || list1.size() == 0){
            presnter.get();
        }else {
            adapter.addList(list1);
        }

        List<NewslistBean> list = MyApp.session.getNewslistBeanDao().loadAll();

        for (NewslistBean newslistBean : list) {
            System.out.println(newslistBean.toString());
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void Success(Bean bean) {
        adapter.addData(bean);
    }

    @Override
    public void Failure(Exception e) {

    }

}
