package com.logback.test.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/index")
   public String index(){
        logger.error("[nice]"+"addasdasdasd");
        logger.debug("Dsadasd");
        return "success";
    }
    @RequestMapping("/test")
    public String test(){
   logger.info("test");
   logger.debug("方法:{}","test(){}");
        return "test";
    }
}
