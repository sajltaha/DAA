import java.io.IOException;

public class CLI {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar target/assignment1-1.0-SNAPSHOT-jar-with-dependencies.jar <algorithm> <size>");
            System.out.println("Algorithms: mergesort, quicksort, closest");
            return;
        }

        String algo = args[0].toLowerCase();
        int size = Integer.parseInt(args[1]);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * 100);

        long startTime = System.nanoTime();
        switch (algo) {
            case "mergesort":
                MergeSort.sort(arr);
                break;
            case "quicksort":
                QuickSort.sort(arr);
                break;
            case "closest":
                ClosestPair.Point[] points = new ClosestPair.Point[size];
                for (int i = 0; i < size; i++) points[i] = new ClosestPair.Point(Math.random() * 100, Math.random() * 100);
                ClosestPair.findClosestPair(points);
                break;
            default:
                System.out.println("Unknown algorithm: " + algo);
                return;
        }
        long endTime = System.nanoTime();

        CSVWriter.writeMetrics("metrics.csv", endTime - startTime, Metrics.getDepth(), Metrics.getComparisons(), Metrics.getAllocations());
        System.out.println("Done. Results written to metrics.csv");
    }
}