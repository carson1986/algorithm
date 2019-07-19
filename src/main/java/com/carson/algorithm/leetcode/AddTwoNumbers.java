package com.carson.algorithm.leetcode;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字0之外，这两个数都不会以0开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        /*int num = 8520;
        Node node = buildNode(num);
        int parseInt = getNumFromNode(node);
        System.out.println(num==parseInt);*/

        int num1 = 8521;
        int num2 = 1230;
        Node node1 = buildNode(num1);
        print(node1);
        Node node2 = buildNode(num2);
        print(node2);

        Node node3 = addTowNumbers(node1, node2);
        print(node3);
        int num3 = getNumFromNode(node3);

        System.out.println(num1+num2==num3);
    }

    public static void print(Node node){
        Node curr = node;
        while(curr!=null){
            System.out.println(curr.value);
            curr = curr.next;
        }

        System.out.println("----------------------");
    }

    public static Node addTowNumbers(Node node1, Node node2){
        Node head = null;  //新节点
        Node curr0 = null; //新节点当前节点
        Node curr1 = node1; //node1当前节点
        Node curr2 = node2; //node2当前节点
        int jin = 0;
        while( curr1 != null || curr2 != null){
            int a = 0;
            int b = 0;
            if(curr1!=null){
                a = curr1.value;
                curr1 = curr1.next;
            }

            if(curr2!=null){
                b = curr2.value;
                curr2 = curr2.next;
            }
            int num = jin + a + b;
            jin = num/10;

            Node temp = new Node(num%10);
            if(head == null){
                curr0 = head = temp;
            }else{
                curr0 = curr0.next = temp;
            }
        }

        if(jin>0){
            curr0.next = new Node(jin);
        }

        return head;
    }

    /**
     * 根据整型数字转化Node对象
     * @param num
     * @return
     */
    public static Node buildNode(int num){
        if(num<=0){
            return null;
        }
        String nums = String.valueOf(num);
        char[] array = nums.toCharArray();
        Node curr = new Node(Integer.parseInt(String.valueOf(array[0])));
        for(int i=1; i<array.length; i++){
            Node node = new Node(Integer.parseInt(String.valueOf(array[i])));
            node.next = curr;
            curr = node;
        }

        return curr;
    }

    /**
     * 根据node对象转化为整型数字
     * @param node
     * @return
     */
    public static int getNumFromNode(Node node){
        if(node == null){
            return 0;
        }

        Node curr = node;
        StringBuffer sb = new StringBuffer();
        while(curr!=null){
            sb.append(curr.value);
            curr = curr.next;
        }

        return Integer.parseInt(sb.reverse().toString());
}

    private static class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }
}
