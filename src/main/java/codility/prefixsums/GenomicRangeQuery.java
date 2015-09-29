package codility.prefixsums;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {

    public int[] solution(final String S, final int[] P, final int[] Q) {
        final Map<Character, Integer> dnaToInt = new HashMap<>();
        dnaToInt.put('A', 1);
        dnaToInt.put('C', 2);
        dnaToInt.put('G', 3);
        dnaToInt.put('T', 4);
        final int[] prefixSums = new int[S.length() + 1];
        final int[] minimums = new int[P.length];

        for (int i = 1; i <= S.length(); i++) {
            final char nucleotide = S.charAt(i - 1);
            final int nucleotideValue = dnaToInt.get(nucleotide);
            prefixSums[i] = prefixSums[i - 1] + nucleotideValue;
        }

        for (int i = 0; i < P.length; i++) {
            minimums[i] = prefixSums[Q[i] + 1] - prefixSums[Q[i]];
        }

        return minimums;
    }

    // public int[] solution(final String S, final int[] P, final int[] Q) {
    // final List<Integer> result = new ArrayList<>();
    // final Map<Character, Integer> dnaToInt = new HashMap<>();
    // dnaToInt.put('A', 1);
    // dnaToInt.put('C', 2);
    // dnaToInt.put('G', 3);
    // dnaToInt.put('T', 4);
    //
    // final List<Integer> dna = new ArrayList<>();
    //
    // for (final Character character : S.toCharArray()) {
    // dna.add(dnaToInt.get(character));
    // }
    //
    // for (int i = 0; i < P.length; i++) {
    // final int startIndex = P[i];
    // final int endIndex = Q[i] + 1;
    // final List<Integer> integers = dna.subList(startIndex, endIndex);
    // final Integer integer = integers.stream().min(Comparator.<Integer>naturalOrder()).get();
    // result.add(integer);
    // }
    //
    // final int[] minimums = new int[result.size()];
    // for (int i = 0; i < minimums.length; i++) {
    // minimums[i] = result.get(i);
    // }
    //
    // return minimums;
    // }
}
