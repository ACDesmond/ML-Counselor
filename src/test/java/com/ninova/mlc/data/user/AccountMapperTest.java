package com.ninova.mlc.data.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void createNewAccountTest(){}

    @Test
    public void getAccountByNameTest(){}


    @Test
    public void selectUserByIdTest(){}

    @Test
    public void selectAllUsersTest(){}

    @Test
    public void updateUserTest(){}

    @Test
    public void delStaffByIdTest(){}

}
