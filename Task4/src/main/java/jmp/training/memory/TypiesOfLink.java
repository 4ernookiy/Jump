package jmp.training.memory;


import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TypiesOfLink
{

    public static void main(String[] args) {
        ReferenceQueue rq = new ReferenceQueue();

        MyDouble pi = new MyDouble("pi", 3.1415);
        MyDouble g = new MyDouble("g", 9.8);
        MyDouble e = new MyDouble("e", 2.2);

        WeakReference<MyDouble> weakPI = new WeakReference<MyDouble>(pi, rq);
        SoftReference<MyDouble> softG = new SoftReference<MyDouble>(g, rq);
        PhantomReference<MyDouble> phantomE = new PhantomReference<MyDouble>(e, rq);

        System.out.println("strong");
        System.out.println(weakPI.get());
        System.out.println(softG.get());
        System.out.println(phantomE.get());

        pi = null;
        g =null;
        e =null;

        System.out.println("after nulling");
        System.out.println(weakPI.get());
        System.out.println(softG.get());
        System.out.println(phantomE.get());

        System.gc();

        System.out.println("after GC call");
        System.out.println(weakPI.get());
        System.out.println(softG.get());
        System.out.println(phantomE.get());

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e1)
        {
            e1.printStackTrace();
        }
        System.out.println("RQ "+rq.poll());
        System.out.println("RQ "+rq.poll());
        System.out.println("RQ "+rq.poll());

    }



}

class MyDouble
{
    private Double value;
    public String name;

    public MyDouble(String name,Double value)
    {
        this.value = value;
        this.name = name;
    }

    @Override
    protected void finalize(){
        System.out.println("The " + name + " with " + value + " will be finalized");
    }

    @Override
    public String toString()
    {
        return
            name + '-' + value;
    }
}
