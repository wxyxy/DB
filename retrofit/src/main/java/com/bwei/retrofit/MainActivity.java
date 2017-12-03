package com.bwei.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwei.retrofit.adapter.MyAdapter;
import com.bwei.retrofit.presenter.MainPresenter;
import com.bwei.retrofit.utils.MyApp;
import com.bwei.retrofit.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.rv)
    RecyclerView rv;

    MainPresenter presenter;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);
        presenter.get();

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new MyAdapter(this);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        adapter.setClickListener(new MyAdapter.onClickListener() {
            @Override
            public void click(View view, int postion) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        List<NewslistBean> listBeans = MyApp.session.getNewslistBeanDao().loadAll();

        for (NewslistBean bean : listBeans) {
            System.out.println(bean.toString());
        }
    }

    @Override
    public void Success(Bean bean) {
        adapter.addData(bean);
    }

    @Override
    public void Failure(Exception e) {

    }
}
