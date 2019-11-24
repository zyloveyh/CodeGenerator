package com.zy.mybatisplus.test.service.impl;

import com.zy.mybatisplus.test.entity.Students;
import com.zy.mybatisplus.test.mapper.StudentsMapper;
import com.zy.mybatisplus.test.service.IStudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author zy
 * @since 2019-11-24
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements IStudentsService {

}
