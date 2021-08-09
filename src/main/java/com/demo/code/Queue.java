package com.demo.code;

/**
 * @Author RuanShaoKang
 * @since 2021/7/8 18:08
 */
public class Queue {
    private int[] data;
    private int front;//队列头
    private int rear;//队列尾
    private int size;//队列大小

    public Queue(int size) {
        this.size = size;
        data = new int[size];
    }

    /**
     * 入队
     * @param value
     */
    public void in(int value) throws Exception {
        if(rear == size){
            throw new Exception("队列已满异常");
        }
        data[rear ++] = value;
    }

    /**
     * 出队
     */
    public Object out() throws Exception {
        if(isEmpty()){
            throw  new Exception("空队列异常");
        }
        Object value = data[front];
        data[front++] = 0;

        return value;
    }

    /**
     * 是否为空队列
     * @return
     */
    public boolean isEmpty(){
        return  front == rear;
    }

    /**
     * 遍历队列
     */
    public void traverse(){
        for(int i = front; i < size; i++){
            System.out.println(""+data[i]);
        }
    }

    /**
     * 遍历有效数据
     */
    public void traverseValid(){
        for(int i = front; i < rear; i++){
            System.out.println(""+data[i]);
        }
    }
}
