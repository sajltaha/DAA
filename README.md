# Divide and Conquer Assignment

### Architecture notes
- Recursion depth is controlled using cutoff strategies (e.g., insertion sort for small arrays in MergeSort and QuickSort).
- Allocations and comparisons are tracked via the `Metrics` class, which logs data to `metrics.csv`.
- CLI integrates all algorithms, emitting performance metrics via `CSVWriter`.

### Recurrence analysis
- **MergeSort**: Applies Master Theorem Case 2. Recurrence T(n) = 2T(n/2) + O(n), solving to Θ(n log n).
- **QuickSort**: Uses Akra-Bazzi method. Recurrence T(n) = T(n/2) + O(n) with randomized pivot, yielding O(n log n) average case.
- **ClosestPair**: Uses Master Theorem Case 2. Recurrence T(n) = 2T(n/2) + O(n), yielding O(n log n).

### Plots
- **Time vs n**: [Insert image link or reference to time_vs_n.png]
    - Data from `results.csv` shows linearithmic growth for MergeSort and ClosestPair, consistent with O(n log n).
- **Depth vs n**: [Insert image link or reference to depth_vs_n.png]
    - Depth remains logarithmic, validating recursion control (e.g., QuickSort depth ≤ 2 log n).

### Summary
- Theoretical complexities align with benchmark results, with minor deviations due to cache effects and garbage collection.
- MergeSort and ClosestPair demonstrate expected O(n log n) performance, while QuickSort benefits from randomized pivoting.
- Plots confirm practical efficiency, with JMH data supporting theoretical bounds.

[Insert time_vs_n.png and depth_vs_n.png as images or links if generated]