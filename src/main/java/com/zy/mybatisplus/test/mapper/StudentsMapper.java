package com.zy.mybatisplus.test.mapper;

import com.zy.mybatisplus.test.entity.Students;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生信息表 Mapper 接口
 * </p>
 *
 * @author zy
 * @since 2019-11-24
 */
@Mapper
public interface StudentsMapper extends BaseMapper<Students> {

}
