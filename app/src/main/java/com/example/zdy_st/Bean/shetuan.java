package com.example.zdy_st.Bean;

import cn.bmob.v3.BmobObject;

public class shetuan extends BmobObject {
    private int shetuanid;
    private String stming;
    private String stshezhang;
    private String stjj;
    private String sthddd;

    public String getStming(){return stming;}
    public int getShetuanid(){return shetuanid;}
    public String getStshezhang(){return stshezhang;}
    public String getStjj(){return stjj;}
    public String getSthddd(){return sthddd;}

    public void setShetuanid(int a){this.shetuanid=a;}
    public void setStming(String a){this.stming=a;}
    public void setStshezhang(String a){this.stshezhang=a;}
    public void setStjj(String a){this.stjj=a;}
    public void setSthddd(String a){this.sthddd=a;}
}
