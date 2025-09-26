import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {
    @Test
    void testSortRandomArray() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSortSmallArray() {
        int[] arr = {5, 2, 9};
        int[] expected = {2, 5, 9};
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}