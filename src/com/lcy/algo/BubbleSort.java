package com.lcy.algo;

import com.lcy.data.Data;
import com.lcy.data.State;
import com.lcy.window.WindowPanel;

import java.util.ArrayList;

import static com.lcy.Main.sortingSelection;

public class BubbleSort extends SortingAlgo{

    public BubbleSort(ArrayList<Data> dataArrayList, WindowPanel panel, Integer delay) {
        super(dataArrayList, panel, delay);
    }

    @Override
    public void run() {
        if (running) {
            for (int i = 0; i < dataArrayList.size() - 1; i++) {
                dataArrayList.get(i).setState(State.SELECTED_MAIN);
                shortDelay(1);

                for (int j = i + 1; j < dataArrayList.size(); j++) {
                    dataArrayList.get(j).setState(State.SELECTED);
                    shortDelay(1);

                    if (dataArrayList.get(j).getNumber() < dataArrayList.get(i).getNumber()) {
                        swap(i, j);
                        shortDelay(1);
                    }
                    clearColor(j);
                }

                dataArrayList.get(i).setState(State.STABLE);
                shortDelay(DELAY);
            }
        }

        running = false;

        try {
            sortingSelection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
