package com.lcy.algo;

import com.lcy.data.Data;
import com.lcy.data.State;
import com.lcy.window.WindowPanel;

import java.util.ArrayList;

import static com.lcy.Main.sortingSelection;

public class SelectionSort extends SortingAlgo{

    public SelectionSort(ArrayList<Data> dataArrayList, WindowPanel panel, Integer delay) {
        super(dataArrayList, panel, delay);
    }

    @Override
    public void run() {
        if (running) {
            for (int i = 0; i < dataArrayList.size() - 1; i++) {
                int min_index = i;
                dataArrayList.get(min_index).setState(State.SELECTED_MAIN);
                shortDelay(1);

                for (int j = i + 1; j < dataArrayList.size(); j++) {
                    dataArrayList.get(j).setState(State.SELECTED);
                    if (dataArrayList.get(j).getNumber() < dataArrayList.get(min_index).getNumber()) {
                        clearColor(min_index);
                        min_index = j;
                    } else {
                        clearColor(j);
                    }
                    shortDelay(1);
                }
                swap(min_index, i);
                clearColor(min_index);
                dataArrayList.get(i).setState(State.STABLE);
                shortDelay(DELAY);
            }

            running = false;

            try {
                sortingSelection();
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }
}
