package com.ajayhao.simpleboot.test.algorithm;

import com.ajayhao.simpleboot.model.algorithm.vo.SinglyLinkedList;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by AjayHao on 2017/7/11.
 *
 * SinglyLinkedList 单元测试类
 */
public class TestSinglyLinkedList {

    String[] s = {"1", "2", "3", "4", "5"};
    SinglyLinkedList<String> singlyLinkedList;

    @BeforeClass
    public void beforeClass() {
        System.out.println("this is before class:"+ getClass().getSimpleName());
    }

    @Test
    public void testHeadInsert() {
        String[] expected = {"5","4", "3","2","1"};
        singlyLinkedList = new SinglyLinkedList<String>();
        singlyLinkedList.initHeadInsert(s);
        List l = singlyLinkedList.getChainVal();
        Assert.assertEquals(l, Arrays.asList(expected));
    }

    @Test
    public void testTailInsert() {
        String[] expected = {"1","2", "3","4","5"};
        singlyLinkedList = new SinglyLinkedList<String>();
        singlyLinkedList.initTailInsert(s);
        List l = singlyLinkedList.getChainVal();
        Assert.assertEquals(l, Arrays.asList(expected));
    }

    @Test
    public void testReverse() {
        String[] expected = {"5","4", "3","2","1"};
        SinglyLinkedList<String> SinglyLinkedList = new SinglyLinkedList<String>();
        SinglyLinkedList.initTailInsert(s);
        SinglyLinkedList.reverse();
        List l = SinglyLinkedList.getChainVal();
        Assert.assertEquals(l, Arrays.asList(expected));
    }

    @Test
    public void testReverseRecursion() {
        String[] expected = {"5","4", "3","2","1"};
        singlyLinkedList = new SinglyLinkedList<String>();
        singlyLinkedList.initTailInsert(s);
        singlyLinkedList.reverse_recur();
        List l = singlyLinkedList.getChainVal();
        Assert.assertEquals(l, Arrays.asList(expected));
    }

}
