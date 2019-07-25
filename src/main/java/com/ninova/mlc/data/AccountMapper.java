package com.ninova.mlc.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
    /**
     * 创建一个新的账号
     * @param username
     * @param password
     * @param userlevel
     * @return
     */
    public int createNewAccount(@Param("username") String username, @Param("password") String password, @Param("userlevel") int userlevel);

}
