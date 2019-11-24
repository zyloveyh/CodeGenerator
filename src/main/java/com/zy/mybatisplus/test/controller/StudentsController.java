package com.zy.mybatisplus.test.controller;

import com.zy.mybatisplus.test.service.IStudentsService;
import com.zy.mybatisplus.test.entity.Students;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @since 2019-11-24
 */

@Slf4j
@RestController
@RequestMapping("/test/students")
public class StudentsController implements BaseResultMessage {

    @Autowired
    IStudentsService studentsService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增一条记录", notes = "新增一条记录", httpMethod = "POST")
    public ResultBody insert(Students students) {
        try {
            studentsService.save(students);
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据主键Id 删除一条记录", notes = "根据主键Id 删除一条记录", httpMethod = "DELETE")
    public ResultBody delete(@PathVariable String id) {
        try {
            studentsService.removeById(id);
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
        }



 }

