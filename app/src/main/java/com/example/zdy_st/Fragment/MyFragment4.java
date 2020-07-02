package com.example.zdy_st.Fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.zdy_st.Activity.mineinfoActivity;
import com.example.zdy_st.Bean.User;
import com.example.zdy_st.MainActivity;
import com.example.zdy_st.R;

import cn.bmob.v3.BmobUser;

import static cn.bmob.v3.Bmob.getApplicationContext;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment4 extends Fragment {

    public MyFragment4() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_mine,container,false);
        LayoutInflater fact=LayoutInflater.from(getApplicationContext());
        View layout=fact.inflate(R.layout.header_mine,null);
        TextView nkname;
        nkname=(TextView)layout.findViewById(R.id.nick_name_1);
        if (BmobUser.isLogin()) {
            String username = BmobUser.getCurrentUser(User.class).getNickName();
            if(username.isEmpty())
            {}
            else {
                nkname.setText(username);
            }
        }
        return view;
    }

}
