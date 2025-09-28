import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {
    @Test
    void testSmallSet() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(2, 2),
                new ClosestPair.Point(3, 3)
        };
        double dist = ClosestPair.findClosestPair(points);
        assertTrue(dist >= 0 && dist <= Math.sqrt(2));
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            ClosestPair.findClosestPair(new ClosestPair.Point[1]);
        });
    }
}