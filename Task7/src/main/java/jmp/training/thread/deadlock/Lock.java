package jmp.training.thread.deadlock;

/**
 * Created by d4 on 29.08.2016.
 */
public class Lock {
    private static int counter = 0;
    private int num;

    public Lock() {
        synchronized (Lock.class) {
            counter++;
            num = counter;
        }
    }

    @Override
    public String toString() {
        return "Lock:" + num;
    }
}
