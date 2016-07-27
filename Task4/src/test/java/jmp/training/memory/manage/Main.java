package jmp.training.memory.manage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Main memoryTest = new Main();
        try
        {
            memoryTest.generateOOM2();
        }
        catch (Exception e)
        {
            logger.error(e.getLocalizedMessage());
        }
    }

    public void generateOOM() throws Exception {
        int iteratorValue = 20;
        System.out.println("\n=================> OOM test started..\n");
        for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
            System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
            int loop1 = 2;
            int[] memoryFillIntVar = new int[iteratorValue];
            // feel memoryFillIntVar array in loop..
            do {
                memoryFillIntVar[loop1] = 0;
                loop1--;
            } while (loop1 > 0);
            iteratorValue = iteratorValue * 5;
            System.out.println("\nRequired Memory for next loop: " + iteratorValue);
            Thread.sleep(1000);
        }
    }

    public void generateOOM2() throws Exception {
        int iteratorValue = 20;
//        System.out.println("\n=================> OOM test started..\n");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String S = new String("test string");
            generateOOM2();
            //System.out.println("\nRequired Memory for next loop: " + iteratorValue);
        }
    }
}
