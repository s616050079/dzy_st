package com.example.zdy_st.Bean;

import cn.bmob.v3.BmobObject;

public class stuser extends BmobObject {
    private String userid;
    private String stid;
    private int stdj;
    private String getUserid(){return userid;}
    private String getStid(){return stid;}
    private int getStdj(){return stdj;}

    private void setUserid(String a){this.userid=a;}
    private void setStid(String a){this.stid=a;}
    private void setStdj(int a){this.stdj=a;}
}
