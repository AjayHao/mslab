package com.ajayhao.mslab.antxchecker.model.algorithm.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AjayHao on 2017/7/3.
 *
 * 单链表算法运用
 */

public class SinglyLinkedList<T>{
    SNode<T> head;

    //构造算法1- 头插法，顺序会反转
    public void initHeadInsert(final T[] array){
        head = new SNode();
        for(T data : array){
            SNode<T> a = new SNode(data);
            a.next = head.next;
            head.next = a;
        }
    }

    //构造算法2- 尾插法，顺序稳定
    public void initTailInsert(final T[] array){
        head = new SNode();
        SNode<T> tail = head;
        for(T data : array){
            SNode<T> a = new SNode(data);
            tail.next = a;
            tail = tail.next;
        }
        tail.next = null;
    }


    public List<T> getChainVal(){
        List<T> retList = new ArrayList<T>();
        if(head != null) {
            SNode<T> p = head.next;
            while (p != null) {
                retList.add(p.val);
                p = p.next;
            }
        }
        return retList;
    }

    //反转算法1 ： 逐个翻转，需要记录两个队列的头，较低效
    @Deprecated
    public void reverse1(){
        if(head == null) {
            return;
        }
        SNode<T> p = head;
        SNode<T> q = p.next;
        p = null;  //关键环节
        while(q != null){
            SNode<T> h2 = q.next;
            q.next = p;
            p = q;
            q = h2;
        }
        head.next = p;
    }

    //反转算法2 ： 遍历一次，每个节点都调整为头结点
    public void reverse(){
        if(head == null) {
            return;
        }
        SNode<T> p = null, q = null;
        p = head.next;
        while(p.next != null){
            q = p.next;
            p.next = q.next;
            q.next = head.next;
            head.next = q;
        }
    }

    //反转算法3 ： 递归处理
    public void reverse_recur(){
        SNode<T> temHead = head;
        _reverse(temHead.next,head);
    }

    private void _reverse(SNode<T> node1, SNode<T> node2) {
        if(node1 == null){
            return;
        }

        if(node1.next == null) {
            node2.next = node1;
        }else {
            _reverse(node1.next, node2);
            node1.next.next = node1;
            node1.next = null;
        }
    }
}
