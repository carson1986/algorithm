package com.carson.algorithm.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * 利用PriorityQueue实现求前K个最大元素
 * @param <E>
 */
public class TopK <E> {

    private int k;

    private PriorityQueue<E> queue;

    public TopK(int k){
        this.k = k;
        this.queue = new PriorityQueue<E>(k);
    }

    public void add(E e){
        if(queue.size()<k){
            queue.add(e);
            return ;
        }

        Comparable<? super E> head = (Comparable<? super E>)queue.peek();
        if(head.compareTo(e)>0){
            return ;
        }

        queue.poll();
        queue.add(e);
    }

    public void addAll(Collection<? extends E> c){
        for(E e: c){
            add(e);
        }
    }

    public <T> T[] toArray(T[] a){
        return queue.toArray(a);
    }

    public E getKth(){
        return queue.peek();
    }

    public static void main(String[] args) {
        TopK<Integer> topK = new TopK(5);
        topK.addAll(Arrays.asList(10,200,15,75,64,82,5,99,150));
        System.out.println(Arrays.toString(topK.toArray(new Integer[0])));
        System.out.println(topK.getKth());
    }
}
