package wl.hgwxr.com.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("我是"+ i);
        }
        DemoAdapter demoAdapter = new DemoAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeaderViewRecyclerAdapter hAdapter = new HeaderViewRecyclerAdapter(demoAdapter);

        recyclerView.setAdapter(hAdapter);


        View view = LayoutInflater.from(this).inflate(R.layout.item_layout_1, null, false);
        RecyclerView itemRecyclerView1 = view.findViewById(R.id.item_recycler_view_1);

        itemRecyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        itemRecyclerView1.setAdapter(demoAdapter);
        hAdapter.addHeaderView(view);
        demoAdapter.notifyItemChanged(0);

        RecyclerView itemRecyclerView = (RecyclerView) findViewById(R.id.item_recycler_view);
        itemRecyclerView.setAdapter(demoAdapter);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



    }
}
