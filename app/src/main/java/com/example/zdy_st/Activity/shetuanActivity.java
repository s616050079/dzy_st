package com.example.zdy_st.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zdy_st.Bean.User;
import com.example.zdy_st.Bean.shetuan;
import com.example.zdy_st.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;

public class shetuanActivity extends AppCompatActivity {

    Button bt_cj;
    TextView tv_stm;
    TextView tv_tz;
    TextView tv_jj;
    TextView tv_dd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shetuan);
        Toolbar toolbar=(Toolbar) findViewById(R.id.st_toolbar);
        bt_cj=(Button)findViewById(R.id.st_chuangjianst);
        Button bt_tc=(Button)findViewById(R.id.st_tuichust) ;
        tv_stm=(TextView)findViewById(R.id.st_tv_stm) ;
        tv_tz=(TextView)findViewById(R.id.st_sz);
        tv_jj=(TextView)findViewById(R.id.st_stjj);
        tv_dd=(TextView)findViewById(R.id.st_tv_sthddd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        cfst();
        stxx();
        bt_tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tuichu();
            }
        });
        bt_cj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),cjstActivity.class);
                startActivity(intent);
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
    public void cfst(){
        if(BmobUser.getCurrentUser(User.class).getusershetuan().toString().isEmpty()){
            bt_cj.setVisibility(View.VISIBLE);
        }
        else
        {
            bt_cj.setVisibility(View.GONE);
        }
    }
    public void stxx(){
        BmobQuery<shetuan> query = new BmobQuery<shetuan>();
        query.addWhereEqualTo("stming", BmobUser.getCurrentUser(User.class).getusershetuan().toString());
        query.findObjects(new FindListener<shetuan>() {
            @Override
            public void done(List<shetuan> object, BmobException e) {
                if(e==null){
                    for (shetuan st:object){
                        tv_stm.setText(st.getStming());
                        tv_tz.setText(st.getStshezhang());
                        tv_jj.setText(st.getStjj());
                        tv_dd.setText(st.getSthddd());
                    }
                }else{

                }
            }
        });
    }
    public void tuichu(){
        User user=new User();
        user.setusershetuan("");
        user.update(BmobUser.getCurrentUser(User.class).getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    Toast.makeText(getApplicationContext(),"退出成功",Toast.LENGTH_SHORT).show();
                    cfst();
                    stxx();
                }
            }
        });
    }
}
