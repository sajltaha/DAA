import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetricsTest {
    @Test
    void testCounters() {
        Metrics.reset();
        Metrics.incrementComparisons();
        Metrics.incrementAllocations();
        assertEquals(1, Metrics.getComparisons());
        assertEquals(1, Metrics.getAllocations());
    }

    @Test
    void testDepthTracker() {
        Metrics.reset();
        Metrics.enterRecursion();
        assertEquals(1, Metrics.getDepth());
        Metrics.exitRecursion();
        assertEquals(0, Metrics.getDepth());
    }
}