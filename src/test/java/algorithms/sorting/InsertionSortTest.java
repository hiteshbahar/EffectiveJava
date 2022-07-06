package algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest {

    @Test
    void insertionSort() {
        int arr[] = {21, 11, 30, 5, -6};
        int expected[] = {-6, 5, 11, 21, 30};
        InsertionSort insertionSort = new InsertionSort();
        int[] sortedArray = insertionSort.insertionSort(arr);
        assertArrayEquals(expected, sortedArray);
    }
}