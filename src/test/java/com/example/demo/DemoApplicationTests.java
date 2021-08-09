package com.example.demo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONArray;
import com.demo.Application;

import com.demo.data.Person;
import com.demo.data.School;
import com.demo.data.Student;
import com.demo.utils.MapConvertUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.*;


@SpringBootTest(classes = Application.class)
class DemoApplicationTests {

    @Test
    void contextLoads() throws Exception {
        String json = "[\n" +
                "  [\n" +
                "    119.996737,\n" +
                "    30.26558\n" +
                "  ],\n" +
                "  [\n" +
                "    119.997208,\n" +
                "    30.265639\n" +
                "  ],\n" +
                "  [\n" +
                "    119.997511,\n" +
                "    30.265682\n" +
                "  ],\n" +
                "  [\n" +
                "    119.997846,\n" +
                "    30.265729\n" +
                "  ],\n" +
                "  [\n" +
                "    119.998143,\n" +
                "    30.265771\n" +
                "  ],\n" +
                "  [\n" +
                "    119.998336,\n" +
                "    30.265798\n" +
                "  ],\n" +
                "  [\n" +
                "    119.998677,\n" +
                "    30.265844\n" +
                "  ],\n" +
                "  [\n" +
                "    119.99897,\n" +
                "    30.265885\n" +
                "  ],\n" +
                "  [\n" +
                "    119.998976,\n" +
                "    30.265888\n" +
                "  ],\n" +
                "  [\n" +
                "    119.999263,\n" +
                "    30.265926\n" +
                "  ],\n" +
                "  [\n" +
                "    119.999722,\n" +
                "    30.26599\n" +
                "  ],\n" +
                "  [\n" +
                "    119.999974,\n" +
                "    30.266025\n" +
                "  ],\n" +
                "  [\n" +
                "    120.000264,\n" +
                "    30.266066\n" +
                "  ],\n" +
                "  [\n" +
                "    120.000993,\n" +
                "    30.266174\n" +
                "  ],\n" +
                "  [\n" +
                "    120.001532,\n" +
                "    30.266249\n" +
                "  ],\n" +
                "  [\n" +
                "    120.001902,\n" +
                "    30.2663\n" +
                "  ],\n" +
                "  [\n" +
                "    120.002201,\n" +
                "    30.266343\n" +
                "  ],\n" +
                "  [\n" +
                "    120.002454,\n" +
                "    30.266379\n" +
                "  ],\n" +
                "  [\n" +
                "    120.002734,\n" +
                "    30.266417\n" +
                "  ],\n" +
                "  [\n" +
                "    120.003355,\n" +
                "    30.266516\n" +
                "  ],\n" +
                "  [\n" +
                "    120.003734,\n" +
                "    30.266573\n" +
                "  ],\n" +
                "  [\n" +
                "    120.003993,\n" +
                "    30.266615\n" +
                "  ],\n" +
                "  [\n" +
                "    120.004318,\n" +
                "    30.266666\n" +
                "  ],\n" +
                "  [\n" +
                "    120.004605,\n" +
                "    30.266712\n" +
                "  ],\n" +
                "  [\n" +
                "    120.004887,\n" +
                "    30.266752\n" +
                "  ],\n" +
                "  [\n" +
                "    120.00531,\n" +
                "    30.266809\n" +
                "  ],\n" +
                "  [\n" +
                "    120.005675,\n" +
                "    30.266863\n" +
                "  ],\n" +
                "  [\n" +
                "    120.006017,\n" +
                "    30.266908\n" +
                "  ],\n" +
                "  [\n" +
                "    120.006419,\n" +
                "    30.266968\n" +
                "  ],\n" +
                "  [\n" +
                "    120.006763,\n" +
                "    30.267016\n" +
                "  ],\n" +
                "  [\n" +
                "    120.00745,\n" +
                "    30.267109\n" +
                "  ],\n" +
                "  [\n" +
                "    120.007964,\n" +
                "    30.267181\n" +
                "  ],\n" +
                "  [\n" +
                "    120.008438,\n" +
                "    30.267248\n" +
                "  ],\n" +
                "  [\n" +
                "    120.008784,\n" +
                "    30.267297\n" +
                "  ],\n" +
                "  [\n" +
                "    120.009283,\n" +
                "    30.267368\n" +
                "  ],\n" +
                "  [\n" +
                "    120.009742,\n" +
                "    30.267432\n" +
                "  ],\n" +
                "  [\n" +
                "    120.010013,\n" +
                "    30.267473\n" +
                "  ],\n" +
                "  [\n" +
                "    120.010478,\n" +
                "    30.267536\n" +
                "  ],\n" +
                "  [\n" +
                "    120.0111,\n" +
                "    30.267626\n" +
                "  ],\n" +
                "  [\n" +
                "    120.011326,\n" +
                "    30.267661\n" +
                "  ],\n" +
                "  [\n" +
                "    120.011572,\n" +
                "    30.267709\n" +
                "  ],\n" +
                "  [\n" +
                "    120.011855,\n" +
                "    30.267775\n" +
                "  ],\n" +
                "  [\n" +
                "    120.01225,\n" +
                "    30.267872\n" +
                "  ],\n" +
                "  [\n" +
                "    120.012603,\n" +
                "    30.267964\n" +
                "  ],\n" +
                "  [\n" +
                "    120.012974,\n" +
                "    30.268067\n" +
                "  ],\n" +
                "  [\n" +
                "    120.013371,\n" +
                "    30.268174\n" +
                "  ],\n" +
                "  [\n" +
                "    120.013863,\n" +
                "    30.268312\n" +
                "  ],\n" +
                "  [\n" +
                "    120.01429,\n" +
                "    30.268429\n" +
                "  ],\n" +
                "  [\n" +
                "    120.014737,\n" +
                "    30.268553\n" +
                "  ],\n" +
                "  [\n" +
                "    120.015191,\n" +
                "    30.26868\n" +
                "  ],\n" +
                "  [\n" +
                "    120.015638,\n" +
                "    30.268808\n" +
                "  ],\n" +
                "  [\n" +
                "    120.016104,\n" +
                "    30.268938\n" +
                "  ],\n" +
                "  [\n" +
                "    120.016613,\n" +
                "    30.269081\n" +
                "  ],\n" +
                "  [\n" +
                "    120.017023,\n" +
                "    30.269195\n" +
                "  ],\n" +
                "  [\n" +
                "    120.017182,\n" +
                "    30.269241\n" +
                "  ],\n" +
                "  [\n" +
                "    120.017521,\n" +
                "    30.269324\n" +
                "  ],\n" +
                "  [\n" +
                "    120.017783,\n" +
                "    30.269396\n" +
                "  ],\n" +
                "  [\n" +
                "    120.018077,\n" +
                "    30.269449\n" +
                "  ],\n" +
                "  [\n" +
                "    120.018323,\n" +
                "    30.269494\n" +
                "  ],\n" +
                "  [\n" +
                "    120.018687,\n" +
                "    30.269549\n" +
                "  ],\n" +
                "  [\n" +
                "    120.018945,\n" +
                "    30.269584\n" +
                "  ],\n" +
                "  [\n" +
                "    120.019148,\n" +
                "    30.269611\n" +
                "  ],\n" +
                "  [\n" +
                "    120.019396,\n" +
                "    30.269645\n" +
                "  ],\n" +
                "  [\n" +
                "    120.019571,\n" +
                "    30.269668\n" +
                "  ],\n" +
                "  [\n" +
                "    120.019974,\n" +
                "    30.269712\n" +
                "  ],\n" +
                "  [\n" +
                "    120.020347,\n" +
                "    30.269757\n" +
                "  ],\n" +
                "  [\n" +
                "    120.020672,\n" +
                "    30.269796\n" +
                "  ],\n" +
                "  [\n" +
                "    120.021174,\n" +
                "    30.269848\n" +
                "  ],\n" +
                "  [\n" +
                "    120.02147,\n" +
                "    30.269879\n" +
                "  ],\n" +
                "  [\n" +
                "    120.021648,\n" +
                "    30.269906\n" +
                "  ],\n" +
                "  [\n" +
                "    120.021982,\n" +
                "    30.269941\n" +
                "  ],\n" +
                "  [\n" +
                "    120.022411,\n" +
                "    30.269993\n" +
                "  ],\n" +
                "  [\n" +
                "    120.022708,\n" +
                "    30.270027\n" +
                "  ],\n" +
                "  [\n" +
                "    120.023022,\n" +
                "    30.270063\n" +
                "  ],\n" +
                "  [\n" +
                "    120.023136,\n" +
                "    30.270076\n" +
                "  ],\n" +
                "  [\n" +
                "    120.023353,\n" +
                "    30.270107\n" +
                "  ]\n" +
                "]";


        JSONArray jsonArray = new JSONArray(json);
        JSONArray newPointJson = new JSONArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            List<BigDecimal> temp =  (List<BigDecimal>)jsonArray.get(i);
            List<Double> newPoint = MapConvertUtil.gd2bd(temp.get(0).doubleValue(), temp.get(1).doubleValue());
            newPointJson.add(newPoint);
        }
        System.out.println(newPointJson);
    }

    @Test
    public void test(){
        Map<String,String> map = new HashMap<>();
        System.out.println(CollUtil.isEmpty(map));
        map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }

    @Test
    public void Proxy() {
        Student student = new Student();
        Class<?>[] interfaces = student.getClass().getInterfaces();
        ClassLoader classLoader = student.getClass().getClassLoader();
        Object o =  Proxy.newProxyInstance(classLoader, interfaces, (proxy, method, args) -> {
            Object invoke = method.invoke(student,args);
            return invoke;
        });
        Person proxy = (Person) o;

        School proxy1 = (School) o;
//        System.out.println(o.toString());
        proxy.getUsername();
        proxy1.schoolName();

        Object o2 = org.springframework.cglib.proxy.Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class,School.class}, (o1, method, objects) -> {
            return null;
        });
//        o2.schoolName();
//        o2.getUsername();


    }

}
