package codility.prefixsums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenomicRangeQuery {

    public int[] solution(final String S, final int[] P, final int[] Q) {
        final List<Integer> result = new ArrayList<>();
        final Map<Character, Integer> dnaToInt = new HashMap<>();
        dnaToInt.put('A', 1);
        dnaToInt.put('C', 2);
        dnaToInt.put('G', 3);
        dnaToInt.put('T', 4);

        final List<Integer> dna = new ArrayList<>();

        for (final Character character : S.toCharArray()) {
            dna.add(dnaToInt.get(character));
        }

        for (int i = 0; i < P.length; i++) {
            final int startIndex = P[i];
            final int endIndex = Q[i] + 1;
            final List<Integer> integers = dna.subList(startIndex, endIndex);
            final Integer integer = integers.stream().min(Comparator.<Integer>naturalOrder()).get();
            result.add(integer);
        }

        final int[] minimums = new int[result.size()];
        for (int i = 0; i < minimums.length; i++) {
            minimums[i] = result.get(i);
        }

        return minimums;
    }
}
