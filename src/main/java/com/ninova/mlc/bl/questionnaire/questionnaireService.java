package com.ninova.mlc.bl.questionnaire;

import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.CommodityForm;
import org.springframework.stereotype.Repository;

@Repository
public interface questionnaireService {
    /**
     * 插入问卷的数据(已经有则会覆盖)
     */
    public ResponseVO insertData(CommodityForm commodity);

    /**
     * 获得现有的问卷的数据
     */
    public ResponseVO getData(int userId);

}