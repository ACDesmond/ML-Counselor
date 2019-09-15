package com.ninova.mlc.blImpl.questionnaireImpl;

import com.ninova.mlc.bl.questionnaire.QuestionnaireService;
import com.ninova.mlc.vo.ResponseVO;
import com.ninova.mlc.vo.CommodityForm;
import com.ninova.mlc.data.Data.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

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