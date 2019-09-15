package com.ninova.mlc.blImpl.questionnaire;

import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.CommodityForm;
import com.ninova.mlc.data.Data.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class questionnaireServiceImpl {
    @Autowired
    private DataMapper dataMapper;

    public ResponseVO insertData(CommodityForm commodity){
        try {
            int userId=commodity.getUserId();
            dataMapper.deleteQuestionnaireData(userId);
            dataMapper.insertQuestionnaireData(commodity);
            return ResponseVO.buildSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }

    }
    public ResponseVO getData(int userId){
        try {
            return ResponseVO.buildSuccess(dataMapper.getQuestionnaireData(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }

    }
}