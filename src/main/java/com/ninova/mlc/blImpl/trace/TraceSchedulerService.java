package com.ninova.mlc.blImpl.trace;

import com.ninova.mlc.bl.trace.TraceService;
import com.ninova.mlc.data.PurchaseMapper;
import com.ninova.mlc.po.PurchaseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraceSchedulerService {
    @Autowired
    PurchaseMapper purchaseMapper;
    @Autowired
    TraceService traceService;
    @Scheduled(cron = "0 59 23 * * ?")
    public void recordHistory(){
        List<PurchaseRecord> records=purchaseMapper.getAll();
        for (PurchaseRecord purchaseRecord:records){
            switch (purchaseRecord.getType()){
                case 1:
                    double dailyBenefit1=(double)traceService.getfundDailyBenefit(purchaseRecord.getUserId(),purchaseRecord.getCode()).getContent();
                    purchaseMapper.updateHistory(purchaseRecord.getId(),purchaseRecord.getHistory()+","+dailyBenefit1);
                    break;
                case 2:
                    double dailyBenefit2=(double)traceService.getStockDailyBenefit(purchaseRecord.getUserId(),purchaseRecord.getCode()).getContent();
                    purchaseMapper.updateHistory(purchaseRecord.getId(),purchaseRecord.getHistory()+","+dailyBenefit2);
                    break;
                case 3:
                    double dailyBenefit3=(double)traceService.getbondDailyBenefit(purchaseRecord.getUserId(),purchaseRecord.getCode()).getContent();
                    purchaseMapper.updateHistory(purchaseRecord.getId(),purchaseRecord.getHistory()+","+dailyBenefit3);
                    break;
                default:
                    break;
            }
        }
    }
}
