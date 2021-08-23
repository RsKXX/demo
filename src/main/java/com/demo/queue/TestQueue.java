package com.demo.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * @Author RuanShaoKang
 * @since 2021/7/12 10:59
 */
public class TestQueue implements Queue {
    private int size = 0;
    private int[] data;

    private Node first;
    private Node last;

//    public TestQueue(){};
    public TestQueue(int size){
        this.size = size;
        data = new int[size];
    };

    private static class Node {
        int item;
        Node next;
        Node prev;
        Node(Node prev, int element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    public int get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    TestQueue.Node node(int index) {
        if (index < (size >> 1)) {
            TestQueue.Node x = first;
            for (int i = 0; i < index; i++){
                x = x.next;
            }
            return x;
        } else {
            TestQueue.Node x = last;
            for (int i = size - 1; i > index; i--){
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0 || numNew > this.size){
            return false;
        }
        TestQueue.Node pred = null, succ = null;
        for (Object o : a) {
            if(o instanceof Integer){
                TestQueue.Node newNode = new TestQueue.Node(pred, ((Integer) o).intValue(), null);
                if (pred == null){
                    first = newNode;
                } else{
                    pred.next = newNode;
                }
                pred = newNode;
            }
        }
        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }
//        size += numNew;  已经初始化定长
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }



    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
