package algorithms.sorting;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    @Test
    public void sortSuccess() {
        MergeSort mergeSort = new MergeSort();
        int[] actual = { 6, 1, 5, 2, 4, 3 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        mergeSort.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }

}