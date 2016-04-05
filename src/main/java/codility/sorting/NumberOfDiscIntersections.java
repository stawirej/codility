package codility.sorting;

import java.util.Hashtable;
import java.util.Map;

class NumberOfDiscIntersections {

    public int solution(final int[] A) {

        if (A.length == 0) {
            return 0;
        }

        final Map<Long, Long> intersections = new Hashtable();
        final Map<Long, Long> pairs = new Hashtable();

        for (int centerPoint = 0; centerPoint < A.length; centerPoint++) {
            final long radius = A[centerPoint];
            for (long j = centerPoint - radius; j <= centerPoint + radius; j++) {
                if (intersections.containsKey(j)) {
                    final Long count = intersections.get(j);
                    intersections.put(j, count + 1);
                } else {
                    intersections.put(j, 1L);
                }
            }
        }

        for (final Long key : intersections.keySet()) {
            if (key > 0 && intersections.containsKey(-key)) {
                pairs.put(key, intersections.get(key) - intersections.get(-key));
            }
        }

        long counter = 0;
        for (final Long value : pairs.values()) {
            counter += value;
            if (counter > 10_000_000) {
                return -1;
            }
        }

        return (int)counter;

    }
}
