package com.ninova.mlc.data.Data;

import com.ninova.mlc.vo.CommodityForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
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
