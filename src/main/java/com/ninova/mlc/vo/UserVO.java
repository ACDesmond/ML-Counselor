package com.ninova.mlc.vo;

import com.ninova.mlc.po.User;

/**
 * @author ycf
 * @date 2019/7/26 3
 */
public class UserVO {
    private Integer id;
    private String username;
    private String password;
    /**
     * 用户操作权限等级，观众为0，影院经理为1，管理员为2
     */
    private int Tag;



    private String emailAdd;

    public UserVO(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.Tag= user.getTag();
        this.emailAdd= user.getEmailAdd();
    }
    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

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

    public int getTag(){
        return Tag;
    }

    public void setTag(int Tag){
        this.Tag=Tag;
    }
}
