package jmp.training.memory.classloading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class LeakClassLoader extends URLClassLoader {
    private static final Logger logger = LoggerFactory.getLogger(LeakClassLoader.class);
    private static int i = 0;

    public LeakClassLoader() {
        this(getContextClassLoaderClassPath());
    }

    public LeakClassLoader(URL url) {
        super(new URL[]{url});
    }

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        if (className != null && className.startsWith("jmp")) {
            if (i % 100000 == 0) {
                logger.info("Load Class :{}", className);
            }
            i++;
            Class c = findClass(className);
            return c;
        } else {
            return super.loadClass(className);
        }
    }

    static URL getContextClassLoaderClassPath() {
        URL url = Thread.currentThread().getContextClassLoader().getResource(".");
        if (i % 100000 == 0) {
            logger.info("url {}",url);
        }
        return url;
    }

    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ArrayList list = new ArrayList();
        while (true) {
                Class c = InstanceGenerator.newInstance();
                list.add(c);
        }
    }

}
