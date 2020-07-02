package com.example.zdy_st.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zdy_st.R;

public class shetuanAdapter extends RecyclerView.Adapter<shetuanAdapter.shetuanViewHolder> {
    private String[] mDataSet;
    private OnRecyclerItemClickListener monItemClickListener;

    public void setRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        monItemClickListener=listener;
    }
    public interface OnRecyclerItemClickListener {
        //RecyclerView的点击事件，将信息回调给view
        void onRecyclerItemClick(int Position);
    }

    public static class shetuanViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView1;
        public shetuanViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.tx_shetuanming);
            textView1=view.findViewById(R.id.tx_shetuan_shezhang);
        }
    }

    public shetuanAdapter(String[] mDataSet) {
        this.mDataSet = mDataSet;
    }

    //加载item的布局，并且创建ViewHolder实例
    @Override
    public shetuanAdapter.shetuanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shetuan_list, parent, false);
        shetuanAdapter.shetuanViewHolder vh = new shetuanAdapter.shetuanViewHolder(view);
        return vh;
    }

    //给item填充数据
    @Override
    public void onBindViewHolder(shetuanAdapter.shetuanViewHolder holder, int position) {
        holder.textView.setText(mDataSet[position]);
    }

    //返回Item的个数
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
