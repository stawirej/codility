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
        final int[] noDubletsPrefixSums = new int[S.length() + 1];
        final int[] minimums = new int[P.length];

        for (int i = 1; i <= S.length(); i++) {
            final char nucleotide = S.charAt(i - 1);
            final int nucleotideValue = dnaToInt.get(nucleotide);
            prefixSums[i] = prefixSums[i - 1] + nucleotideValue;
        }

        // if (allIdentical) {
        // for (int i = 0; i < minimums.length; i++) {
        // minimums[i] = firstValue;
        // }
        // return minimums;
        // }
        //
        // for (int i = 0; i < P.length; i++) {
        // final int sum = prefixSums[Q[i] + 1] - prefixSums[P[i]];
        // final int average = sum / (Q[i] - P[i] + 1);
        // if (average < 2) {
        // minimums[i] = 1;
        // } else if (average < 3) {
        // int div;
        // minimums[i] = 2;
        // for (int j = P[i]; j <= Q[i]; j++) {
        // div = prefixSums[j + 1] - prefixSums[j];
        // if (div == 1) {
        // minimums[i] = 1;
        // break;
        // }
        // }
        // } else if (average < 4) {
        // int div;
        // int currentSmallest = 4;
        // for (int j = P[i]; j <= Q[i]; j++) {
        // div = prefixSums[j + 1] - prefixSums[j];
        // if (currentSmallest > div) {
        // currentSmallest = div;
        // }
        // }
        // minimums[i] = currentSmallest;
        // } else {
        // minimums[i] = 4;
        // }
        // }

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
