package com.shi.controller;

import com.shi.service.UserTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author DaTou
 * @Description 模板Controller
 * @Date 2020/10/13
 **/
@RestController
@Slf4j
public class TemplateController {

    @Resource
    private UserTagService userTagService;

    @GetMapping("/")
    public ModelAndView templateMapping(Map<String,Object> map){
        log.debug("模板页面测试");


        return new ModelAndView("temp/template",map);
    }

    @GetMapping("/test")
    public String testTrans(){
        userTagService.findAll();
        return "success";
    }

}
