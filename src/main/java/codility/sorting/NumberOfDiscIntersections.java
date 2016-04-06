package codility.sorting;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class NumberOfDiscIntersections {

    class Pair implements Comparable<Pair> {

        public int index;
        public int radius;

        public Pair(final int index, final int radius) {
            this.index = index;
            this.radius = radius;
        }

        @Override
        public int compareTo(final Pair o) {
            if (this.radius > o.radius) {
                return 1;
            } else if (this.radius < o.radius) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public int solution(final int[] A) {

        if (A.length == 0) {
            return 0;
        }

        final long total = ((A.length * A.length) - A.length) / 2;

        final List<Pair> a = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            a.add(new Pair(i, A[i]));
        }
        a.sort(Pair::compareTo);

        final Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            index.put(i, a.get(i).index);
        }
        int shift = 1;
        long disconnectedCount = 0;
        for (int i = 0; i < a.size(); i++) {
            final Pair p1 = a.get(i);
            for (int j = shift; j < a.size(); j++) {
                final Pair p2 = a.get(j);
                if (Math.abs((long)p1.index - (long)p2.index) > Math.abs((long)p1.radius + (long)p2.radius)) {
                    disconnectedCount++;
                } else {
                    // i++;
                    // shift++;
                    break;
                }
            }

            shift++;
        }

        return (int)(total - disconnectedCount);
    }
    // public int solution(final int[] A) {
    //
    // if (A.length == 0) {
    // return 0;
    // }
    //
    // // final long[][] matrix = new long[A.length][A.length];
    //
    // int shift = 1;
    // long intersectionsCount = 0;
    // for (int i = 0; i < A.length; i++) {
    // final long x1 = (long)i - (long)A[i];
    // final long y1 = (long)i + (long)A[i];
    // for (int j = shift; j < A.length; j++) {
    // final long x2 = (long)j - (long)A[j];
    // final long y2 = (long)j + (long)A[j];
    // if (intersects(x1, y1, x2, y2)) {
    // // matrix[i][j] =1;
    // intersectionsCount++;
    // if (intersectionsCount > 10_000_000) {
    // return -1;
    // }
    // }
    // }
    // shift++;
    // }
    //
    // return (int)intersectionsCount;
    // }

    private boolean intersects(final long x1, final long y1, final long x2, final long y2) {

        if ((x2 >= x1 && y2 <= y1) || //
            (x1 >= x2 && y1 <= y2) || //
            (y1 == x2) || (x1 == y2) || //
            (x1 <= x2 && y2 >= y1 && x2 <= y1) || //
            (x2 <= x1 && y1 >= y2 && x1 <= y2)) {
            return true;
        }

        return false;
    }

    // public int solution(final int[] A) {
    //
    // if (A.length == 0) {
    // return 0;
    // }
    //
    // final Map<Long, Long> intersections = new Hashtable();
    // final Map<Long, Long> pairs = new Hashtable();
    //
    // for (int centerPoint = 0; centerPoint < A.length; centerPoint++) {
    // final long radius = A[centerPoint];
    // for (long j = centerPoint - radius; j <= centerPoint + radius; j++) {
    // if (intersections.containsKey(j)) {
    // final Long count = intersections.get(j);
    // intersections.put(j, count + 1);
    // } else {
    // intersections.put(j, 1L);
    // }
    // }
    // }
    //
    // for (final Long key : intersections.keySet()) {
    // if (key > 0 && intersections.containsKey(-key)) {
    // pairs.put(key, intersections.get(key) - intersections.get(-key));
    // }
    // }
    //
    // long counter = 0;
    // for (final Long value : pairs.values()) {
    // counter += value;
    // if (counter > 10_000_000) {
    // return -1;
    // }
    // }
    //
    // return (int)counter;
    //
    // }
}
