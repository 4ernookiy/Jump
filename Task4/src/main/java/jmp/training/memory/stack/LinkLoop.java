package jmp.training.memory.stack;

public class LinkLoop {
    private String text;
    private LinkLoop link;

    public LinkLoop() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LinkLoop getLink() {
        return link;
    }

    public void setLink(LinkLoop link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "LinkLoop{" +
                "text='" + text + '\'' +
                ", link=" + link +
                '}';
    }
}
