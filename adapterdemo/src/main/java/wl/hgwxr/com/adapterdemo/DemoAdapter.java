package wl.hgwxr.com.adapterdemo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hgwxr on 2017/11/4.
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {
    private List mList;
    private DemoAdapter demoItemAdapter;

    public DemoAdapter(List list){
        if (list!=null) {
            mList = list;
        }else {
            mList=new ArrayList();
        }
    }
    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
//        if (viewType == R.layout.item_layout_1) {
//            RecyclerView recyclerViewItem = view.findViewById(R.id.item_recycler_view);
//            RecyclerView.Adapter adapter = recyclerViewItem.getAdapter();
//            if (adapter==null){
//                demoItemAdapter = new DemoAdapter(null);
//                recyclerViewItem.setLayoutManager(new LinearLayoutManager(parent.getContext(),LinearLayoutManager.HORIZONTAL,false));
//                recyclerViewItem.setAdapter(demoItemAdapter);
//            }
//        }
        return new DemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder, int position) {
        //if (position == 0) {
          //  Object o = mList.get(position);
         //   demoItemAdapter.mList.addAll(mList);
         //   demoItemAdapter.notifyDataSetChanged();

        //} else {
            String str = (String) mList.get(position);
            ((TextView) holder.itemView.findViewById(R.id.content_tv)).setText(str);
       // }
    }

    @Override
    public int getItemViewType(int position) {
        //if (position == 0) {
        //    return R.layout.item_layout_1;
        //} else {
            return R.layout.item_layout_2;
        //}
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    static class DemoViewHolder extends RecyclerView.ViewHolder {

        public DemoViewHolder(View itemView) {
            super(itemView);
        }
    }
}
