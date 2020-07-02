package com.example.zdy_st.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zdy_st.Bean.User;
import com.example.zdy_st.R;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class registerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText et_username=(EditText)findViewById(R.id.et_user_re);
        EditText et_pwd=(EditText)findViewById(R.id.et_pwd_rg);
        EditText et_pwd_re=(EditText)findViewById(R.id.et_pwd_rg_re);
        EditText et_name=(EditText)findViewById(R.id.et_name);
        Button bt_zhuce=(Button)findViewById(R.id.bt_registertologin);
        User newuser=new User();
        bt_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_pwd.getText().toString().trim().equals(et_pwd_re.getText().toString().trim())){
                    newuser.setUsername(et_username.getText().toString().trim());
                    newuser.setPassword(et_pwd.getText().toString().trim());
                    newuser.setNickName(et_name.getText().toString().trim());
                    newuser.signUp(new SaveListener<User>() {
                        @Override
                        public  void  done(User u, BmobException e){
                            if(e==null){
                                Toast.makeText(getApplicationContext(),"注册成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"密码不一致", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
