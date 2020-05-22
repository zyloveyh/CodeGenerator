package ${package.Controller};

import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.springframework.web.bind.annotation.*;
import com.chinastock.uniplatform.springboot.bean.*;
import com.chinastock.uniplatform.springboot.bean.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
</#if>
import com.chinastock.itesty.common.utils.BaseResponseBuilder;
import java.util.*;
import ${cfg.ParamCheckUtil}.ParamCheckUtil;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} {
<#else>
public class ${table.controllerName} {

    private static Logger log = LoggerFactory.getLogger(${table.controllerName}.class);

    @Autowired
    ${table.serviceName} ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first};

    @RequestMapping(value = "/insert", method = RequestMethod.POST, headers = "Content-Type=application/json;charset=UTF-8")
    @ApiOperation(value = "新增一条记录", notes = "新增一条记录", httpMethod = "POST")
    public BaseResponse${r"<"}Object${r">"} insert(@RequestBody BaseRequest${r"<"}${entity}${r">"} baseRequest) {
        Meta meta = ParamCheckUtil.checkInsertParam(baseRequest);
        if (!meta.isSuccess()) {
            return BaseResponseBuilder.fail(meta);
        }

        Integer data = 0;
        try {
            data = ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.insert(baseRequest.getParam());
        } catch (Exception e) {
            log.error("insert fail detail Info:" + e.getMessage());
            return BaseResponseBuilder.fail(ResponseStatus.SYS_BUSY.getCode(), e.getMessage());
        }
            return BaseResponseBuilder.success(data);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST, headers = "Content-Type=application/json;charset=UTF-8")
    @ApiOperation(value = "新增一条记录 insertSelective", notes = "新增一条记录 Selective", httpMethod = "POST")
    public BaseResponse${r"<"}Object${r">"} insertSelective(@RequestBody BaseRequest${r"<"}${entity}${r">"} baseRequest) {
        Meta meta = ParamCheckUtil.checkInsertParam(baseRequest);
        if (!meta.isSuccess()) {
            return BaseResponseBuilder.fail(meta);
        }

        Integer data = 0;
        try {
            data = ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.insertSelective(baseRequest.getParam());
        } catch (Exception e) {
            log.error("insertSelective fail detail Info:" + e.getMessage());
            return BaseResponseBuilder.fail(ResponseStatus.SYS_BUSY.getCode(), e.getMessage());
        }
        return BaseResponseBuilder.success(data);
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据主键Id 删除一条记录", notes = "根据主键Id 删除一条记录", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "主键id值", required = true, paramType = "path", dataType = "Integer")
    public BaseResponse${r"<"}Object${r">"} delete(@PathVariable Long id) {
        int num = 0;

        try {
            num = ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.deleteByPrimaryKey(id);
        } catch (Exception e) {
            log.error("deleteByPrimaryKey fail detail Info:" + e.getMessage());
            return BaseResponseBuilder.fail(ResponseStatus.SYS_BUSY.getCode(), e.getMessage());
        }
        if (num == 0) {
            //无此记录
            return BaseResponseBuilder.success("无此记录");
        }
        return BaseResponseBuilder.success(num);
    }



    @RequestMapping(value = "/updateSelective", method = RequestMethod.PUT, headers = "Content-Type=application/json;charset=UTF-8")
    @ApiOperation(value = "根据已有的值 更新一条记录", notes = "根据已有的值 更新一条记录", httpMethod = "PUT")
    public BaseResponse${r"<"}Object${r">"} updateSelective(@RequestBody BaseRequest${r"<"}${entity}${r">"} baseRequest) {
        Meta meta = ParamCheckUtil.checkUpdateParam(baseRequest);
        if (!meta.isSuccess()) {
            return BaseResponseBuilder.fail(meta);
        }
        int num = 0;
        try {
            num = ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.updateByPrimaryKeySelective(baseRequest.getParam());
        } catch (Exception e) {
            log.error("updateByPrimaryKeySelective fail detail Info:" + e.getMessage());
            return BaseResponseBuilder.fail(ResponseStatus.SYS_BUSY.getCode(), e.getMessage());
        }
        return BaseResponseBuilder.success(num);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id 查找一条记录", notes = "根据Id 查找一条记录", httpMethod = "GET")
    public BaseResponse${r"<"}${entity}${r">"} getById(@PathVariable Long id) {
        ${entity} data = null;
        try {
            data = ${(table.serviceName?substring(1,(table.serviceName)?length))?uncap_first}.getById(id);
        } catch (Exception e) {
            log.error("getById fail detail Info:" + e.getMessage());
            return new BaseResponseEntity${r"<"}${entity}${r">"}().fail(ResponseStatus.SYS_BUSY.getCode(), e.getMessage());
        }
        return new BaseResponseEntity${r"<"}${entity}${r">"}().success(data)
    }


 </#if>

 }
</#if>