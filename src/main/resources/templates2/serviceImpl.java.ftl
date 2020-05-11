package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {
}
<#else>
public class ${table.serviceImplName} implements ${table.serviceName} {

    private static Logger log = LoggerFactory.getLogger(${table.serviceImplName}.class);

    @Autowired
    ${table.mapperName} ${(table.mapperName)?uncap_first};

    @Override
    public Integer insert(${entity} entity){
        return ${(table.mapperName)?uncap_first}.insert(entity);
    }

    @Override
    public Integer insertSelective(${entity} entity){
        return ${(table.mapperName)?uncap_first}.insertSelective(entity);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id){
        return ${(table.mapperName)?uncap_first}.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(${entity} entity){
        return ${(table.mapperName)?uncap_first}.updateByPrimaryKeySelective(entity);
    }

    @Override
    public ${entity} getById(Long id){
        return ${(table.mapperName)?uncap_first}.selectByPrimaryKey(id);
    }
}
</#if>
