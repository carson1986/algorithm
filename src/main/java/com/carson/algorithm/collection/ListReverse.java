package com.carson.algorithm.collection;

import lombok.Data;

/**
 * 反转链表
 * 思路：就是把链表节点的next节点，指向它之前的节点
 */
@Data
public class ListReverse<E> {

    private Node<E> head;

    public void add(E value){
        Node node = new Node();
        node.setValue(value);

        if(head==null){
            head = node;
        }else{
            Node<E> cur = head;
            while(cur.getNext()!=null){
                cur = cur.getNext();
            }

            cur.setNext(node);
        }
    }

    public void display(){
        if(head == null){
            System.out.println("empty");
        }

        Node<E> cur = head;
        while(cur!=null){
            System.out.println(cur.getValue());
            cur = cur.getNext();
        }
    }

    public void reverse(){
        if(head == null || head.getNext() == null){
            return;
        }

        Node<E> node1 = head;
        Node<E> node2 = head.getNext();
        Node<E> node3 = null;
        while(node2!=null){
            node3 = node2.getNext();
            node2.setNext(node1);
            node1 = node2;
            node2 = node3;
        }

        head.setNext(null);//一定要把原来的head的next设置为空
        head = node1;
    }


    public static void main(String[] args) {
        ListReverse<Integer> tl = new ListReverse();
        tl.add(1);
        tl.add(2);
        tl.add(3);
        tl.add(4);
        tl.add(5);

        System.out.println("翻转之前");
        tl.display();

        tl.reverse();

        System.out.println("翻转之后");
        tl.display();

    }

    class Node<E>{
        private E value;
        private Node<E> next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
