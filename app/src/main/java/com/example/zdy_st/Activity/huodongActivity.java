package com.example.zdy_st.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.zdy_st.Adapter.huodongAdapter;
import com.example.zdy_st.R;

public class huodongActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private huodongAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huodong);
        Toolbar toolbar=(Toolbar) findViewById(R.id.hd_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        initDate();      //初始数据
        mRecycleView = findViewById(R.id.hd_rv);
        mRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));   //设置水平分割线
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));   //recycleView必须要布局管理器
        mAdapter = new huodongAdapter(mDataSet);           //实例化适配器
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setRecyclerItemClickListener(new huodongAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onRecyclerItemClick(int Position) {
                //具体的操作逻辑
                Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    private void initDate(){
        mDataSet = new String[10];
        for (int i = 0;i<10;i++){
            mDataSet[i] = "This is item "+ i;
        }
    }
}
