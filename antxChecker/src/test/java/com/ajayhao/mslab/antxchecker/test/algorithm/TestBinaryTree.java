package com.ajayhao.mslab.antxchecker.test.algorithm;

import com.ajayhao.mslab.antxchecker.model.algorithm.vo.BinaryTree;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by AjayHao on 2017/7/11.
 *
 * 二叉树 单元测试
 */
public class TestBinaryTree {

    Integer[] intArr;
    BinaryTree<Integer> binaryTree;

    @BeforeClass
    public void beforeClass(){
        int arrSize = 100;
        intArr = new Integer[arrSize];
        for(int i = 1; i <= arrSize; i++){
            intArr[i-1] = i;
        }
        System.out.println("this is before class:"+ getClass().getSimpleName());
    }

    @Test
    public void testInitBinaryTree() {
        binaryTree = new BinaryTree<Integer>();
        binaryTree.initBinaryTree(intArr);
    }

    @Test
    public void testPreIterate(){
        binaryTree = new BinaryTree<Integer>();
        binaryTree.initBinaryTree(intArr);
        binaryTree.preIterate(binaryTree.getRoot());
    }

    @Test
    public void testMidIterate(){
        binaryTree = new BinaryTree<Integer>();
        binaryTree.initBinaryTree(intArr);
        binaryTree.midIterate(binaryTree.getRoot());
    }

    @Test
    public void testPostIterate(){
        binaryTree = new BinaryTree<Integer>();
        binaryTree.initBinaryTree(intArr);
        binaryTree.postIterate(binaryTree.getRoot());
    }

    @Test
    public void testLevelIterate(){
        binaryTree = new BinaryTree<Integer>();
        binaryTree.initBinaryTree(intArr);
        binaryTree.levelIterate(binaryTree.getRoot());
    }

}
