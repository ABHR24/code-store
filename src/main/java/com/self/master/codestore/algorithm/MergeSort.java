package com.self.master.codestore.algorithm;

import lombok.extern.slf4j.Slf4j;

import static com.self.master.codestore.CodeStoreUtility.display;

/**
 * Merge Sort Algorithm
 * <p>
 * A recursive strategy
 * Step1 : find the middle
 * Step2 : sort the array from start to mid
 * Step3 : sort the array from mid to end
 * Step4 : merge the sorted halves
 * <p>
 * Worst Case: O(nlogn)
 */
@Slf4j
public class MergeSort {

    /**
     * Key is to sort the two halves and merge them
     *
     * @param arr array to be sorted
     * @param p   starting point for the elements to be sorted
     * @param r   ending point for the elements to be sorted
     * @return sorted array
     */
    public int[] sort(int[] arr, int p, int r) {
        if (p < r) {
            int mid = (p + r) / 2;
            sort(arr, p, mid);
            sort(arr, mid + 1, r);
            merge(arr, p, mid, r);
        }
        return arr;
    }

    /**
     * Merge is comparing the two slots; left and right slot values and putting it to temp array. Finally replacing the temp to the actual array.
     *
     * @param arr arr with elements to be merge
     * @param p   start of the elements to be merged
     * @param mid mid of the elements to be merged
     * @param r   end of the elements to be merged
     */
    private void merge(int[] arr, int p, int mid, int r) {
        int temp[] = new int[(r - p) + 1];
        int k = 0;
        int leftSlot = p;
        int rightSlot = mid + 1;
        while (mid >= leftSlot && rightSlot <= r) {
            if (arr[rightSlot] > arr[leftSlot]) {
                temp[k] = arr[leftSlot];
                leftSlot++;
            } else {
                temp[k] = arr[rightSlot];
                rightSlot++;
            }
            k++;
        }
        if (leftSlot <= mid) {
            for (int i = leftSlot; i <= mid; i++) {
                temp[k] = arr[i];
                k++;
            }
        }
        if (rightSlot <= r) {
            for (int i = rightSlot; i <= r; i++) {
                temp[k] = arr[i];
                k++;
            }
        }
        for (int i = 0; i <= temp.length - 1; i++) {
            arr[i + p] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 3, 6, 7, 8, 5};
        MergeSort mergeSort = new MergeSort();
        log.info("sorted array: {}", display(mergeSort.sort(arr, 0, arr.length - 1)));
    }
}
