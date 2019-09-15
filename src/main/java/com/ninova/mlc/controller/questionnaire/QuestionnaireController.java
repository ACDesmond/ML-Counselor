package com.ninova.mlc.controller.questionnaire;

import com.ninova.mlc.bl.questionnaire.QuestionnaireService;
import com.ninova.mlc.vo.CommodityForm;
import com.ninova.mlc.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class QuestionnaireController {
    @Autowired
    QuestionnaireService questionnaireService;

    @RequestMapping(value = "/addQuestionNaire", method = RequestMethod.POST)
    public ResponseVO addQuestionnaire(@RequestBody CommodityForm commodityForm){
        return questionnaireService.insertData(commodityForm);
    }
}
