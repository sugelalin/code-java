package org.example.practicejava.javaBase.collection.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * List工具类
 */
public class ListMergeTest {

    static List<Integer> list1 = Lists.newArrayList(1, 3, 5);
    static List<Integer> list2 = Lists.newArrayList(2, 3, 6);

    // 合并List 1 List.addAll
    public static void mergeList1() {
        list1.addAll(list2);
        System.out.println(list1);
        System.out.println(list2);
    }

    // 合并List 1 List.addAll
    public static void mergeList2() {
        list1.addAll(list2);
        System.out.println(list1);
        System.out.println(list2);
    }

    public static void main(String[] args) {
        mergeList1();
    }
}
