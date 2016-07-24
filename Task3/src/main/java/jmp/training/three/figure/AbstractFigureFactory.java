package jmp.training.three.figure;

/**
 * Created by D on 25.07.2016.
 */
public abstract class AbstractFigureFactory{

    public static IFigureFactory getInstance() {
        return new SimpleFactoryOne();
    }
}
