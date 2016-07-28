package jmp.training.memory.manage;

public class LinkTest {
    private Integer previus;
    private Integer next;
    private Readable buffer;
    private LinkTest link;


    public LinkTest() {
    }

    public LinkTest(Integer previus, Integer next) {
        this.previus = previus;
        this.next = next;
    }

    public LinkTest(Integer previus, Integer next, Readable buffer)
    {
        this.previus = previus;
        this.next = next;
        this.buffer = buffer;
    }

    public Integer getPrevius() {
        return previus;
    }

    public void setPrevius(Integer previus) {
        this.previus = previus;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public LinkTest getLink() {
        return link;
    }

    public void setLink(LinkTest link) {
        this.link = link;
    }

    public Readable getBuffer()
    {
        return buffer;
    }

    public void setBuffer(Readable buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public String toString() {
        return "Link{" +
//                "previus=" + previus +
//                ", next=" + next +
                "link=" + link +
                '}';
    }
}
