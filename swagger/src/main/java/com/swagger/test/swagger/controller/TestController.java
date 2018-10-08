package com.swagger.test.swagger.controller;

import com.swagger.test.swagger.dto.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试",description = "测试",tags = "Test")
@RequestMapping("/test")
@RestController
public class TestController {
    @ApiOperation(value = "添加测试", notes = "输入正确的参数")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "true"), @ApiResponse(code = 405, message = "false")})

    public String addTest(){
        return "add success";
    }
    @ApiOperation(value = "获取测试", notes = "获取参数必须合法")
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "true"), @ApiResponse(code = 405, message = "false")})
    public String selectTest(){
        return "get success";
    }
    @ApiOperation(value = "删除测试", notes = "获取参数必须合法")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "true"), @ApiResponse(code = 405, message = "false")})
    public String deleteTest(){
        return "delete success";
    }
}
