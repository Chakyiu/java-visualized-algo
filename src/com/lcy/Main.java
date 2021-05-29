package com.lcy;

import com.lcy.algo.SelectionSort;
import com.lcy.data.Data;
import com.lcy.data.State;
import com.lcy.window.WindowFrame;
import com.lcy.window.WindowPanel;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static Thread thread;

    static ArrayList<Data> dataArrayList = new ArrayList<Data>();


    static ArrayList<Data> genRandomDataArray(int length) {
        ArrayList<Data> temp = new ArrayList<Data>();
        for (int i = 0; i < length; i++) {
            temp.add(new Data(i, State.PENDING));
        }
        Collections.shuffle(temp);
        return temp;
    }

    public static void main(String[] args) {
        dataArrayList = genRandomDataArray(100);
        WindowPanel panel = new WindowPanel(dataArrayList);
        WindowFrame frame = new WindowFrame("Visualized Algo", panel);

        thread = new Thread(new SelectionSort(dataArrayList, panel, 10));
        thread.start();
    }
}
