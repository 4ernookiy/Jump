package jmp.training.memory.classloader.v1;

/**
 * Created by D on 02.08.2016.
 */
public class Semaphore extends jmp.training.memory.classloader.Semaphore{
    public static final String METHOD_LEVER="lever";

    @Override
    public void lever() {
        System.out.println("It works!-V1");
    }
}
