package com.example.zdy_st.Bean;

import cn.bmob.v3.BmobObject;

public class huodong extends BmobObject {
    private String huodongming;
    private String jbshetuan;
    private int hdid;
    private String hdshijian;
    private String hddidian;

    public String getHuodongming(){return huodongming;}
    public String getJbshetuan(){return jbshetuan;}
    public String getHdshijian(){return hdshijian;}
    public String getHddidian(){return hddidian;}
    public int getHdid() {return hdid;}

    public void setHuodongming(String a){this.huodongming=a;}
    public void setJbshetuan(String a){this.jbshetuan=a;}
    public void setHdid(int a){this.hdid=a;}
    public void setHdshijian(String a){this.hdshijian=a;}
    public void setHddidian(String a){this.hddidian=a;}

}
