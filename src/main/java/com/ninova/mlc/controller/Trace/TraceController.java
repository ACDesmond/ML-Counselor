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
    //股票日收益
    @PostMapping("/stockDayly")
    public ResponseVO getStockDaily(@RequestParam int userId,@RequestParam String code){
        return traceService.getStockDailyBenefit(userId,code);
    }
    //股票累积收益
    @PostMapping("/stockTotal")
    public ResponseVO getStockTotal(@RequestParam int userId,@RequestParam String code){
        return traceService.getStockTotalBenefit(userId,code);
    }
    //基金日收益
    @PostMapping("/fundDayly")
    public ResponseVO getFundDaily(@RequestParam int userId,@RequestParam String code){
        return traceService.getfundDailyBenefit(userId,code);
    }
    //基金累积收益
    @PostMapping("/fundTotal")
    public ResponseVO getFundTotal(@RequestParam int userId,@RequestParam String code){
        return traceService.getfundTotalBenefit(userId,code);
    }
    //债券日收益
    @PostMapping("/bondDayly")
    public ResponseVO getBondDaily(@RequestParam int userId,@RequestParam String code){
        return traceService.getbondDailyBenefit(userId,code);
    }
    //债券累积收益
    @PostMapping("/bondTotal")
    public ResponseVO getBondTotal(@RequestParam int userId,@RequestParam String code){
        return traceService.getbondTotalBenefit(userId,code);
    }
    //获取某种产品每日收益记录
    @PostMapping("/hostory")
    public ResponseVO getHistory(@RequestParam int userId,@RequestParam String code){
        return traceService.getHistory(userId,code);
    }

}
