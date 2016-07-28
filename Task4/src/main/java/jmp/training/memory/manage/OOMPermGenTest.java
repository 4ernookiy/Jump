package jmp.training.memory.manage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//
import static java.lang.reflect.Array.newInstance;

public class OOMPermGenTest {
    private static final Logger logger = LoggerFactory.getLogger(OOMPermGenTest.class);

    public static void main(String[] args) {

        ClassLoader classLoader = OOMPermGenTest.class.getClassLoader();
        try {
            Class aClass = classLoader.loadClass("jmp.training.memory.manage.OOMPermGenTest");
            System.out.println("Class.getName() = " + aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String classToLoad = "jmp.training.memory.manage.OOMPermGenTest";

        try {
            for (; ; ) {
                ClassLoader cl = new CCLoader();
                Class<?> userClass = cl.loadClass(classToLoad);
//                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
