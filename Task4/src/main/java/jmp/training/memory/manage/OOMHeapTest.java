package jmp.training.memory.manage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Random;

public class OOMHeapTest {
    private static final Logger logger = LoggerFactory.getLogger(OOMHeapTest.class);
    private static LinkTest root = new LinkTest();;

    public static void main(String[] args) {

        OOMHeapTest memoryTest = new OOMHeapTest();
        try
        {
            memoryTest.generateOOM2();
        }
        catch (Exception e)
        {
            logger.error(e.getLocalizedMessage());
        }
    }

    public void generateOOM2() throws Exception {
        LinkTest previus = new LinkTest();
        root.setLink(previus);// this is next
        Random r = new Random(Integer.MAX_VALUE);

        InputStream input = getClass().getResourceAsStream("/belavia_ground.jpg");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Integer p = r.nextInt();
            Integer n = r.nextInt();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            int a = reader.read();

            LinkTest next = new LinkTest(p,n, reader);
            previus.setLink(next);
            previus = next;
            if(i % 1500 == 0) {
                String s= "Iteration " + i + " Free Mem: " + Runtime.getRuntime().freeMemory();
                System.out.println(s);
            }
        }
    }

    public void generateOOMHeap2(){
        int[] i = new int[Integer.MAX_VALUE/2];
    }
}
