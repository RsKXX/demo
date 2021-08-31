package com.demo.base;

/**
*@author: RuanShaoKang
*@date: 2021/8/31
*@description: 总结
 *   1. 可以有静态方法
 *   2. 私有方法必须有函数主体
 *   3. 可以定义构造方法
*/
public abstract class DemoAbstract {

    public DemoAbstract(){
    }
    private String xx;
    public abstract void get();
    protected abstract void get1();

    private void get2(){};
    static void get3(){};
}
