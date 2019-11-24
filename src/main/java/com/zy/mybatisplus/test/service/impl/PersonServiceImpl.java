package com.zy.mybatisplus.test.service.impl;

import com.zy.mybatisplus.test.entity.Person;
import com.zy.mybatisplus.test.mapper.PersonMapper;
import com.zy.mybatisplus.test.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员信息表 服务实现类
 * </p>
 *
 * @author zy
 * @since 2019-11-24
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
