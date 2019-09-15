package com.ninova.mlc.controller.scheme;

import com.ninova.mlc.controller.questionnaire.QuestionnaireController;
import com.ninova.mlc.controller.scheme.SchemeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@SpringBootTest
@RunWith(SpringRunner.class)
public class SchemeControllerTest {

    private MockMvc mockMvc;
    @Autowired
    SchemeController schemeController;

    @Test
    public void registerAccount(){

    }

}
