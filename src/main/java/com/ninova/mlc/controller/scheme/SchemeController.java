package com.ninova.mlc.controller.scheme;

import com.ninova.mlc.bl.Scheme.SchemeService;
import com.ninova.mlc.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class SchemeController {

    @Autowired
    SchemeService schemeService;

    @GetMapping("/getScheme/{userID}")
    public ResponseVO registerAccount(@PathVariable int userID){
        return schemeService.acquireScheme(userID);
    }
}
