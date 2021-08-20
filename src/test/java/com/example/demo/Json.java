package com.example.demo;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.demo.Application;
import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.Inet4Address;

/**
 * @Author RuanShaoKang
 * @since 2021/8/19 14:35
 */
@SpringBootTest(classes = Application.class)
public class Json {

    @Test
    public void Test(){
        JSONArray jsonArray =  new JSONArray();
        User user = new User().setAge(12).setName("xx");
        jsonArray.add(user);
        System.out.println(jsonArray);
        Object o = jsonArray.get(0);
        JSON res = JSONUtil.parse(o);
        System.out.println(res);
    }

    @Data
    @Accessors(chain = true)
    public static class User{
        private String name;
        private Integer age;
    }
}
