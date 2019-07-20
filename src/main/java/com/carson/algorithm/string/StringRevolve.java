package com.carson.algorithm.string;

/**
 * 将字符串"abcdef"的前3个字符'a'、'b'、'c'移到字符串的尾部，变成"defabc"
 */
public class StringRevolve {

    private static void leftShiftOne(char[] a){
        if(a == null){
            return ;
        }
        int length = a.length;
        if(length<=1){
            return ;
        }

        char head = a[0];
        for(int i=1;i<length;i++){
            a[i-1]=a[i];
        }
        a[length-1]=head;
    }

    /**
     * 解法一：暴力法，一次往后移动一个
     * 时间复杂度：O(num*字符串长度)
     * 空间复杂度：O(1)
     * @param original
     * @param num
     * @return
     */
    public static String revolve(String original, int num){
        if(num<1){
            return original;
        }

        char[] a = original.toCharArray();
        while(num>0){
            leftShiftOne(a);
            num--;
        }

        return new String(a);
    }

    private static void reverse(char[] a, int from, int to){

        if(a == null || a.length<=1 || from<0 || to<0 || from>=to){
            return;
        }

        while(from<to){
            char temp = a[from];
            a[from++]=a[to];
            a[to--]=temp;
        }
    }

    /**
     * 解法二：利用三次反转:把字符串分为两部分，各自反转，最后在同一反转
     * 时间复杂度：O(字符长度)
     * 空间复杂度：O(1)
     * @param original
     * @param num
     * @return
     */
    public static String revolve1(String original, int num){
        char[] a = original.toCharArray();
        int length = a.length;
        reverse(a, 0, num-1);
        reverse(a, num, length-1);
        reverse(a, 0, length-1);

        return new String(a);
    }


    public static void main(String[] args) {
        String original = "abcdef";
//        System.out.println(revolve(original, 3));

        System.out.println(revolve1(original, 3));
    }
}
