public class Metrics {
    private static long comparisons = 0;
    private static long allocations = 0;
    private static ThreadLocal<Integer> depth = ThreadLocal.withInitial(() -> 0);

    public static void incrementComparisons() { comparisons++; }
    public static void incrementAllocations() { allocations++; }
    public static void enterRecursion() { depth.set(depth.get() + 1); }
    public static void exitRecursion() { depth.set(depth.get() - 1); }
    public static long getComparisons() { return comparisons; }
    public static long getAllocations() { return allocations; }
    public static int getDepth() { return depth.get(); }
    public static void reset() { comparisons = 0; allocations = 0; depth.set(0); }
}