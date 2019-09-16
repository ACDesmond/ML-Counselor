package com.ninova.mlc.data;
import com.ninova.mlc.data.Purchase.PurchaseMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PurchaseMapperTest {

    @Autowired
    PurchaseMapper purchaseMapper;

    @Test
    public void insertRecordTest(){}

    @Test
    public void getAllTest(){}

    @Test
    public void selectRecordsByUserIdTest(){}

    @Test
    public void selectRecordByUserIdAndCodeTest(){}

    @Test
    public void selectRecordByUserIdAndNameTest(){}

    @Test
    public void selectRecordsByUserIdAndTypeTest(){}

    @Test
    public void updateStateByUserIdAndCodeTest(){}

    @Test
    public void updateStateByUserIdAndNameTest(){}

    @Test
    public void updateHistoryTest(){}


}
