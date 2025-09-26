import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class CSVWriterTest {
    @Test
    void testWriteMetrics() throws IOException {
        String filename = "test_metrics.csv";
        CSVWriter.writeMetrics(filename, 100, 1, 10, 5);
        File file = new File(filename);
        assertTrue(file.exists());
        file.delete();
    }
}