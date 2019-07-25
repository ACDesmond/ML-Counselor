package com.ninova.mlc.controller.user;

import com.ninova.mlc.bl.user.AccountService;
import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author YCF
 * @date 2019/7/25
 */
@RestController()
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("/register")
    public ResponseVO registerAccount(@RequestBody UserForm userForm){
        return accountService.registerAccount(userForm);
    }
}
