package jmp.training.memory.classloading;

public class InstanceGenerator {
    private static String s = LeakClass.class.getCanonicalName();

    public static Class newInstance() throws IllegalAccessException,
            InstantiationException, ClassNotFoundException {
        Class c = null;
            LeakClassLoader classLoader = new LeakClassLoader();
            c = classLoader.loadClass(s);
        return c;
    }
}
