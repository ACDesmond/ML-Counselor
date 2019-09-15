package com.ninova.mlc.blImpl.trace;

import com.ninova.mlc.blImpl.trace.TraceServiceImpl;
import com.ninova.mlc.vo.ResponseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TraceTest {

    @Autowired
    TraceServiceImpl traceService;


    @Test
    public void testGetMonth(){
        ResponseVO responseVO=traceService.getSpecific(1,"200");
        assertNotNull(responseVO.getContent());
    }

    @Test
    public void testGetAll(){
        ResponseVO responseVO=traceService.getAll(1);
        assertNotNull(responseVO.getContent());
    }

    @Test
    public void testGetSpecific(){
        ResponseVO responseVO=traceService.getSpecific(1,"200");
        assertNotNull(responseVO.getContent());
    }

    @Test
    public void testGetHistory(){
        ResponseVO responseVO=traceService.getHistory(2,"200");
        assertNotNull(responseVO.getContent());
    }
}
