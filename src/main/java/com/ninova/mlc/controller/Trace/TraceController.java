package com.ninova.mlc.controller.Trace;


import com.ninova.mlc.bl.trace.TraceService;
import com.ninova.mlc.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/trace")
public class TraceController {
    @Autowired
    TraceService traceService;

    //获取所有产品收益
    @PostMapping("/all")
    public ResponseVO getAll(@RequestParam int userId){
        return traceService.getAll(userId);
    }

    //获取特定产品收益
    @PostMapping("specific")
    public ResponseVO getSpecific(@RequestParam int userId,@RequestParam String code){
        return traceService.getSpecific(userId,code);
    }

    //获取某种产品每日收益记录
    @PostMapping("/hostory")
    public ResponseVO getHistory(@RequestParam int userId,@RequestParam String code){
        return traceService.getHistory(userId,code);
    }

}
