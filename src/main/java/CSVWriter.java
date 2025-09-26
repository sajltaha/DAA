import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    public static void writeMetrics(String filename, long time, int depth, long comparisons, long allocations) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.append(String.format("%d,%d,%d,%d%n", time, depth, comparisons, allocations));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}