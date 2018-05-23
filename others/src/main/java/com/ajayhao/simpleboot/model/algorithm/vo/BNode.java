package com.ajayhao.simpleboot.model.algorithm.vo;

/**
 * Created by AjayHao on 2017/7/11.
 *
 * 二叉树节点
 */
public class BNode<T> {
    public T val;
    public BNode<T> left;
    public BNode<T> right;

    public BNode(){}

    public BNode(T t){
        val = t;
    }
}
