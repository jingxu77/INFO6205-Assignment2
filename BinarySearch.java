public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = { 2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15 };
        // example outputs
        System.out.println("Target 4 = " + countOccurrences(sortedArray, 4) + " Occurrences");
        System.out.println("Target 2 = " + countOccurrences(sortedArray, 2) + " Occurrences");
        System.out.println("Target 5 = " + countOccurrences(sortedArray, 5) + " Occurrences");

        System.out.println("--------------------");

        int[] rotatedSortedArray = {6, 7, 8, 2, 3, 4, 5};
        System.out.println("Target 8 = " + findRotated(rotatedSortedArray, 8));
        System.out.println("Target 9 = " + findRotated(rotatedSortedArray, 9));
    }

    // method to count occurrences of a target in a sorted array
    public static int countOccurrences(int[] arr, int target) {
        int left = findIndex(arr, target, true);
        if (left == -1)
            return 0; // target is not in the array
        int right = findIndex(arr, target, false);
        return right - left + 1;
    }

    // binary search method to find the first or last occurrence of a target
    private static int findIndex(int[] arr, int target, boolean firstOccurrence) {
        int lo = 0, hi = arr.length - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (firstOccurrence) hi = mid - 1;
                else lo = mid + 1;
            } else if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return result;
    }

     // binary search method to find a target in a rotated sorted array
    public static int findRotated(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2; 
            if (arr[mid] == target) return mid;
            // check if the left side is sorted
            if (arr[lo] <= arr[mid]) {
                if (target >= arr[lo] && target < arr[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else { // the right side is sorted
                if (target > arr[mid] && target <= arr[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1; // target is not in the array
    }
}
