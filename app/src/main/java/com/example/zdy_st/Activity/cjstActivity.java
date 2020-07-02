package com.example.zdy_st.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zdy_st.Bean.User;
import com.example.zdy_st.Bean.shetuan;
import com.example.zdy_st.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class cjstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cjst);
        EditText stm=(EditText)findViewById(R.id.cjst_et_stm);
        EditText stjj=(EditText)findViewById(R.id.cjst_et_stjj);
        EditText sthddd=(EditText)findViewById(R.id.cjst_et_sthddd);
        Button bt=(Button)findViewById(R.id.cjst_bt_cjst);
        Toolbar toolbar=(Toolbar) findViewById(R.id.cjst_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        shetuan newst=new shetuan();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newst.setStming(stm.getText().toString().trim());
                newst.setStjj(stjj.getText().toString().trim());
                newst.setSthddd(sthddd.getText().toString().trim());
                newst.setStshezhang(BmobUser.getCurrentUser(User.class).getNickName().toString());
                newst.save(new SaveListener<String>() {
                    @Override
                    public  void  done(String objid, BmobException e){
                        if(e==null){
                            Toast.makeText(getApplicationContext(),"注册成功", Toast.LENGTH_SHORT).show();
                            User setus=new User();
                            setus.setusershetuan(stm.getText().toString().trim());
                            setus.update(BmobUser.getCurrentUser(User.class).getObjectId(), new UpdateListener() {
                                @Override
                                public void done(BmobException e) {

                                }
                            });
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
}
