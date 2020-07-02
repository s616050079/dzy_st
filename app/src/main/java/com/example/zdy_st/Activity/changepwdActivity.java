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
import com.example.zdy_st.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class changepwdActivity extends AppCompatActivity {

    EditText jiu;
    EditText xin1;
    EditText xin2;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepwd);
        Toolbar toolbar=(Toolbar) findViewById(R.id.cpwd_toolbar);
        jiu=(EditText)findViewById(R.id.cpwd_et_jiu);
        xin1=(EditText)findViewById(R.id.cpwd_et_jiu2);
        xin2=(EditText)findViewById(R.id.cpwd_et_jiu3);
        bt=(Button)findViewById(R.id.cpwd_bt_change);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void change(){
        if(xin1.getText().toString().trim().equals(xin2.getText().toString().trim())){
            User user=new User();
            user.setPassword(xin1.getText().toString().trim());
            user.update(BmobUser.getCurrentUser(User.class).getObjectId(), new UpdateListener() {
                @Override
                public void done(BmobException e) {
                    if(e==null){
                        Toast.makeText(getApplicationContext(),"修改密码成功",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}
