import java.util.Random;

public class QuickSort {
    private static final Random rand = new Random();

    public static void sort(int[] arr) {
        Metrics.reset();
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        Metrics.enterRecursion();
        if (left < right) {
            int pivotIdx = randomizedPartition(arr, left, right);
            if (pivotIdx - left < right - pivotIdx) {
                sort(arr, left, pivotIdx - 1);
                sort(arr, pivotIdx + 1, right); // Исправлено: рекурсивно сортируем большую часть
            } else {
                sort(arr, pivotIdx + 1, right);
                sort(arr, left, pivotIdx - 1); // Исправлено: рекурсивно сортируем большую часть
            }
        }
        Metrics.exitRecursion();
    }

    private static int randomizedPartition(int[] arr, int left, int right) {
        int pivotIdx = left + rand.nextInt(right - left + 1);
        swap(arr, pivotIdx, right);
        return partition(arr, left, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            Metrics.incrementComparisons();
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}