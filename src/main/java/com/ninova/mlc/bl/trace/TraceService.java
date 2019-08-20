package com.ninova.mlc.bl.trace;

import com.ninova.mlc.vo.ResponseVO;
import org.springframework.stereotype.Repository;

@Repository
public interface TraceService {
    /**
     * 股票每日收益
     * @param userId
     * @param code
     * @return
     */
    public ResponseVO getStockDailyBenefit(int userId,String code);

    /**
     * 股票总收益
     * @return
     */
    public ResponseVO getStockTotalBenefit(int userId,String code);

    /**
     * 基金每日收益
     * @return
     */
    public ResponseVO getfundDailyBenefit(int userId,String code);

    /**
     * 基金总收益
     * @return
     */
    public ResponseVO getfundTotalBenefit(int userId,String code);

    /**
     * 债券每日收益
     * @return
     */
    public ResponseVO getbondDailyBenefit(int userId,String code);

    /**
     * 债券总收益
     * @return
     */
    public ResponseVO getbondTotalBenefit(int userId,String code);

    /**
     * 公司理财产品每日收益
     * @return
     */
    public ResponseVO getCFPDailyBenefit(int userId,String code);

    /**
     * 公司理财产品总收益
     * @return
     */
    public ResponseVO getCFPTotalBenefit(int userId,String code);
}
