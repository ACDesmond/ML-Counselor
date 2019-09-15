package com.ninova.mlc.controller.Trace;


import com.ninova.mlc.bl.trace.TraceService;
import com.ninova.mlc.vo.PurchaseForm;
import com.ninova.mlc.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController()
public class TraceController {
    @Autowired
    TraceService traceService;

    /**
     //获取所有产品收益
     @PostMapping("/all")
     public ResponseVO getAll(@RequestParam int userId){
     return traceService.getAll(userId);
     }

     //获取特定产品收益
     @PostMapping("/specific")
     public ResponseVO getSpecific(@RequestParam int userId,@RequestParam String code){
     return traceService.getSpecific(userId,code);
     }

     //获取某种产品每日收益记录
     @PostMapping("/hostory")
     public ResponseVO getHistory(@RequestParam int userId,@RequestParam String code){
     return traceService.getHistory(userId,code);
     }
     **/

    //获取某位用户所有产品最近30日的收益
    @GetMapping("/monthHistory/{userId}")
    public ResponseVO getMonthHistory(@PathVariable int userId){
        return traceService.getMonthHistory(userId);
    }

    @GetMapping("/addPurchase/{userId}/{code}/{number}")
    public ResponseVO addPurchase(@PathVariable int userId, @PathVariable String code, @PathVariable int number){
        return traceService.addPurchase(userId,code,number, new Timestamp(new Date().getTime()));
    }

    //获取message
    @GetMapping("/getTotal/{userId}")
    public ResponseVO getTotal(@PathVariable int userId){
        return traceService.getTotal(userId);
    }


}
