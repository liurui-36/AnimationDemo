package com.test.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @InjectView(R.id.list_view)
    ListView listView;

    private List<Map<String, String>> list;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.inject(this);

       setTitle("LayoutAnimation");
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", "name = " + i);
            list.add(map);
        }
    }

    @OnClick({R.id.load, R.id.clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.load:
                setAdapter();
                break;
            case R.id.clear:
                list.clear();
                simpleAdapter.notifyDataSetChanged();
                break;
        }
    }

    private void setAdapter() {
        initData();
        simpleAdapter = new SimpleAdapter(this,
                list, android.R.layout.simple_list_item_1,
                new String[]{"name"}, new int[]{android.R.id.text1});
        listView.setAdapter(simpleAdapter);
    }
}
