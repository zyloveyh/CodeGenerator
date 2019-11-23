package com.zy.mybatisplus.test.mapper;

import com.zy.mybatisplus.test.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 人员信息表 Mapper 接口
 * </p>
 *
 * @author zy
 * @since 2019-11-23
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}