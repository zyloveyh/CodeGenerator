package ${package.Controller};

import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import ${package.Entity}.ResultBody;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
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
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {

    @Autowired
    ${table.serviceName} ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first};

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "insert", notes = "新增一条记录", httpMethod = "POST")
    public ResultBody insert(${entity} ${entity?uncap_first}) {
        try {
            ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.save(${entity?uncap_first});
        } catch (Exception e) {
            return ResultBody.builder().code("0001").message(e.getMessage()).build();
        }
        return ResultBody.builder().code("0000").message("").build();
    }


 </#if>

 }
</#if>

