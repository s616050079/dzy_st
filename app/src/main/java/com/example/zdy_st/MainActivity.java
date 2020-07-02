package com.example.zdy_st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.example.zdy_st.Activity.guanyuActivity;
import com.example.zdy_st.Activity.huodongActivity;
import com.example.zdy_st.Activity.loginActivity;
import com.example.zdy_st.Activity.mineinfoActivity;
import com.example.zdy_st.Activity.shetuanActivity;
import com.example.zdy_st.Activity.shezhiActivity;
import com.example.zdy_st.Bean.User;
import com.example.zdy_st.Fragment.MyFragmentPagerAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;

import static cn.bmob.v3.Bmob.getApplicationContext;


public class MainActivity extends AppCompatActivity {


    //UI Objects
    private TextView txt_topbar;
    private TextView nkname;
    private TextView auto;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_xinwen;
    private RadioButton rb_shetuan;
    private RadioButton rb_huodong;
    private RadioButton rb_mine;
    private ViewPager vpager;
    private Button bt_xinxi;
    private Button bt_shetuan;
    private Button bt_huodong;
    private Button bt_guanyu;
    private Button bt_shezhi;
    private MyFragmentPagerAdapter mAdapter;
    private String cid;


    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cid= getIntent().getStringExtra("cid");
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_xinwen.setChecked(true);
        LayoutInflater fact=LayoutInflater.from(getApplicationContext());
        View layout=fact.inflate(R.layout.header_mine,null);
        nkname=(TextView)layout.findViewById(R.id.nick_name_1);
        if (BmobUser.isLogin()) {
            String username = BmobUser.getCurrentUser(User.class).getNickName();
            if(username.isEmpty())
            {}
            else {
                nkname.setText(username);
            }
        }
    }

    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);

        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_xinwen = (RadioButton) findViewById(R.id.rb_xinwen);
        rb_shetuan = (RadioButton) findViewById(R.id.rb_shetuan);
        rb_huodong = (RadioButton) findViewById(R.id.rb_huodong);
        rb_mine = (RadioButton) findViewById(R.id.rb_mine);
        rg_tab_bar.setOnCheckedChangeListener(this::onCheckedChanged);
        bt_xinxi=(Button)findViewById(R.id.menu_bt_wodexinxi);
        bt_shetuan=(Button)findViewById(R.id.menu_bt_wodeshetuan);
        bt_huodong=(Button)findViewById(R.id.menu_bt_wodehuodong);
        bt_guanyu=(Button)findViewById(R.id.menu_bt_guanyu);
        bt_shezhi=(Button)findViewById(R.id.menu_bt_shezhi);
        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {  //设置监听事件
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == 2) {
                    switch (vpager.getCurrentItem()) {
                        case PAGE_ONE:
                            rb_xinwen.setChecked(true);
                            break;
                        case PAGE_TWO:
                            rb_shetuan.setChecked(true);
                            break;
                        case PAGE_THREE:
                            rb_huodong.setChecked(true);
                            break;
                        case PAGE_FOUR:
                            rb_mine.setChecked(true);
                            break;
                    }
                }
            }
        });

    }


    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_xinwen:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_shetuan:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_huodong:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_mine:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_wodexinxi:
                Intent intent=new Intent(MainActivity.this, mineinfoActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_wodeshetuan:
                break;
            case R.id.menu_wodehuodong:
                break;
            case R.id.nav_about:
                break;
            case R.id.nav_setting:
                break;
            default:
                break;
        }
        return true;
    }


    public void dianjixinxi(View view) {
        Intent intent=new Intent(getApplicationContext(),mineinfoActivity.class);
        startActivity(intent);
    }
    public void dianjishetuan(View view) {
        Intent intent=new Intent(getApplicationContext(), shetuanActivity.class);
        startActivity(intent);
    }
    public void dianjihuodong(View view) {
        Intent intent=new Intent(getApplicationContext(), huodongActivity.class);
        startActivity(intent);
    }
    public void dianjiguanyu(View view) {
        Intent intent=new Intent(getApplicationContext(), guanyuActivity.class);
        startActivity(intent);
    }
    public void dianjishezhi(View view) {
        Intent intent=new Intent(getApplicationContext(), shezhiActivity.class);
        startActivity(intent);
    }


}
