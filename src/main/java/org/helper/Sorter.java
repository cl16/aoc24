package org.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {

    public static List<Integer> quickSort(List<Integer> items) {
        int itemsLen = items.size();
        if (itemsLen < 2) {
            return items;
        }

        int pivotPoint = Math.floorDiv(itemsLen, 2);
        int pivotValue = items.get(pivotPoint);

        List<Integer> lowList = new ArrayList<>();
        List<Integer> highList = new ArrayList<>();

        int i;
        int j;
        for (i = 0; i < itemsLen; i++) {
            if (i == pivotPoint) {
                continue;
            }
            j = items.get(i);
            if (j <= pivotValue) {
                lowList.add(j);
            }
            else {
                highList.add(j);
            }
        }

        List<Integer> lowResult = quickSort(lowList);
        Collections.addAll(lowResult, pivotValue);
        lowResult.addAll(quickSort(highList));
        return lowResult;
    }
}
