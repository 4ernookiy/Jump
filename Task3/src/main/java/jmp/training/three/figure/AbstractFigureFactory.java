package jmp.training.three.figure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D on 25.07.2016.
 */
public abstract class AbstractFigureFactory{

    public static IFigureFactory getInstance() {
        return new SimpleFactoryOne();
    }

    public static <T> List<T> newList(String s)
    {
        List<T> list = new ArrayList<T>();
        T t=null;
        if ("b".equals(s)){
            t = (T) getInstance().getBall(10);
        }
        if ("r".equals(s)){
            t = (T) getInstance().getRectangle(10,10);
        }

        list.add(t);
        return list;
    }
}
