package com.ajayhao.simpleboot.model.algorithm.vo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by AjayHao on 2017/7/11.
 *
 * 二叉树算法运用
 */
public class BinaryTree<T> {

    BNode<T> root;

    public BNode<T> getRoot() {
        return root;
    }

    /* 构造算法*/
    public void initBinaryTree(T[] arr){
        if(arr == null || arr.length == 0) return;
        root = new BNode<T>();
        innerInit(root, arr, 0);
    }

    //层次遍历构建法
    private void innerInit(BNode node, T[] arr, int index){
        if(index >= arr.length) return;
        node.val = arr[index];
        if(2*index+1 < arr.length) {
            node.left = new BNode();
            innerInit(node.left, arr, 2 * index + 1);
        }

        if(2*index+2 < arr.length){
            node.right = new BNode();
            innerInit(node.right, arr, 2 * index + 2);
        }
    }

    private void process(T data){
        System.out.print(data + " ");
    }

    /* 先序遍历 - 递归 */
    public void preIterate(BNode<T> root){
        if(root == null) return;
        process(root.val);
        preIterate(root.left);
        preIterate(root.right);
    }

    /* 中序遍历 - 递归*/
    public void midIterate(BNode<T> root){
        if(root == null) return;
        midIterate(root.left);
        process(root.val);
        midIterate(root.right);
    }

    /* 后序遍历 - 递归*/
    public void postIterate(BNode<T> root){
        if(root == null) return;
        postIterate(root.left);
        postIterate(root.right);
        process(root.val);
    }

    /* 层次遍历 */
    public void levelIterate(BNode<T> root){
        if(root == null) return;
        Queue<BNode<T>> q = new LinkedList<BNode<T>>();
        q.add(root);
        while(q.size() > 0){
            BNode<T> node = q.poll();
            process(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
    }

}
