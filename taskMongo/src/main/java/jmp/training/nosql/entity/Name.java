package jmp.training.nosql.entity;

/**
 * Created by d4 on 20.10.2016.
 */
public class Name {
    private String first;
    private String last;

    public Name() {
    }

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return first + " " + last;
    }
}
