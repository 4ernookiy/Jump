package jmp.training.memory.manage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

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
        System.out.println("\n=================> OOM test started..\n");
        LinkTest root = new LinkTest();
        LinkTest previus = new LinkTest();
        root.setLink(previus);// this is next
        Random r = new Random(Integer.MAX_VALUE);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Integer p = new Integer(r.nextInt());
            Integer n = new Integer(r.nextInt());
            LinkTest next = new LinkTest(p,n);
            previus.setLink(next);
            previus = next;
            if(i % 1000000 == 0) {
                String s= "Iteration " + i + " Free Mem: " + Runtime.getRuntime().freeMemory();
                System.out.println(s);
            }
        }
    }
}
