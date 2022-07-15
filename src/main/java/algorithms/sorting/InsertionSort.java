package algorithms.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertionSort {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsertionSort.class);

    public int[] insertionSort(int[] arr) {
        LOGGER.info("Performing insertion sort for the given input.");
        int length = arr.length;
        for (int left = 1; left < length; ++left) {
            int value = arr[left];
            int right = left - 1;
            while (right >= 0 && arr[right] > value) {
                arr[right + 1] = arr[right];
                right = right - 1;
            }
            arr[right + 1] = value;
        }
        return arr;
    }
}
