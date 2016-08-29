package jmp.training.thread.deadlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by d4 on 29.08.2016.
 */
public class DeadThread implements Runnable {
    private final static Logger logger = LoggerFactory.getLogger(DeadThread.class);

    private Lock lock1;
    private Lock lock2;

    public DeadThread(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            logger.info("thread {} - holding {} ", Thread.currentThread().getName(), lock1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            logger.info("thread {} - wait {} ", Thread.currentThread().getName(), lock2);
            synchronized (lock2) {
                logger.info("thread {} - holding both: {} & {} ", Thread.currentThread().getName(), lock1, lock2);
            }
        }
    }
}
