package jmp.training.thread.deadlock;

import jmp.training.thread.deadlock.Lock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CyclicBarrier;

public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static Lock LOCK1 = new Lock();
    public static Lock LOCK2 = new Lock();
    public static Lock LOCK3 = new Lock();
    public static Lock LOCK4 = new Lock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadThread(LOCK1, LOCK2));
        Thread t2 = new Thread(new DeadThread(LOCK2, LOCK3));
        Thread t3 = new Thread(new DeadThread(LOCK3, LOCK4));
        Thread t4 = new Thread(new DeadThread(LOCK4, LOCK1));
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}
