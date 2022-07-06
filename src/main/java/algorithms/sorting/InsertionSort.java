package algorithms.sorting;

public class InsertionSort {

    // Time Complexity : O(n^2)
    // Space Complexity: O(1)

    public int[] insertionSort(int[] arr) {
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
