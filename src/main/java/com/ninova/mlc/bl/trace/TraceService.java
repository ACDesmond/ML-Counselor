package com.ninova.mlc.bl.trace;

import com.ninova.mlc.vo.PurchaseForm;
import com.ninova.mlc.vo.ResponseVO;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface TraceService {
    /**
     * 获得当前周期所有产品收益追踪
     * @param userId
     * @return
     */
    public ResponseVO getAll(int userId);

    /**
     * 获得某一产品的收益追踪
     * @param userId
     * @param code
     * @return
     */
    public ResponseVO getSpecific(int userId,String code);

    /**
     * 获得某一产品的历史收益信息
     * @param userId
     * @param code
     * @return
     */
    public ResponseVO getHistory(int userId,String code);

    /**
     * 获得某一用户所有产品的最近七日收益
     * @param userId
     * @return
     */
    public ResponseVO getMonthHistory(int userId);

    /**
     * 增加记录
     * @param userId
     * @param code
     * @param number
     * @param startTime
     * @return
     */
    public ResponseVO addPurchase(int userId, String code, int number, Timestamp startTime);

    /**
     * 获得累积收益
     * @return
     */
    public ResponseVO getTotal(int userId);
}
