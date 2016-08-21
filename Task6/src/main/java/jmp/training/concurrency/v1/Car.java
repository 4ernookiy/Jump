package jmp.training.concurrency.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;

public class Car implements Runnable {
    private final static Logger logger = LoggerFactory.getLogger(Car.class);
    private static volatile Car winner;

    private static final long MAX_DISTANCE = 10000;

    private long friction;
    private long distance;

    private String name;

    public Car(String name, long friction) {
        this.name = name;
        this.friction = friction;
    }

    @Override
    public void run() {
        logger.info(getName() + " is ready!");
        try {
            App.CYCLIC_BARRIER.await();
        } catch (InterruptedException | BrokenBarrierException e1) {
            logger.error(e1.getLocalizedMessage());
        }
        while (distance < MAX_DISTANCE & !Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(friction);
            } catch (InterruptedException e) {
                if (!Thread.currentThread().isInterrupted()) {
                    logger.info("I went off the track:{}, by distance - {}", getName(), distance);
                    return;
                }
            }
            distance += 100;
            logger.info(name + " " + distance);
        }
        setWinner(this);
    }

    public String getName() {
        return name;
    }

    private static synchronized void setWinner(Car car) {
        if (winner == null) {
            winner = car;
        }
    }

    public static Car getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "friction=" + friction +
                ", name='" + name + '\'' +
                '}';
    }
}