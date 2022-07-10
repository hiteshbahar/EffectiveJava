package algorithms.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeSort {
    private static Logger logger = LoggerFactory.getLogger(MergeSort.class);

    // Time Complexity: O(nLogn)
    // Space Complexity: O(n)

    public void mergeSort(int[] input, int length) {
        logger.info("Inside mergesort method");
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = input[i];
        }
        for (int i = mid; i < length; i++) {
            right[i - mid] = input[i];
        }
        mergeSort(left, mid);
        mergeSort(right, length - mid);

        merge(input, left, right, mid, length - mid);
    }

    public void merge(int[] subArray, int[] leftArray, int[] rightArray, int left, int right) {
        logger.info("Performing Merge operation");

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                subArray[k++] = leftArray[i++];
            } else {
                subArray[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            subArray[k++] = leftArray[i++];
        }
        while (j < right) {
            subArray[k++] = rightArray[j++];
        }
    }
}
