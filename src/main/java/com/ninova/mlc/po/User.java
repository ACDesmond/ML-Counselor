package com.ninova.mlc.po;

/**
 * @author huwen
 * @date 2019/3/23
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    /**
     * 用户操作权限等级，观众为0，影院经理为1，管理员为2
     */
    private int userlevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getUserlevel(){
        return userlevel;
    }

    public void setUserlevel(int userlevel){
        this.userlevel=userlevel;
    }
}
