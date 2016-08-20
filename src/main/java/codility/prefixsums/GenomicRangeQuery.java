package codility.prefixsums;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class GenomicRangeQuery {

    class Range {

        private final int start;
        private final int end;

        Range(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public int[] solution(final String S, final int[] P, final int[] Q) {
        final Map<String, Integer> dnaToInt = new HashMap<>();
        dnaToInt.put("A", 1);
        dnaToInt.put("C", 2);
        dnaToInt.put("G", 3);
        dnaToInt.put("T", 4);

        final List<Integer> dnas =
            Stream.of(S).map(s -> s.split("")).flatMap(Arrays::stream).map(dnaToInt::get).collect(toList());
        final int[] dna = toIntArray(dnas);
        final int[] minimums = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            minimums[i] = getSmallestForRange(dna, P[i], Q[i]);
        }

        return minimums;
        // -----------------------------------------------
        // final List<Range> ranges = new ArrayList<>();
        // for (int i = 0; i < P.length; i++) {
        // ranges.add(new Range(P[i], Q[i]));
        // }
        //
        // final List<Optional<Integer>> minimums = ranges.parallelStream()
        // .map(range -> dna.subList(range.getStart(), range.getEnd() + 1).stream().min(Comparator.naturalOrder()))
        // .collect(toList());
        //
        // final int[] tmp = new int[minimums.size()];
        // for (int i = 0; i < minimums.size(); i++) {
        // tmp[i] = minimums.get(i).get();
        // }
        // return tmp;
    }

    private int getSmallestForRange(final int[] dna, final int startIndex, final int endIndex) {

        int smallest = 4;
        for (int i = startIndex; i <= endIndex; i++) {
            if (dna[i] == 1) {
                return 1;
            }
            if (dna[i] < smallest) {
                smallest = dna[i];
            }
        }
        return smallest;
    }

    private int[] toIntArray(final List<Integer> list) {
        final int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }
    // public int[] solution(final String S, final int[] P, final int[] Q) {

    // final Map<Character, Integer> dnaToInt = new HashMap<>();
    // dnaToInt.put('A', 1);
    // dnaToInt.put('C', 2);
    // dnaToInt.put('G', 3);
    // dnaToInt.put('T', 4);
    // final int[] prefixSums = new int[S.length() + 1];
    // final int[] noDubletsPrefixSums = new int[S.length() + 1];
    // final int[] minimums = new int[P.length];
    //
    // for (int i = 1; i <= S.length(); i++) {
    // final char nucleotide = S.charAt(i - 1);
    // final int nucleotideValue = dnaToInt.get(nucleotide);
    // prefixSums[i] = prefixSums[i - 1] + nucleotideValue;
    // }

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

    // return minimums;
    // }

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
