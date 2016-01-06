package codility.iterations;

public class BinaryGap {

    public int solution(final int N) {
        String binary = Integer.toBinaryString(N);
        if (binary.lastIndexOf('1') < binary.length() - 1) {
            binary = binary.substring(0, binary.lastIndexOf('1') + 1);
        }

        int gapLength = 0;
        int maxGapLength = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                gapLength++;
            }
            if (binary.charAt(i) == '1') {
                if (gapLength > maxGapLength) {
                    maxGapLength = gapLength;
                }
                gapLength = 0;
            }
        }

        return maxGapLength;
    }
}
