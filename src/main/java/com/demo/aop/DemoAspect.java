package com.demo.aop;

import com.demo.aop.service.NewService;
import com.demo.aop.service.impl.NewServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author RuanShaoKang
 * @since 2021/8/5 10:55
 */
@Aspect
@Component
public class DemoAspect {

    /**
    *@author: RuanShaoKang
    *@date: 2021/8/5
    *@description: execution(* com.demo.aop.service..*.*(..))   解释:第一个* 表示方法限定符  .. 表示当前包和子包 * 表示所有类  * 类中所有方法 (..) 表示参数
    *@param: []
    *@return: void
    */
    @Pointcut("execution(* com.demo.aop.service..*.test(..))")
    public void pointCut(){}

    @Pointcut("@annotation(com.demo.aop.annotation.AopAnnotation)")
    public void pointCut1(){}

    @After("pointCut1()")
    public void annotationAfter(){
        System.out.println("annotation,最终通知");
    }


    @Pointcut("@within(com.demo.aop.annotation.AopWithInAnnotation)")
    public void pointCut2(){}

    @After("pointCut2()")
    public void annotationBefore(){
        System.out.println("@withIn：前置通知");
    }


    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        Object proxy = joinPoint.getThis();  //代理对象
        Object target = joinPoint.getTarget(); //目标对象
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("前置通知;参数："+ Arrays.toString(args)+";方法名："+name);
    }
    @After("pointCut()")
    public void after(){
        System.out.println("最终");
    }
    @AfterReturning(value = "pointCut()",returning = "ret")
    public void afterReturning(Object ret){
        System.out.println("后置，返回值：" + ret);
    }
    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("环绕前置");
            proceedingJoinPoint.proceed();//放行
            System.out.println("环绕后置");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("异常通知："+e);
    }


    //引入
    @DeclareParents(defaultImpl = NewServiceImpl.class , value = "com.demo.aop.service.impl.CglibAopServiceImpl")
    public NewService newService;
}
