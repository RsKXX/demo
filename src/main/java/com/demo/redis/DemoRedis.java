package com.demo.redis;

import com.demo.sharding.data.StudentInfoDO;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author RuanShaoKang
 * @since 2021/8/25 16:53
 */
@Service
public class DemoRedis {
    @Autowired
    public RedisService redisService;

    /**
    *@author: RuanShaoKang
    *@date: 2021/8/30
    *@description: 存放
    *@param: [studentInfoDO]
    *@return: void
    */
    public void setData(StudentInfoDO studentInfoDO){
        redisService.hSet("demo:student",String.valueOf(studentInfoDO.getClassId()),studentInfoDO);
    }

    /**
    *@author: RuanShaoKang
    *@date: 2021/8/30
    *@description: 获取数据，同时send消息
    *@param: []
    *@return: void
    */
    public void getData(){
        StudentInfoDO studentInfoDO = new StudentInfoDO().setAge(18).setClassId(2L).setClassName("三班").setName("li");
        StudentInfoDO studentInfoDO1 = new StudentInfoDO().setAge(12).setClassId(3L).setClassName("四班").setName("wang");
        setData(studentInfoDO);
        setData(studentInfoDO1);
        Map<String, StudentInfoDO> studentInfoDOMap = redisService.hGetAll("demo:student", new TypeReference<>() {});
        System.out.println(studentInfoDOMap.toString());
        redisService.send("student_topic",studentInfoDO);
    }


}
