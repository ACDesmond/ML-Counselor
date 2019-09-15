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
            String history=purchaseRecord.getHistory();
            double todayBenefit=(double)traceService.getSpecific(purchaseRecord.getUserId(),purchaseRecord.getCode()).getContent();
            history=history+","+todayBenefit;
            purchaseMapper.updateHistory(purchaseRecord.getId(),history);
            }
        }
}
