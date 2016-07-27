package jmp.training.memory.manage;

public class LinkTest {
    private Integer previus=new Integer(100000);
    private Integer next=new Integer(100000);
    private LinkTest link;


    public LinkTest() {
    }

    public LinkTest(Integer previus, Integer next) {
        this.previus = previus;
        this.next = next;
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

    @Override
    public String toString() {
        return "Link{" +
//                "previus=" + previus +
//                ", next=" + next +
                "link=" + link +
                '}';
    }
}
