package ${package.Controller};

import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import ${cfg.ResultBody}.ResultBody;
import ${cfg.BaseResultMessage}.BaseResultMessage;
<#if restControllerStyle>
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
</#if>

import java.util.List;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

@Slf4j
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} implements BaseResultMessage {
<#else>
public class ${table.controllerName} implements BaseResultMessage {

    @Autowired
    ${table.serviceName} ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first};

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增一条记录", notes = "新增一条记录", httpMethod = "POST")
    public ResultBody insert(@RequestBody ${entity} ${entity?uncap_first}) {
        try {
            ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.save(${entity?uncap_first});
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据主键Id 删除一条记录", notes = "根据主键Id 删除一条记录", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "主键id值", required = true, paramType = "path", dataType = "Integer")
    public ResultBody delete(@PathVariable Integer id) {
        try {
            ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.removeById(id);
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据主键Id集合 删除记录", notes = "根据主键Id集合 删除记录", httpMethod = "DELETE")
    @ApiImplicitParam(name = "ids", value = "主键id值集合", required = true, paramType = "body", dataType = "Integer")
    public ResultBody delete(@RequestBody List<Integer> ids) {
        try {
            ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.removeByIds(ids);
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "根据已有的值 更新一条记录", notes = "根据已有的值 更新一条记录", httpMethod = "PUT")
    public ResultBody update(@RequestBody ${entity} ${entity?uncap_first}) {
        try {
            ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.updateById(${entity?uncap_first});
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
    }

    @RequestMapping(value = "/updateByIds", method = RequestMethod.PUT)
    @ApiOperation(value = "根据已有的值 更新所有记录", notes = "根据已有的值 更新所有记录", httpMethod = "PUT")
    public ResultBody updateByIds(@RequestBody List<${entity}> ${entity?uncap_first}s) {
        try {
            ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.updateBatchById(${entity?uncap_first}s);
        } catch (Exception e) {
            return ResultBody.builder().code(Code.FAIL).message(e.getMessage()).build();
        }
        return ResultBody.builder().code(Code.FAIL).message(Message.SUCCESS).build();
    }


 </#if>

 }
</#if>