package com.lcy.window;

import com.lcy.data.Data;
import com.lcy.data.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WindowPanel extends JPanel implements ActionListener {

    ArrayList<Data> dataArrayList = new ArrayList<Data>();
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 500;
    static final int DELAY = 75;

    boolean running = false;
    Timer timer;
    Random random;

    public WindowPanel(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;

        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);

        start();
    }

    public void start() {
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < dataArrayList.size(); i++) {
            switch (dataArrayList.get(i).getState()) {
                case PENDING -> g.setColor(Color.WHITE);
                case SELECTED -> g.setColor(Color.BLUE);
                case SELECTED_MAIN -> g.setColor(Color.RED);
                case STABLE -> g.setColor(Color.GREEN);
                default -> g.setColor(Color.BLACK);
            }

            g.fillRect(i * 10, 500 - 5 * dataArrayList.get(i).getNumber() , 5, 5);
        }
    }

    public void setDataArrayList(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
        }

        repaint();
    }

}
