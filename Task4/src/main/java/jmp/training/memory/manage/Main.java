package jmp.training.memory.manage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static LinkTest root = new LinkTest();;

    public static void main(String[] args) {

        Main memoryTest = new Main();
        try
        {
            memoryTest.generateOOM2();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void generateOOM2() throws Exception {
        System.out.println("\n=================> OOM test started..\n");
//        LinkTest root = new LinkTest();
        LinkTest previus = new LinkTest();
        root.setLink(previus);// this is next
        Random r = new Random(Integer.MAX_VALUE);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("belavia_ground.jpg").getFile());

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Integer p = r.nextInt();
            Integer n = r.nextInt();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            int a = bufferedReader.read();

            LinkTest next = new LinkTest(p,n, bufferedReader);
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
