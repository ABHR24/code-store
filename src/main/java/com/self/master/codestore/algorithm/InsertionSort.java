package com.self.master.codestore.algorithm;

import lombok.extern.slf4j.Slf4j;

import static com.self.master.codestore.CodeStoreUtility.display;

/**
 * @author ABHR24
 * insertion sorting algorithm.
 * <p>
 * Step1 : init j with i+1
 * Step2 : compare the j with j-1 until j>0
 * Step3 : if [j] is lesser than [j-1] swap
 * <p>
 * Worst Case : O(n^2)
 */
@Slf4j
public class InsertionSort {

    /**
     * Key is to keep the sorted to one side and unsorted to the other
     * @param arr the unsorted array
     * @return the sorted array
     */
    public int[] sort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    j--;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 3, 6, 7, 8, 5};
        InsertionSort insertionSort = new InsertionSort();
        log.info("sorted array: {}", display(insertionSort.sort(arr)));
    }
}
