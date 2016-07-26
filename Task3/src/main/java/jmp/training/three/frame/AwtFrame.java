package jmp.training.three.frame;

import javax.swing.*;
import java.awt.*;

public class AwtFrame {

    public static class Builder {
        private int x;
        private int y;
        private int width;
        private int height;
        private String title;
        private Color color;

        public Builder() {
        }

        public Builder(String title) {
            this.title = title;
        }

        public Builder withLocationX(int x) {
            this.x = x;
            return this;
        }
        public Builder withLocationY(int y) {
            this.y = y;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder backgroung(Color color) {
            this.color = color;
            return this;
        }

        public JFrame build() {
            JFrame frame = new JFrame();
//            frame.setBounds(300, 100, 970, 600);
            frame.setLocation(x, y);
            frame.setBackground(this.color);
            frame.setSize(this.width, this.height);
            frame.setTitle(this.title);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            return frame;
        }
    }


}
