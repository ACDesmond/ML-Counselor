package com.ninova.mlc.data.user;

import com.ninova.mlc.data.user.VerfCodeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class VerfCodeMapperTest {

    @Autowired
    VerfCodeMapper verfCodeMapper;

    @Test
    public void addVerfCodeTest(){}

    @Test
    public void getVerfCodeTest(){};

    @Test
    public void deleteCodeTest(){};

    @Test
    public void cleanExpiredCodeTest(){};

}
