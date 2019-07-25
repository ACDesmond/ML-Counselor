package com.ninova.mlc.blImpl.user;

import com.ninova.mlc.bl.user.AccountService;
import com.ninova.mlc.data.AccountMapper;
import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class AccountServiceImpl implements AccountService {
    private final static String ACCOUNT_EXIST = "账号已存在";

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public ResponseVO registerAccount(UserForm userForm) {
        try {
            accountMapper.createNewAccount(userForm.getUsername(), userForm.getPassword(),0);
        } catch (Exception e) {
            return ResponseVO.buildFailure(ACCOUNT_EXIST);
        }
        return ResponseVO.buildSuccess();
    }
}
