package com.example.zdy_st.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zdy_st.Bean.User;
import com.example.zdy_st.MainActivity;
import com.example.zdy_st.R;
import com.google.android.material.snackbar.Snackbar;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FetchUserInfoListener;
import cn.bmob.v3.listener.LogInListener;

public class loginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Button bt_register=(Button)findViewById(R.id.bt_registertologin);
        Button bt_login=(Button)findViewById(R.id.bt_login);
        EditText et_user=(EditText)findViewById(R.id.et_user);
        EditText et_pwd=(EditText)findViewById(R.id.et_pwd);
        Bmob.initialize(this, "eaf2679c35d76b33c5ec1e71b8827b00");
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginActivity.this,registerActivity.class);
                startActivity(intent);
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser.loginByAccount(et_user.getText().toString().trim(), et_pwd.getText().toString().trim(), new LogInListener<User>() {

                    @Override
                    public void done(User user, BmobException e) {
                        if(user!=null){
                            Toast.makeText(loginActivity.this,user.getNickName()+"登陆成功",Toast.LENGTH_SHORT).show();
                            fetchUserInfo(v);
                            Intent intent=new Intent(loginActivity.this, MainActivity.class);
                            intent.putExtra("cid",user.getObjectId());
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
    private void fetchUserInfo(final View view) {
        BmobUser.fetchUserInfo(new FetchUserInfoListener<BmobUser>() {
            @Override
            public void done(BmobUser user, BmobException e) {
                if (e == null) {
                    final User myUser = BmobUser.getCurrentUser(User.class);

                } else {
                    Log.e("error",e.getMessage());
                }
            }
        });
    }
}
