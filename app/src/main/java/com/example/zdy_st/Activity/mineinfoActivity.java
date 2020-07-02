package com.example.zdy_st.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.zdy_st.Bean.User;
import com.example.zdy_st.Bean.shetuan;
import com.example.zdy_st.R;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class mineinfoActivity extends AppCompatActivity {

    EditText nkname;
    EditText gerenqm;
    TextView stm;
    EditText zsxm;
    RadioButton nan;
    RadioButton nv;
    EditText xuey;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mineinfo);
        Button bt_xiugai=(Button)findViewById(R.id.mif_bt_xiugaimima);
        Button bt_querenxiugai=(Button)findViewById(R.id.mif_bt_xiugai);
        nkname=(EditText)findViewById(R.id.mif_et_nickname);
        gerenqm=(EditText)findViewById(R.id.mif_et_gerenqianming);
        stm=(TextView)findViewById(R.id.mif_tv_shetuanming2);
        zsxm=(EditText)findViewById(R.id.mif_et_realname);
        nan=(RadioButton)findViewById(R.id.mif_rb_nan);
        nv=(RadioButton)findViewById(R.id.mif_rb_nv);
        xuey=(EditText)findViewById(R.id.mif_et_xueyuan);
        rg=(RadioGroup)findViewById(R.id.mif_rg) ;
        Toolbar toolbar=(Toolbar) findViewById(R.id.mif_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        bt_xiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mineinfoActivity.this,changepwdActivity.class);
                startActivity(intent);
            }
        });
        bt_querenxiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wdxx();
            }
        });
        wodxx();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void wdxx(){
        User user=new User();
        user.setNickName(nkname.getText().toString().trim());
        user.setAutograph(gerenqm.getText().toString().trim());
        RadioButton rb=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
        user.setSex(rb.getText().toString().trim());
        user.setRealname(zsxm.getText().toString().trim());
        user.setXueyuan(xuey.getText().toString().trim());
        user.update(BmobUser.getCurrentUser(User.class).getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    Toast.makeText(getApplicationContext(),"更新成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void wodxx(){
        nkname.setText(BmobUser.getCurrentUser(User.class).getNickName());
        gerenqm.setText(BmobUser.getCurrentUser(User.class).getAutograph());
        stm.setText(BmobUser.getCurrentUser(User.class).getusershetuan());
        zsxm.setText(BmobUser.getCurrentUser(User.class).getRealname());
        xuey.setText(BmobUser.getCurrentUser(User.class).getXueyuan());
    }
}
