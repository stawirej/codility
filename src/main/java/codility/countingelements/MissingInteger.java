package codility.countingelements;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Peter on 2015-05-30.
 */
public class MissingInteger {

    public int solution(final int[] A) {
        final SortedSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0 || A[i] > 100000) {
                continue;
            }
            set.add(A[i]);
        }

        if (set.size() > 0) {
            final Iterator<Integer> iterator = set.iterator();
            for (int i = 0; i < set.size(); i++) {
                if (iterator.next() != i + 1) {
                    return i + 1;
                }
            }

            final long fullSum = ((long) set.size() + 2) * ((long) set.size() + 1) / 2;
            final long sum = ((long) set.last() + 1) * ((long) set.last()) / 2;
            return (int) (fullSum - sum);
        } else {
            return 1;
        }
    }
}
