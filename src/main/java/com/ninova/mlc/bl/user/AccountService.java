package com.ninova.mlc.bl.user;

import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.UserForm;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountService {
    /**
     * 注册账号
     * @return
     */
    ResponseVO registerAccount(UserForm userForm);
}
