package jmp.training.three.was;

import javax.swing.*;
import java.awt.*;

public class FrameHelper {
//    private static FrameHelper instance;
//    public JFrame createFrame(String title, int width, int height) {
//        JFrame frame = new JFrame();
//        frame.setBounds(300, 100, 970, 600);
//        frame.setBackground( new Color(120, 119, 117) );
//        frame.setSize(width, height);
//        frame.setTitle(title);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        return frame;
//    }


//    public static FrameHelper getInstance() {
//        if (instance == null) {
//            instance = new FrameHelper();
//        }
//        return instance;
//    }

    private FrameHelper(FrameBuilder builder) {


    }

    public static class FrameBuilder {
        private int width;
        private int height;
        private String title;
        private Color color;

        public FrameBuilder() {
        }

        public FrameBuilder(String title) {
            this.title = title;
        }

        public FrameBuilder width(int width) {
            this.width = width;
            return this;
        }

        public FrameBuilder height(int height) {
            this.height = height;
            return this;
        }

        public FrameBuilder title(String title) {
            this.title = title;
            return this;
        }

        public FrameBuilder color(Color color) {
            this.color = color;
            return this;
        }

        public JFrame build() {
            JFrame frame = new JFrame();
            frame.setBounds(300, 100, 970, 600);
            frame.setBackground(this.color);
            frame.setSize(this.width, this.height);
            frame.setTitle(this.title);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            return frame;
        }
    }


}
