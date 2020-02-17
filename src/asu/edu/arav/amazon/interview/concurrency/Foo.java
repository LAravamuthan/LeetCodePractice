package asu.edu.arav.amazon.interview.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/print-in-order/
 */
public class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() == 0) ;
        printSecond.run();
        secondJobDone.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (firstJobDone.get() == 0) ;
        printThird.run();
    }


}
