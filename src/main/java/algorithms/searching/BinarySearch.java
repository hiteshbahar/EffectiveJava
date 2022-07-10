package algorithms.searching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinarySearch {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinarySearch.class);

    public int recursiveBinarySearch(int search, int[] input, int left, int right) {
        LOGGER.info("Inside Recursive Binary Search operation");

        if (right >= left && left <= input.length - 1) {
            int mid = left + (right - left) / 2;
            if (input[mid] == search) {
                return mid;
            }
            if (input[mid] > search) {
                return recursiveBinarySearch(search, input, left, mid - 1);
            }
            return recursiveBinarySearch(search, input, mid + 1, right);
        }
        return -1;
    }

    public int iterativeBinarySearch(int search, int[] input) {
        LOGGER.info("Inside Iterative Binary Search Operation");
        int left = 0, right = input.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (input[mid] == search) {
                return mid;
            }
            if (input[mid] < search) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
