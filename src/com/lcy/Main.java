package com.lcy;

import com.lcy.algo.BubbleSort;
import com.lcy.algo.SelectionSort;
import com.lcy.algo.SortingAlgo;
import com.lcy.data.Data;
import com.lcy.data.State;
import com.lcy.window.WindowFrame;
import com.lcy.window.WindowPanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static Thread thread;
    private static SortingAlgo sorting;
    private static WindowPanel panel;
    private static WindowFrame frame;

    static ArrayList<Data> dataArrayList = new ArrayList<Data>();


    static ArrayList<Data> genRandomDataArray(int length) {
        ArrayList<Data> temp = new ArrayList<Data>();
        for (int i = 0; i < length; i++) {
            temp.add(new Data(i, State.PENDING));
        }
        Collections.shuffle(temp);
        return temp;
    }

    public static void sortingSelection() throws IOException {
        dataArrayList = genRandomDataArray(100);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select sorting algo:\n1) Selection Sort\n2) Bubble Sort");
        System.out.print("Your input: ");
        String input = reader.readLine();

        switch (input) {
            case "1" -> sorting = new SelectionSort(dataArrayList, panel, 10);
            case "2" -> sorting = new BubbleSort(dataArrayList, panel, 10);
        }

        thread = new Thread(sorting);
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        panel = new WindowPanel(dataArrayList);
        frame = new WindowFrame("Visualized Algo", panel);

        sortingSelection();
    }
}
