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
     * 用户聚类类别
     */
    private int Tag;

    /**
     * 用户邮箱地址
     */
    private String emailAdd;

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
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

