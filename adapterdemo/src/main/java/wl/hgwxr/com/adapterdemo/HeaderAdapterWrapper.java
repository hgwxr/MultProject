package wl.hgwxr.com.adapterdemo;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hgwxr on 2017/11/5.
 */

public class HeaderAdapterWrapper extends RecyclerView.Adapter<HeaderAdapterWrapper.StaticViewHolder>{


   // public  final int
    private List<View> mHeaders;
    private  RecyclerView.Adapter mWrapperAdaper;
    public HeaderAdapterWrapper(){
        mHeaders=new ArrayList<>();
    }

    public void addView(View view){
        mHeaders.add(view);
    }
    public void setmWrapperAdaper(RecyclerView.Adapter mWrapperAdaper) {
        this.mWrapperAdaper = mWrapperAdaper;
    }

    @Override
    public int getItemViewType(int position) {
        int hCount = getHeaderCount();
        if (position<hCount){
            return 0;
        }
        return super.getItemViewType(position);
    }

    @Override
    public StaticViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(StaticViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return getHeaderCount()+getWrapperItemCount();
    }

    private int getWrapperItemCount() {
        return mWrapperAdaper.getItemCount();
    }

    private int getHeaderCount() {
        return mHeaders.size();
    }

    protected static class StaticViewHolder extends RecyclerView.ViewHolder {

        public StaticViewHolder(View itemView) {
            super(itemView);
        }
        public  <T extends View> T getView(int id) {
            SparseArray<View> viewHolder = (SparseArray<View>) itemView.getTag();
            if (viewHolder == null) {
                viewHolder = new SparseArray<View>();
                itemView.setTag(viewHolder);
            }
            View childView = viewHolder.get(id);
            if (childView == null) {
                childView = itemView.findViewById(id);
                viewHolder.put(id, childView);
            }
            return (T) childView;
        }
    }
}
