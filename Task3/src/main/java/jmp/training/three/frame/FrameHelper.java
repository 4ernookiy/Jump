package jmp.training.three.frame;

import javax.swing.*;
import java.awt.*;

@Deprecated
public class FrameHelper {
    private static FrameHelper instance;

    public JFrame createFrame(String title, int width, int height) {
        JFrame frame = new JFrame();
        frame.setBounds(300, 100, 970, 600);
        frame.setBackground(new Color(120, 119, 117));
        frame.setSize(width, height);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }


    public static FrameHelper getInstance() {
        if (instance == null) {
            instance = new FrameHelper();
        }
        return instance;
    }


}
