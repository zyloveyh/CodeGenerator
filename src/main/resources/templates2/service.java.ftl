package ${package.Service};

import ${package.Entity}.${entity};
import java.util.*;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} {
    public Integer insert(${entity} entity);

    public Integer insertSelective(${entity} entity);

    public Integer deleteByPrimaryKey(Long id);

    public Integer updateByPrimaryKeySelective(${entity} entity);

     public ${entity} getById(Long id);
}
</#if>
