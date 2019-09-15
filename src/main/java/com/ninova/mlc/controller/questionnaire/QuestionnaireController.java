package com.ninova.mlc.controller.questionnaire;

import com.ninova.mlc.bl.questionnaire.QuestionnaireService;
import com.ninova.mlc.vo.CommodityForm;
import com.ninova.mlc.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class QuestionnaireController {
    @Autowired
    QuestionnaireService questionnaireService;

    @PostMapping("/addQuestionNaire")
    public ResponseVO addQuestionnaire(CommodityForm commodityForm){
        return questionnaireService.insertData(commodityForm);
    }
}
