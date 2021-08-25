package com.demo.sharding.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.demo.sharding.dao.mapper.StudentMapper;
import com.demo.sharding.data.StudentInfoDO;
import org.springframework.stereotype.Repository;


/**
 * @Author RuanShaoKang
 * @since 2021/8/24 15:36
 */
@Repository
public class StudentDao extends ServiceImpl<StudentMapper, StudentInfoDO> {
}
