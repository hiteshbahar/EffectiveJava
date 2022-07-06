package algorithms.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    void recursiveBinarySearchSuccess() {
        BinarySearch binarySearch = new BinarySearch();
        int[] input = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        int search = 110;
        int length = input.length;
        int result = binarySearch.recursiveBinarySearch(search, input, 0, length-1);
        assertEquals(6, result);
    }

    @Test
    void recursiveBinarySearchNoElement() {
        BinarySearch binarySearch = new BinarySearch();
        int[] input = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        int search = 100;
        int length = input.length;
        int result = binarySearch.recursiveBinarySearch(search, input, 0, length-1);
        assertEquals(-1, result);
    }

    @Test
    void recursiveBinarySearchEmptyInput() {
        BinarySearch binarySearch = new BinarySearch();
        int[] input = {};
        int search = 100;
        int result = binarySearch.recursiveBinarySearch(search, input, 0, 0);
        assertEquals(-1, result);
    }

    @Test
    void iterativeBinarySearchSuccess() {
        BinarySearch binarySearch = new BinarySearch();
        int[] input = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        int search = 110;
        int result = binarySearch.iterativeBinarySearch(search, input);
        assertEquals(6, result);
    }

    @Test
    void iterativeBinarySearchNoElement() {
        BinarySearch binarySearch = new BinarySearch();
        int[] input = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        int search = 100;
        int result = binarySearch.iterativeBinarySearch(search, input);
        assertEquals(-1, result);
    }

    @Test
    void iterativeBinarySearchEmptyInput() {
        BinarySearch binarySearch = new BinarySearch();
        int[] input = {};
        int search = 100;
        int result = binarySearch.iterativeBinarySearch(search, input);
        assertEquals(-1, result);
    }
}