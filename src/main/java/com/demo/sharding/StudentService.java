package com.demo.sharding;

import com.demo.sharding.dao.StudentDao;
import com.demo.sharding.data.StudentInfoDO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author RuanShaoKang
 * @since 2021/8/24 15:47
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;

    public void addStudent(StudentInfoDO studentInfoDO){
        studentDao.save(studentInfoDO);
    }

    public void getStudent(){

    }
}
