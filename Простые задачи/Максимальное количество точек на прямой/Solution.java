class Solution {

    private final double EPS = 1e-5;

    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }

        int max = 0;

        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                int x2 = points[j][0];
                int y2 = points[j][1];

                int counter = 0;

                for (int l = 0; l < points.length; l++) {
                    int x3 = points[l][0];
                    int y3 = points[l][1];

                    if (x1 == x2) {
                        counter = (x3 == x1 ? counter + 1 : counter);
                    } else if (y1 == y2) {
                        counter = (y3 == y1 ? counter + 1 : counter);
                    } else {
                        double[] coefficients = calculateKAndB(x1, y1, x2, y2);
                        double k = coefficients[0];
                        double b = coefficients[1];
                        if (Math.abs(k * x3 + b - y3) < EPS) {
                            counter++;
                        }
                    }
                }
                max = Math.max(max, counter);
            }
        }

        return max;
    }

    private double[] calculateKAndB(int x1, int y1, int x2, int y2) {
        int d = x1 - x2;
        int dk = y1 - y2;
        int db = x1 * y2 - y1 * x2;

        double k = (double) dk / d;
        double b = (double) db / d;

        return new double[]{k, b};
    }
}
