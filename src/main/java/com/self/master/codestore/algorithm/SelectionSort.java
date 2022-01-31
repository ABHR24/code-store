package com.self.master.codestore.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ABHR24
 * selection sorting algorithm.
 * Need 3 indices i,j,and min
 * Step 1: Compare the min index with the j index value
 * Step 2: Find the lowest min number in the array after the current pointer and replace the min index
 * Step 3: Swap the min with i index
 * <p>
 * Worst case complexity O(n^2)
 */
@Slf4j
public class SelectionSort {

    int[] arr;
    int n;

    public SelectionSort(int[] arr) {
        this.arr = arr;
        n = arr.length - 1;
    }

    /*
       key is to compare with the minimum index with j index
       and then swap the min index with i index
     */
    public void sort() {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j <= n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(arr[i]);
            if (i != n) {
                sb.append(" ");
            }
        }
        log.info("sorted array: {}", sb.toString());
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 3, 6, 7, 8, 5};
        SelectionSort selectionSort = new SelectionSort(arr);
        selectionSort.sort();
        selectionSort.display();
    }
}
