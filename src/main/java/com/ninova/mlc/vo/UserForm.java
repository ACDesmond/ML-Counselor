package com.ninova.mlc.vo;

public class UserForm {
    /**
     * 用户名，不可重复
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户聚类类别，观众为0，影院经理为1，管理员为2
     */
    private int Tag;
    /**
     * 用户手机号码
     */
    private int Tel;

    public int getTel() {
        return Tel;
    }

    public void setTel(int tel) {
        Tel = tel;
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTag(){
        return Tag;
    }

    public void setTag(int Tag){
        this.Tag=Tag;
    }
}

