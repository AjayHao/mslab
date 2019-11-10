package com.ajayhao.workshop.model.algorithm.vo;

/**
 * Created by AjayHao on 2017/7/3.
 *
 * 单链表节点
 */
public class SNode<T>{
    public T val;
    public SNode<T> next;

    public SNode(){}

    public SNode(T t){
        val = t;
    }
}
