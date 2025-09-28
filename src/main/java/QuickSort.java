public class QuickSort {
    public static void sort(int[] arr) {
        Util.guard(arr);
        Metrics.reset();
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        Metrics.enterRecursion();
        if (left < right) {
            int pivotIdx = Util.partition(arr, left, right);
            if (pivotIdx - left < right - pivotIdx) {
                sort(arr, left, pivotIdx - 1);
                sort(arr, pivotIdx + 1, right);
            } else {
                sort(arr, pivotIdx + 1, right);
                sort(arr, left, pivotIdx - 1);
            }
        }
        Metrics.exitRecursion();
    }
}