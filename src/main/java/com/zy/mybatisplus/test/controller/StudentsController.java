package com.zy.mybatisplus.test.controller;

import com.zy.mybatisplus.test.service.IStudentsService;
import com.zy.mybatisplus.test.entity.Students;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import com.zy.mybatisplus.test.entity.ResultBody;
import com.zy.mybatisplus.test.message.BaseResultMessage;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
* <p>
* 学生信息表 前端控制器
* </p>
*
* @author zy
* @since 2019-11-23
*/

@Slf4j
@RestController
@RequestMapping("/test/students")
public class StudentsController implements BaseResultMessage {

    @Autowired
    IStudentsService studentsService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "insert", notes = "新增一条记录", httpMethod = "POST")
    public ResultBody insert(Students students) {
        try {
            studentsService.save(students);
        } catch (Exception e) {
            return ResultBody.builder().code("0001").message(e.getMessage()).build();
        }
        return ResultBody.builder().code("0000").message("").build();
    }



 }
