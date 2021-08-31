package com.demo.base;

/**
*@author: RuanShaoKang
*@date: 2021/8/31
*@description:
 * 总结：1. 接口中的成员只可以是 public（方法默认：public abstrat、成员变量默认：public static final）；
 *      2. 1.8开始 接口中可以包含具体实现方法，必须要携带default修饰，
 *      3. 1.8开始 接口可以包含静态方法，调用DemoInterface.dd();
 *      4. 1.9开始 接口可以定义私有方法
 *      5. 没有构造方法
*/
public interface DemoInterface {

    public static final String XX = "xx";
    private void create1(){}

    public abstract  void ccc();

    public void create();

    static void dd(){}

    default String dd1(){
        return "xx";
    }
}
