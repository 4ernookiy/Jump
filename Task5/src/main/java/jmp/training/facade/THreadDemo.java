package jmp.training.facade;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Dzmitry_Charnavoki on 8/16/2016.
 */
public class THreadDemo
{
    private static Lock mutex = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {

            }
        });
        Thread thread2 = new Thread(()-> System.out.println("i'm alive 2"));
        System.out.println("before");
        thread.start();
        System.out.println("main");
        thread2.start();

        mutex.lock();
        thread.join();
        mutex.unlock();

        System.out.println("end");


    }
}
