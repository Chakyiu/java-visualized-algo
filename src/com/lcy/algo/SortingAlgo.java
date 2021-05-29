package com.lcy.algo;

import com.lcy.data.Data;
import com.lcy.data.State;
import com.lcy.window.WindowPanel;

import java.util.ArrayList;

public class SortingAlgo implements Runnable {

    protected ArrayList<Data> dataArrayList;
    protected WindowPanel panel;
    protected boolean running;
    protected Integer DELAY;

    public SortingAlgo(ArrayList<Data> dataArrayList, WindowPanel panel, Integer delay) {
        this.dataArrayList = dataArrayList;
        this.panel = panel;
        this.running = true;
        this.DELAY = delay;
    }

    protected void clearColor(int index) {
        if (dataArrayList.get(index).getState() != State.STABLE) {
            dataArrayList.get(index).setState(State.PENDING);
        }
    }

    protected void shortDelay(int delay) {
        panel.setDataArrayList(dataArrayList);

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void swap(int i, int j) {
        Data temp = dataArrayList.get(i);
        dataArrayList.set(i, dataArrayList.get(j));
        dataArrayList.set(j, temp);
    }

    public void run() {
        System.out.println("Running");
    }
}
