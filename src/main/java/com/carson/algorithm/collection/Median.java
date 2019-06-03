package com.carson.algorithm.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 利用PriorityQueue实现求中值
 * @param <E>
 */
public class Median <E> {

    private E  m;
    private PriorityQueue<E> minQueue; //最小堆
    private PriorityQueue<E> maxQueue; //最大堆

    public Median(){
        this.minQueue = new PriorityQueue<E>();
        this.maxQueue = new PriorityQueue<E>(11, Collections.<E>reverseOrder());
    }

    public void add(E e){
        if(m == null){
            m = e;
            return ;
        }

        Comparable<? super E> cur = (Comparable<? super E>)e;
        if(cur.compareTo(m)<=0){
            maxQueue.add(e);
        }else{
            minQueue.add(e);
        }

        if(minQueue.size()-maxQueue.size()>=2){
            maxQueue.add(m);
            m = minQueue.poll();
        }else{
            minQueue.add(m);
            m = maxQueue.poll();
        }
    }

    public void addAll(Collection<? extends E> c){
        for(E e : c){
            add(e);
        }
    }

    public E getM(){
        return m;
    }

    public static void main(String[] args) {
        Median<Integer> median = new Median<Integer>();
        median.addAll(Arrays.asList(10,200,15,75,64,82,5,99,150));
        System.out.println(median.getM());
    }
}
