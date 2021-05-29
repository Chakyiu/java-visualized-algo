package com.lcy.window;

import com.lcy.data.Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WindowFrame extends JFrame {
    private WindowPanel panel;

    public WindowFrame(String title, WindowPanel panel) throws HeadlessException {
        super(title);

        this.panel = panel;
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
