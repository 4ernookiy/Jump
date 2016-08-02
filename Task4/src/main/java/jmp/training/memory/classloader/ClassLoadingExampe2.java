package jmp.training.memory.classloader;

import jmp.training.memory.classloading.LeakClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by D on 02.08.2016.
 */
public class ClassLoadingExampe2 {
    private static final Logger logger = LoggerFactory.getLogger(ClassLoadingExampe2.class);

    public static void main(String[] args) {

        LeakClassLoader leakClassLoader = new LeakClassLoader();
        try {

            String path = "jmp.training.memory.classloader.Semaphore";
            String path1 = "jmp.training.memory.classloader.v1.Semaphore";
            String path2 = "jmp.training.memory.classloader.v2.Semaphore";

            loadClassFromPath(leakClassLoader, path);
            loadClassFromPath(leakClassLoader, path1);
            loadClassFromPath(leakClassLoader, path2);

        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    private static void loadClassFromPath(ClassLoader loader, String path) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c = loader.loadClass(path);
        Object o = c.newInstance();
        Method m = c.getMethod(Semaphore.METHOD_LEVER);
        m.invoke(o);
        System.out.println("");
    }
}
