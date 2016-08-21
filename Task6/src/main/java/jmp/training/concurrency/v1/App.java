package jmp.training.concurrency.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class App {
    private final static Logger logger = LoggerFactory.getLogger(App.class);
    private static final int COUNT_CAR = 5;
    public static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(COUNT_CAR + 1);

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < COUNT_CAR; i++) {
            int friction = getRandomNumberInRange(5, 25);
            Car car = new Car("car-" + i, friction);
            logger.info("participant:{}", car);
            Thread threadCar = new Thread(car);
            threadCar.setName(car.getName());
            threads.add(threadCar);
            threadCar.start();
        }

        long start = System.currentTimeMillis();
        try {
            Thread tc;
            CYCLIC_BARRIER.await();
            logger.info("go");
            Thread.sleep(500);
            int randomCar = getRandomNumberInRange(0, COUNT_CAR - 1);
            tc = threads.get(randomCar);
            logger.info("randomly {} have been disqualified", tc.getName());
            tc.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        long duration = System.currentTimeMillis() - start;
        logger.info("the duration of the race- {}", duration);
        logger.info("winner is - {}", Car.getWinner());

    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }

}
