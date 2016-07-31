package jmp.training.memory.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StackTest {

    private static final Logger logger = LoggerFactory.getLogger(StackTest.class);

    public static void main(String[] args) {
       LinkLoop linkLoop1 = new LinkLoop();
       LinkLoop linkLoop2 = new LinkLoop();
        linkLoop1.setLink(linkLoop2);
        linkLoop2.setLink(linkLoop1);

        System.out.println(linkLoop1.toString());


    }


}
