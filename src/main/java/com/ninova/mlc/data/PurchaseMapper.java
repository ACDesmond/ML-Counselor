package com.ninova.mlc.data;

import com.ninova.mlc.po.PurchaseRecord;
import com.ninova.mlc.vo.PurchaseForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    /**
     * 插入一条记录
     * @param purchaseForm
     * @return
     */
    public int insertRecord(PurchaseForm purchaseForm);
    /**
     * 获取所有记录
     * @return
     */
    public List<PurchaseRecord> getAll();
    /**
     * 选择用户当前周期所有购买记录
     * @param userId
     * @return
     */
    public List<PurchaseRecord> selectRecordsByUserId(@Param("userId")int userId);
    /**
     * 选择用户当前周期对应产品代码的记录
     * @param userId
     * @param code
     * @return
     */
    public PurchaseRecord selectRecordByUserIdAndCode(@Param("userId")int userId,@Param("code") String code);
    /**
     * 选择用户当前周期对应产品名称的记录
     * @param userId
     * @param name
     * @return
     */
    public PurchaseRecord selectRecordByUserIdAndName(@Param("userId")int userId,@Param("name")String name);
    /**
     * 选择用户当前周期购买的同种类型产品的所有记录
     * @param userId
     * @param type
     * @return
     */
    public List<PurchaseRecord> selectRecordsByUserIdAndType(@Param("userId")int userId,@Param("type")int type);
    /**
     * 根据产品代码更新产品状态
     * @param userId
     * @param code
     * @return
     */
    public int updateStateByUserIdAndCode(@Param("userId")int userId,@Param("code") String code);
    /**
     * 根据产品名称更改状态
     *  @param userId
     *  @param name
     * @return
     */
    public int updateStateByUserIdAndName(@Param("userId")int userId,@Param("name")String name);
    /**
     * 更新产品历史涨跌记录
     * @param id
     * @param history
     */
    public int updateHistory(@Param("id")int id,@Param("history")String history);
}
