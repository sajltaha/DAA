import java.util.Arrays;

public class ClosestPair {
    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double findClosestPair(Point[] points) {
        Metrics.reset();
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("At least 2 points required");
        }
        Point[] pointsByX = points.clone();
        Point[] pointsByY = points.clone();
        Arrays.sort(pointsByX, (a, b) -> Double.compare(a.x, b.x));
        Arrays.sort(pointsByY, (a, b) -> Double.compare(a.y, b.y));
        return findClosestPair(pointsByX, pointsByY, 0, points.length - 1);
    }

    private static double findClosestPair(Point[] pointsByX, Point[] pointsByY, int left, int right) {
        Metrics.enterRecursion();
        if (right - left <= 3) {
            double minDist = Double.POSITIVE_INFINITY;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    Metrics.incrementComparisons();
                    double dist = distance(pointsByX[i], pointsByX[j]);
                    minDist = Math.min(minDist, dist);
                }
            }
            Metrics.exitRecursion();
            return minDist;
        }

        int mid = left + (right - left) / 2;
        Point midPoint = pointsByX[mid];
        Point[] leftY = new Point[mid - left + 1];
        Point[] rightY = new Point[right - mid];
        int li = 0, ri = 0;
        for (Point p : pointsByY) {
            if (p.x <= midPoint.x && li < leftY.length) leftY[li++] = p;
            else if (ri < rightY.length) rightY[ri++] = p;
        }

        double leftDist = findClosestPair(pointsByX, leftY, left, mid);
        double rightDist = findClosestPair(pointsByX, rightY, mid + 1, right);
        double minDist = Math.min(leftDist, rightDist);

        Point[] strip = new Point[right - left + 1];
        int stripSize = 0;
        for (Point p : pointsByY) {
            if (Math.abs(p.x - midPoint.x) < minDist) {
                strip[stripSize++] = p;
            }
        }
        double stripDist = stripClosest(strip, stripSize, minDist);
        Metrics.exitRecursion();
        return Math.min(minDist, stripDist);
    }

    private static double stripClosest(Point[] strip, int size, double minDist) {
        double minStripDist = minDist;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < minDist; j++) {
                Metrics.incrementComparisons();
                double dist = distance(strip[i], strip[j]);
                minStripDist = Math.min(minStripDist, dist);
            }
        }
        return minStripDist;
    }

    private static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}