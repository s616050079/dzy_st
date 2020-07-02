package com.example.zdy_st.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zdy_st.R;

public class huodongAdapter extends RecyclerView.Adapter<huodongAdapter.huodongViewHolder> {
    private String[] mDataSet;
    private OnRecyclerItemClickListener monItemClickListener;

    public void setRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        monItemClickListener=listener;
    }
    public interface OnRecyclerItemClickListener {
        //RecyclerView的点击事件，将信息回调给view
        void onRecyclerItemClick(int Position);
    }
    public  class huodongViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView1;
        public huodongViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.tx_huodongming);
            textView1=view.findViewById(R.id.tx_faqishetuan1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (monItemClickListener!=null){
                        monItemClickListener.onRecyclerItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public huodongAdapter(String[] mDataSet) {
        this.mDataSet = mDataSet;
    }

    //加载item的布局，并且创建ViewHolder实例
    @Override
    public huodongAdapter.huodongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fg_huodong, parent, false);
        huodongViewHolder vh = new huodongViewHolder(view);
        return vh;
    }

    //给item填充数据
    @Override
    public void onBindViewHolder(huodongAdapter.huodongViewHolder holder, int position) {
        holder.textView.setText(mDataSet[position]);

    }


    //返回Item的个数
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
