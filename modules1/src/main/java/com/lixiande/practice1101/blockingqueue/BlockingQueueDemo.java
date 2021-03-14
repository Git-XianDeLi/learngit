package com.lixiande.practice1101.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @description: 阻塞队列四组API测试
 * 抛出异常
 * 有返回值，不抛出异常
 * 阻塞 等待
 * 超时等待
 * @author: Mr.LiXianDe
 * @create: 2020-11-10 09:05
 **/
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    public static void test1(){
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        System.out.println("Fly");

        // 检测队首元素
        System.out.println(blockingQueue.element());

        // 队列已满则抛出 java.lang.IllegalStateException: Queue full 异常
        //blockingQueue.add("d");
        System.out.println("================");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        // 队列为空则抛出 java.util.NoSuchElementException 异常
        //blockingQueue.remove();
    }

    public static void test2() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.peek());
        // 队列已满则不抛出异常， false
        System.out.println(blockingQueue.offer("d"));

        System.out.println("================");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 队列为空则不抛出异常 null
        System.out.println(blockingQueue.poll());
    }

    public static void test3() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");

        // 一直阻塞
        blockingQueue.put("d");

        System.out.println("================");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // 一直阻塞
        // System.out.println(blockingQueue.take());
    }

    public static void test4() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.peek());
        // 超过3秒就退出
        System.out.println(blockingQueue.offer("d",3,TimeUnit.SECONDS));

        System.out.println("================");
        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
        // 超过3秒就退出
        System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
    }
}
