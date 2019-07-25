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
     * 用户操作权限等级，观众为0，影院经理为1，管理员为2
     */
    private int userlevel;


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

    public int getUserlevel(){
        return userlevel;
    }

    public void setUserlevel(int userlevel){
        this.userlevel=userlevel;
    }
}

