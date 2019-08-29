package com.ninova.mlc.data;

import com.ninova.mlc.vo.CommodityForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DataMapper {
    /**
     *插入新的金额数据
     */
    public void insertQuestionnaireData(CommodityForm commodity);

    /**
     *更新金额数据
     */
    public void deleteQuestionnaireData(int userId);

    /**
     *获取金额数据
     */
    public CommodityForm getQuestionnaireData(int userId);

}
