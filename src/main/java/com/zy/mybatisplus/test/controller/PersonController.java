package com.zy.mybatisplus.test.controller;

import com.zy.mybatisplus.test.service.IPersonService;
import com.zy.mybatisplus.test.entity.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import com.zy.mybatisplus.test.entity.ResultBody;
import com.zy.mybatisplus.test.message.BaseResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 人员信息表 前端控制器
 * </p>
 *
 * @author zy
 * @since 2019-11-24
 */

@Slf4j
@RestController
@RequestMapping("/test/person")
public class PersonController implements BaseResultMessage {

    @Autowired
    IPersonService personService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增一条记录", notes = "新增一条记录", httpMethod = "POST")
    public ResultBody insert(@RequestBody Person person) {
        try {
            personService.save(person);
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据主键Id 删除一条记录", notes = "根据主键Id 删除一条记录", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "ido", required = true, paramType = "path", dataType = "String")
    public ResultBody delete(@PathVariable String id) {
        try {
            personService.removeById(id);
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "根据主键Id 更新一条记录", notes = "根据主键Id 更新一条记录", httpMethod = "PUT")
    public ResultBody update(@RequestBody Person person) {
        try {
            personService.updateById(person);
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
    }

}

