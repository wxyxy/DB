package com.bwei.moniweekone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bwei.moniweekone.fragment.Idea_fragment;
import com.bwei.moniweekone.fragment.Market_fragment;
import com.bwei.moniweekone.fragment.More_fragment;
import com.bwei.moniweekone.fragment.Notice_fragment;
import com.bwei.moniweekone.fragment.Page_fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    Fragment[] fragments = {
            new Page_fragment(),
            new Idea_fragment(),
            new Market_fragment(),
            new Notice_fragment(),
            new More_fragment()
    };
    int index;
    int currentTabIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.page:
                        index = 0;
                        break;
                    case R.id.idea:
                        index = 1;
                        break;
                    case R.id.market:
                        index = 2;
                        break;
                    case R.id.notice:
                        index = 3;
                        break;
                    case R.id.more:
                        index = 4;
                        break;
                }
                if (currentTabIndex != index) {
                    FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
                    trx.hide(fragments[currentTabIndex]);
                    if (!fragments[index].isAdded()) {
                        trx.add(R.id.fl, fragments[index]);
                    }
                    trx.show(fragments[index]).commit();
                }
                currentTabIndex = index;
            }
        });
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl, fragments[0])
                .add(R.id.fl, fragments[4])
                .hide(fragments[4])
                .show(fragments[0])
                .commit();
    }
}
