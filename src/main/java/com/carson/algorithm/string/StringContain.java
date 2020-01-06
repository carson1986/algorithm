package com.carson.algorithm.string;

import java.io.BufferedOutputStream;
import java.util.Observer;

/**
 * 给定字符串a和b，快速判断a是否全部包含b中的字符
 */
public class StringContain {

    /**
     * 解法一：暴力法，一一判断b中的字符是否存在a中
     * 时间复杂度：O(a.length*b.length);
     * 空间复杂度:O(a.length+b.length) 开辟两个数组
     * @param a
     * @param b
     * @return
     */
    public static boolean contain(String a, String b){
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        label: for(int i = 0; i<arrayB.length; i++){

            int j;
            for(j = 0; j<arrayA.length; j++){
                if(arrayA[j]==arrayB[i]){
                    continue label;
                }
            }

            if(j==arrayA.length){
                return false;
            }
        }

        return true;
    }

    /**
     * 解法二：先排序，然后再进行比较
     * @param a
     * @param b
     * @return
     */
    public static boolean contain1(String a, String b){
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        quickSort(arrayA, 0, arrayA.length-1);
        quickSort(arrayB, 0, arrayB.length-1);
        label: for(int i = 0; i<arrayB.length; i++){

            int j;
            for(j = 0; j<arrayA.length&&arrayA[j]<arrayB[i]; j++){
                if(arrayA[j]==arrayB[i]){
                    continue label;
                }
            }

            if(j==arrayA.length||arrayA[j]>arrayB[i]){
                return false;
            }
        }

        return true;
    }

    /**
     * 解法三：利用位运算
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * 存在的问题：字符串中不能包含相同的字符，避免这个问题可以先去重
     * @param a
     * @param b
     * @return
     */
    public static boolean contain2(String a, String b){
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int hash = 0;
        char base = 'A';
        for(int i=0; i<arrayA.length; i++){
            hash |= (1<<(arrayA[i]-base));
        }

        for(int i=0;i<arrayB.length;i++){
            if((hash & (1<<(arrayB[i]-base)) )== 0){
                return false;
            }
        }

        return true;
    }


    private static void quickSort(char[] a,int left, int right){
        if(left >right || right>=a.length|| left<0){
            return ;
        }
       int i=left;
       int j=right;
       char c = a[left];
       while(i<j){

           while(a[j]>=c&&i<j){
               j--;
           }

           while(a[i]<=c&&i<j){
               i++;
           }



           if(i<j){
               char temp = a[i];
               a[i] = a[j];
               a[j] = temp;
           }
       }

        a[left]=a[i];
        a[i]=c;
        quickSort(a,left,i-1);
        quickSort(a,i+1,right);
    }

    public static void main(String[] args) {
        String a="ASDFAGHJKE";
        String b= "AB";
        System.out.println(contain2(a, b));
    }
}
